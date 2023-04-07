package springexamples.formbeans;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {


    private String fullName;

    private String email;

    private String password;

    private String confirmPassword;

}
