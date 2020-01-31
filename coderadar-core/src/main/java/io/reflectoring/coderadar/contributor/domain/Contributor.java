package io.reflectoring.coderadar.contributor.domain;

import io.reflectoring.coderadar.projectadministration.domain.File;
import io.reflectoring.coderadar.projectadministration.domain.Project;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class Contributor {
  private Long id;
  private Set<String> names;
  private String email;
  private List<Project> projects;
  private List<File> files;
}
