package io.reflectoring.coderadar.rest.analyzing;

import io.reflectoring.coderadar.analyzer.port.driver.GetAnalyzingStatusUseCase;
import io.reflectoring.coderadar.rest.domain.GetAnalyzingStatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class GetAnalyzingStatusController {
  private final GetAnalyzingStatusUseCase getAnalyzingStatusUseCase;

  public GetAnalyzingStatusController(GetAnalyzingStatusUseCase getAnalyzingStatusUseCase) {
    this.getAnalyzingStatusUseCase = getAnalyzingStatusUseCase;
  }

  @GetMapping(path = "/projects/{projectId}/analyzingStatus")
  public ResponseEntity<GetAnalyzingStatusResponse> getProjectAnalyzingStatus(
      @PathVariable("projectId") long projectId) {
    return new ResponseEntity<>(
        new GetAnalyzingStatusResponse(getAnalyzingStatusUseCase.getStatus(projectId)),
        HttpStatus.OK);
  }
}
