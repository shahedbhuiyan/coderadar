package io.reflectoring.coderadar.rest.integration.user;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import io.reflectoring.coderadar.core.projectadministration.domain.User;
import io.reflectoring.coderadar.core.projectadministration.port.driver.user.login.LoginUserCommand;
import io.reflectoring.coderadar.core.projectadministration.service.user.security.PasswordUtil;
import io.reflectoring.coderadar.graph.projectadministration.user.repository.RegisterUserRepository;
import io.reflectoring.coderadar.rest.integration.ControllerTestTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

class LoginUserControllerIntegrationTest extends ControllerTestTemplate {
  @Autowired private RegisterUserRepository registerUserRepository;

  @Test
  void loginUserSuccessfully() throws Exception {
    registerUserRepository.deleteAll();
    User testUser = new User();
    testUser.setUsername("username");
    testUser.setPassword(PasswordUtil.hash("password1"));
    registerUserRepository.save(testUser);

    LoginUserCommand command = new LoginUserCommand("username", "password1");
    mvc()
        .perform(
            post("/user/auth").content(toJson(command)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("accessToken").value(any(String.class)))
        .andExpect(MockMvcResultMatchers.jsonPath("refreshToken").value(any(String.class)));
  }

  @Test
  void loginUserReturnsErrorWhenRequestIsInvalid() throws Exception {
    LoginUserCommand command = new LoginUserCommand("username", "password");
    mvc()
        .perform(
            post("/user/auth").content(toJson(command)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  void loginUserReturnsErrorWhenUserDoesNotExist() throws Exception {
    registerUserRepository.deleteAll();

    LoginUserCommand command = new LoginUserCommand("username", "password");
    mvc()
        .perform(
            post("/user/auth").content(toJson(command)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
  }

  @Test
  void loginUserReturnsErrorWhenPasswordIsWrong() throws Exception {
    // Set up
    registerUserRepository.deleteAll();
    User testUser = new User();
    testUser.setUsername("username2");
    testUser.setPassword(PasswordUtil.hash("password1"));
    registerUserRepository.save(testUser);

    // Test
    LoginUserCommand command = new LoginUserCommand("username2", "password3");
    mvc()
        .perform(
            post("/user/auth").content(toJson(command)).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content().string("Bad credentials"))
        .andExpect(MockMvcResultMatchers.status().isForbidden());
  }
}
