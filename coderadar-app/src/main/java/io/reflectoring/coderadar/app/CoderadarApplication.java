package io.reflectoring.coderadar.app;

import io.reflectoring.coderadar.core.projectadministration.service.user.security.CoderadarSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@EnableAsync(proxyTargetClass = true)
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties
@EntityScan(basePackages = "io.reflectoring.coderadar")
@SpringBootApplication(scanBasePackages = "io.reflectoring.coderadar")
public class CoderadarApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoderadarApplication.class, args);
  }
}
