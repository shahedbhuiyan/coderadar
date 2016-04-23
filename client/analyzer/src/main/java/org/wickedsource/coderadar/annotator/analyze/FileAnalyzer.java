package org.wickedsource.coderadar.annotator.analyze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wickedsource.coderadar.analyzer.api.AnalyzerFileFilter;
import org.wickedsource.coderadar.analyzer.api.FileAnalyzerPlugin;
import org.wickedsource.coderadar.analyzer.api.FileMetrics;

import java.util.List;

/**
 * Combines multiple AnalyzerPlugins to calculate metrics for a single file.
 */
public class FileAnalyzer {

    private Logger logger = LoggerFactory.getLogger(FileAnalyzer.class);

    /**
     * Analyzes a single file. Lets all AnalyzerPlugins run over the given file to calculate their metrics. The aggregated
     * metrics are returned.
     *
     * @param analyzerPlugins the analyzers to calculate metrics for the given file.
     * @param filePath        the path of the file to be analyzed (only needed for purpose of meaningful log messages)
     * @param fileContent     the content of the file to be analyzed
     * @return the metrics calculated by all AnalyzerPlugins.
     */
    public FileMetrics analyzeFile(List<FileAnalyzerPlugin> analyzerPlugins, String filePath, byte[] fileContent) {
        logger.debug("analyzing file {}", filePath);
        FileMetrics fileMetrics = new FileMetrics();
        for (FileAnalyzerPlugin analyzerPlugin : analyzerPlugins) {
            if (analyzerPlugin.getFilter() == null) {
                throw new IllegalStateException(String.format("Analyzer %s returns an empty AnalyzerFilter! All Analyzers MUST return a valid filter!", analyzerPlugin.getClass()));
            }
            if (acceptFile(analyzerPlugin.getFilter(), filePath)) {
                try {
                    fileMetrics.add(analyzerPlugin.analyzeFile(fileContent));
                } catch (Exception e) {
                    // catching all exceptions since the plugin is potentially evil
                    logger.warn(String.format("Analyzer of class %s threw an exception while analyzing the file %s ... skipping this analyzer.", analyzerPlugin.getClass().getName(), filePath), e);
                }
            }
        }
        return fileMetrics;
    }

    private boolean acceptFile(AnalyzerFileFilter filter, String filePath) {
        return (filter.acceptBinary() | !isBinary(filePath)) && filter.acceptFilename(filePath);
    }

    /**
     * Determines whether the given file is in binary format.
     */
    private boolean isBinary(String filePath) {
        // TODO: analyze the first couple bytes of the file to determine if it's binary
        return false;
    }

}