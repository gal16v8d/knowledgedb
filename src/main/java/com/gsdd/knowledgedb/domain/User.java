package com.gsdd.knowledgedb.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

  private UUID userCode;

  @NotBlank(message = "Firstname can not be empty")
  @Size(min = 4, max = 32, message = "Firstname should be between 4 and 32 characters")
  private String firstName;

  @NotBlank(message = "Lastname can not be empty")
  @Size(min = 4, max = 32, message = "Lastname should be between 4 and 32 characters")
  private String lastName;

  @NotBlank(message = "Alias can not be empty")
  @Size(min = 4, max = 32, message = "Alias should be between 4 and 32 characters")
  private String alias;

  @NotBlank(message = "Password can not be empty")
  @Size(min = 4, max = 32, message = "Password should be between 4 and 32 characters")
  @Pattern(regexp = "^[A-Za-z0-9\\s]+$", message = "Just numbers, letters or space allowed")
  private String password;

  private Boolean status;
}
