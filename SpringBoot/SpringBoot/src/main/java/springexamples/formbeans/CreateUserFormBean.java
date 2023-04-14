package springexamples.formbeans;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {

    @NotEmpty(message = "Full Name must not be empty.")
    private String fullName;

    @NotEmpty(message = "Email must not be empty.")
    private String email;

    @NotEmpty(message = "Password must not be empty.")
    private String password;

    @NotEmpty(message = "Confirm Password must not be empty.")
    private String confirmPassword;

}
