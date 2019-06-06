package io.reflectoring.coderadar.rest.project;

import io.reflectoring.coderadar.projectadministration.ProjectNotFoundException;
import io.reflectoring.coderadar.projectadministration.port.driver.project.get.GetProjectUseCase;
import io.reflectoring.coderadar.rest.ErrorMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProjectController {
  private final GetProjectUseCase getProjectUseCase;

  @Autowired
  public GetProjectController(GetProjectUseCase getProjectUseCase) {
    this.getProjectUseCase = getProjectUseCase;
  }

  @GetMapping(path = "/projects/{projectId}")
  public ResponseEntity getProject(@PathVariable Long projectId) {
    try {
      return new ResponseEntity<>(getProjectUseCase.get(projectId), HttpStatus.OK);
    } catch (ProjectNotFoundException e) {
      return new ResponseEntity<>(new ErrorMessageResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }
  }
}
