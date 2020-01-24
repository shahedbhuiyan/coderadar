package io.reflectoring.coderadar.graph.query.adapter;

import io.reflectoring.coderadar.graph.analyzer.repository.CommitRepository;
import io.reflectoring.coderadar.graph.query.domain.MetricValueForCommitQueryResult;
import io.reflectoring.coderadar.graph.query.repository.MetricQueryRepository;
import io.reflectoring.coderadar.projectadministration.CommitNotFoundException;
import io.reflectoring.coderadar.query.domain.MetricValueForCommit;
import io.reflectoring.coderadar.query.port.driven.GetMetricValuesOfCommitPort;
import io.reflectoring.coderadar.query.port.driver.GetMetricsForCommitCommand;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetMetricValuesOfCommitAdapter implements GetMetricValuesOfCommitPort {

  private final MetricQueryRepository metricQueryRepository;
  private final CommitRepository commitRepository;

  public GetMetricValuesOfCommitAdapter(
      MetricQueryRepository metricQueryRepository, CommitRepository commitRepository) {
    this.metricQueryRepository = metricQueryRepository;
    this.commitRepository = commitRepository;
  }

  @Override
  public MetricValueForCommit[] get(GetMetricsForCommitCommand command, Long projectId) {
    long commitTimestamp =
        commitRepository
            .findTimeStampByNameAndProjectId(command.getCommit(), projectId)
            .orElseThrow(() -> new CommitNotFoundException(command.getCommit()));
    List<MetricValueForCommitQueryResult> result =
        metricQueryRepository.getMetricValuesForCommit(
            projectId, command.getMetrics(), commitTimestamp);
    MetricValueForCommit[] values = new MetricValueForCommit[result.size()];
    for (int i = 0; i < result.size(); ++i) {
      MetricValueForCommitQueryResult queryResult = result.get(i);
      values[i] = new MetricValueForCommit(queryResult.getName(), queryResult.getValue());
    }
    return values;
  }
}
