package io.reflectoring.coderadar.rest.integration.module;

import static io.reflectoring.coderadar.rest.integration.JsonHelper.fromJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import io.reflectoring.coderadar.graph.projectadministration.module.repository.CreateModuleRepository;
import io.reflectoring.coderadar.graph.projectadministration.project.repository.CreateProjectRepository;
import io.reflectoring.coderadar.projectadministration.domain.Module;
import io.reflectoring.coderadar.projectadministration.domain.Project;
import io.reflectoring.coderadar.projectadministration.port.driver.module.create.CreateModuleCommand;
import io.reflectoring.coderadar.rest.IdResponse;
import io.reflectoring.coderadar.rest.integration.ControllerTestTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class CreateModuleControllerIntegrationTest extends ControllerTestTemplate {

  @Autowired private CreateProjectRepository createProjectRepository;
  @Autowired private CreateModuleRepository createModuleRepository;

  @Test
  void createModuleSuccessfully() throws Exception {
    // Set up
    Project testProject = new Project();
    testProject.setVcsUrl("https://valid.url");
    testProject = createProjectRepository.save(testProject);

    // Test
    CreateModuleCommand command = new CreateModuleCommand("module-path");
    mvc()
        .perform(
            post("/projects/" + testProject.getId() + "/modules")
                .content(toJson(command))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andDo(
            result -> {
              Long id =
                  fromJson(result.getResponse().getContentAsString(), IdResponse.class).getId();
              Module module = createModuleRepository.findById(id).get();
              Assertions.assertEquals("module-path", module.getPath());
            });
  }

  @Test
  void createModuleReturnsErrorWhenProjectNotFound() throws Exception {
    CreateModuleCommand command = new CreateModuleCommand("module-path");
    mvc()
        .perform(
            post("/projects/1/modules")
                .content(toJson(command))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNotFound())
        .andExpect(
            MockMvcResultMatchers.jsonPath("errorMessage").value("Project with id 1 not found."));
  }

  @Test
  void createModuleReturnsErrorWhenRequestIsInvalid() throws Exception {
    CreateModuleCommand command = new CreateModuleCommand("");
    mvc()
        .perform(
            post("/projects/0/modules")
                .content(toJson(command))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }
}
