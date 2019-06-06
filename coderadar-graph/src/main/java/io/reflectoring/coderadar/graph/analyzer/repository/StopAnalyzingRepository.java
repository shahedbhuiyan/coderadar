package io.reflectoring.coderadar.graph.analyzer.repository;

import io.reflectoring.coderadar.analyzer.domain.AnalyzingJob;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopAnalyzingRepository extends Neo4jRepository<AnalyzingJob, Long> {}
