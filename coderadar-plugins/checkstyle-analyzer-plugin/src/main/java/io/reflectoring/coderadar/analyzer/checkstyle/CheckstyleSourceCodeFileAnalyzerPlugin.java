package io.reflectoring.coderadar.analyzer.checkstyle;

import com.puppycrawl.tools.checkstyle.Checker;
import com.puppycrawl.tools.checkstyle.ConfigurationLoader;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.Configuration;
import io.reflectoring.coderadar.plugin.api.*;
import java.io.*;
import java.util.Collections;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

public class CheckstyleSourceCodeFileAnalyzerPlugin
    implements SourceCodeFileAnalyzerPlugin, ConfigurableAnalyzerPlugin {

  private Logger logger = LoggerFactory.getLogger(CheckstyleSourceCodeFileAnalyzerPlugin.class);
  private final CheckstyleMetricDescriptions metricDescriptions =
      new CheckstyleMetricDescriptions();

  private Checker checker;

  private CoderadarAuditListener auditListener;

  public CheckstyleSourceCodeFileAnalyzerPlugin() {
    try {
      init(createDefaultConfiguration());
    } catch (CheckstyleException e) {
      throw new AnalyzerException(e);
    }
  }

  private void init(Configuration configuration) {
    checker = new Checker();
    try {
      auditListener = new CoderadarAuditListener();
      final ClassLoader moduleClassLoader = Checker.class.getClassLoader();
      checker.setModuleClassLoader(moduleClassLoader);
      checker.configure(configuration);
      checker.addListener(auditListener);
    } catch (CheckstyleException e) {
      throw new AnalyzerConfigurationException(e);
    }
  }

  @Override
  public AnalyzerFileFilter getFilter() {
    return filename -> filename.endsWith(".java");
  }

  private Configuration createDefaultConfiguration() throws CheckstyleException {
    return getConfigurationFromStream(getClass().getResourceAsStream("/checkstyle.xml"));
  }

  @Override
  public FileMetrics analyzeFile(String filename, byte[] fileContent) throws AnalyzerException {
    File fileToAnalyze = null;
    try {
      fileToAnalyze = createTempFile(fileContent);
      auditListener.reset();
      checker.process(Collections.singletonList(fileToAnalyze));
      return auditListener.getMetrics();
    } catch (CheckstyleException | IOException e) {
      throw new AnalyzerException(e);
    } finally {
      if (fileToAnalyze != null && !fileToAnalyze.delete()) {
        logger.warn("Could not delete temporary file {}", fileToAnalyze);
      }
    }
  }

  @Override
  public String getMetricDescription(String metricName) {
    String[] temp = metricName.split("\\.");
    return metricDescriptions.get(temp[temp.length - 1]);
  }

  private File createTempFile(byte[] fileContent) throws IOException {
    File file = File.createTempFile("coderadar-", ".java");
    file.deleteOnExit();
    FileOutputStream out = new FileOutputStream(file);
    out.write(fileContent);
    out.close();
    return file;
  }

  @Override
  public boolean isValidConfigurationFile(byte[] configurationFile) {
    try {
      getConfigurationFromStream(new ByteArrayInputStream(configurationFile));
      return true;
    } catch (CheckstyleException e) {
      return false;
    }
  }

  private Configuration getConfigurationFromStream(InputStream in) throws CheckstyleException {
    return ConfigurationLoader.loadConfiguration(
        new InputSource(in),
        new CheckstylePropertiesResolver(new Properties()), // TODO: pass real properties
        true);
  }

  @Override
  public void configure(byte[] configurationFile) {
    try {
      init(getConfigurationFromStream(new ByteArrayInputStream(configurationFile)));
    } catch (CheckstyleException e) {
      throw new AnalyzerException(e);
    }
  }
}
