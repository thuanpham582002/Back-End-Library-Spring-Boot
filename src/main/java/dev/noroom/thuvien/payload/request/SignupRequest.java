package dev.noroom.thuvien.payload.request;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.context.annotation.Role;

import java.util.Set;

@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  private String role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
}
