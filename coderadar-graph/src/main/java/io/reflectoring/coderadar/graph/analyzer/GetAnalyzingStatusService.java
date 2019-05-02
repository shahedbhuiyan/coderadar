package io.reflectoring.coderadar.graph.analyzer;

import io.reflectoring.coderadar.core.analyzer.AnalyzingJobNotStartedException;
import io.reflectoring.coderadar.core.analyzer.domain.AnalyzingJob;
import io.reflectoring.coderadar.core.analyzer.port.driven.GetAnalyzingStatusPort;
import io.reflectoring.coderadar.core.projectadministration.AnalyzerConfigurationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetAnalyzingStatusService implements GetAnalyzingStatusPort {
    private final GetAnalyzingStatusRepository getAnalyzingStatusRepository;

    @Autowired
    public GetAnalyzingStatusService(GetAnalyzingStatusRepository getAnalyzingStatusRepository) {
        this.getAnalyzingStatusRepository = getAnalyzingStatusRepository;
    }

    @Override
    public Optional<AnalyzingJob> get(Long projectId) {
        return getAnalyzingStatusRepository.findByProject_Id(projectId);
    }
}
