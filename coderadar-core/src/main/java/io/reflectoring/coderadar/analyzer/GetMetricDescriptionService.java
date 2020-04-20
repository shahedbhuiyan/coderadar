package io.reflectoring.coderadar.analyzer;

import io.reflectoring.coderadar.analyzer.service.AnalyzerPluginService;
import io.reflectoring.coderadar.plugin.api.SourceCodeFileAnalyzerPlugin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetMetricDescriptionService {

  private final AnalyzerPluginService analyzerPluginService;
  private final List<SourceCodeFileAnalyzerPlugin> analyzerPlugins;

  public GetMetricDescriptionService(AnalyzerPluginService analyzerPluginService) {
    this.analyzerPluginService = analyzerPluginService;
    analyzerPlugins = getAllAnalyzers();
  }

  private List<SourceCodeFileAnalyzerPlugin> getAllAnalyzers() {
    List<SourceCodeFileAnalyzerPlugin> analyzers = new ArrayList<>();
    for (String name : analyzerPluginService.getAvailableAnalyzers()) {
      analyzers.add(analyzerPluginService.createAnalyzer(name));
    }
    return analyzers;
  }

  public String getMetricDescription(String name) {
    String result = null;
    var it = analyzerPlugins.iterator();
    while (result == null && it.hasNext()) {
      result = it.next().getMetricDescription(name);
    }
    return result;
  }
}
