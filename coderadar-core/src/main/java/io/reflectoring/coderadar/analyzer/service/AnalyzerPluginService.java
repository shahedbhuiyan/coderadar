package io.reflectoring.coderadar.analyzer.service;

import io.reflectoring.coderadar.plugin.api.ConfigurableAnalyzerPlugin;
import io.reflectoring.coderadar.plugin.api.SourceCodeFileAnalyzerPlugin;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnalyzerPluginService {
  private Logger logger = LoggerFactory.getLogger(AnalyzerPluginService.class);

  private Map<String, Class<? extends SourceCodeFileAnalyzerPlugin>> sourceCodeFileAnalyzerPlugins =
      new HashMap<>();

  /**
   * Constructs a new AnalyzerPluginRegistry. This is a very expensive operation since the
   * AnalyzerPluginRegistry scans the whole classpath for implementations of the
   * SourceCodeFileAnalyzer interface!
   */
  public AnalyzerPluginService() {
    initRegistry("io.reflectoring.coderadar");
  }

  /**
   * Alternative constructor for scanning a specified package (and its sub-packages) only instead of
   * the whole classpath.
   *
   * @param packageName the package to scan for analyzer plugins.
   */
  public AnalyzerPluginService(String packageName) {
    initRegistry(packageName);
  }

  public List<String> getAvailableAnalyzers() {
    List<String> analyzerList = new ArrayList<>(sourceCodeFileAnalyzerPlugins.keySet());
    analyzerList.sort(String::compareTo);
    return analyzerList;
  }

  /**
   * Creates a new instance of the analyzer with the specified name. Does not invoke the configure()
   * method of ConfigurationAnalyzerPlugins. Throws an IllegalArgumentException if the analyzer is
   * not registered.
   */
  public SourceCodeFileAnalyzerPlugin createAnalyzer(String analyzerName) {
    try {
      if (!isAnalyzerRegistered(analyzerName)) {
        throw new IllegalArgumentException(
            String.format("Analyzer with name %s is not registered!", analyzerName));
      }
      Class<? extends SourceCodeFileAnalyzerPlugin> pluginClass =
          sourceCodeFileAnalyzerPlugins.get(analyzerName);
      return pluginClass.getDeclaredConstructor().newInstance();
    } catch (InstantiationException
        | IllegalAccessException
        | NoSuchMethodException
        | InvocationTargetException e) {
      throw new IllegalStateException(
          String.format("Could not instantiate analyzer plugin %s", analyzerName));
    }
  }

  /**
   * Creates a new instance of the analyzer with the specified name and invokes its configure
   * method. The analyzer must implement the ConfigurableAnalyzerPlugin interface, otherwise an
   * IllegalArgumentException will be thrown.
   *
   * @param analyzerName the name of the analyzer to instantiate
   * @param configurationFile the configuration file to be passed into the analyzer. If the
   *     configuration file is not valid, an IllegalArgumentException will be thrown.
   */
  public SourceCodeFileAnalyzerPlugin createAnalyzer(
      String analyzerName, byte[] configurationFile) {
    SourceCodeFileAnalyzerPlugin analyzer = createAnalyzer(analyzerName);
    checkImplementsConfigurableInterface(analyzer);
    ConfigurableAnalyzerPlugin configurableAnalyzer = (ConfigurableAnalyzerPlugin) analyzer;
    checkValidConfigurationFile(configurableAnalyzer, configurationFile);
    configurableAnalyzer.configure(configurationFile);
    return (SourceCodeFileAnalyzerPlugin) configurableAnalyzer;
  }

  private void checkValidConfigurationFile(
      ConfigurableAnalyzerPlugin configurableAnalyzer, byte[] configurationFile) {
    if (!configurableAnalyzer.isValidConfigurationFile(configurationFile)) {
      try {
        InputStreamReader reader =
            new InputStreamReader(new ByteArrayInputStream(configurationFile));
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder firstCoupleLines = new StringBuilder("");
        for (int i = 0; i < 5; i++) {
          String line = bufferedReader.readLine();
          if (line != null) {
            firstCoupleLines.append(bufferedReader.readLine());
          }
        }
        throw new IllegalArgumentException(
            String.format(
                "Not a valid configuration file for analyzer plugin %s. The first couple lines of configuration file are:\n %s",
                configurableAnalyzer.getClass(), firstCoupleLines.toString()));
      } catch (IOException e) {
        throw new IllegalArgumentException(
            String.format(
                "Not a valid configuration file for analyzer plugin %s.",
                configurableAnalyzer.getClass()));
      }
    }
  }

  private void checkImplementsConfigurableInterface(SourceCodeFileAnalyzerPlugin analyzer) {
    if (!(analyzer instanceof ConfigurableAnalyzerPlugin)) {
      throw new IllegalArgumentException(
          String.format(
              "Analyzer plugin %s does not implement the interface %s and therefore cannot be configured!",
              analyzer.getClass(), ConfigurableAnalyzerPlugin.class));
    }
  }

  /** Checks whether an analyzer with the given name is registered. */
  private boolean isAnalyzerRegistered(String analyzerName) {
    return sourceCodeFileAnalyzerPlugins.get(analyzerName) != null;
  }

  private void initRegistry(String packageName) {
    Reflections reflections;
    if (packageName == null) {
      reflections = new Reflections();
    } else {
      reflections = new Reflections(packageName);
    }
    Set<Class<? extends SourceCodeFileAnalyzerPlugin>> foundPlugins =
        reflections.getSubTypesOf(SourceCodeFileAnalyzerPlugin.class);
    for (Class<? extends SourceCodeFileAnalyzerPlugin> pluginClass : foundPlugins) {
      this.sourceCodeFileAnalyzerPlugins.put(pluginClass.getName(), pluginClass);
      logger.info("registered analyzer plugin {}", pluginClass);
    }
  }
}
