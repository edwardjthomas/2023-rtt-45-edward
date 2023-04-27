package com.teksystems.formbeans;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFormBean {

    private Integer id;

    @NotBlank(message = "Value cannot be blank.")
    @NotEmpty(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "Value cannot be blank.")
    @NotEmpty(message = "Password must not be empty")
    private String password;

    @NotBlank(message = "Value cannot be blank.")
    @NotEmpty(message = "Confirm Password must not be empty.")
    private String confirmPassword;

    @NotBlank(message = "Value cannot be blank.")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotBlank(message = "Value cannot be blank.")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email format")
    @NotEmpty(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Value cannot be blank.")
    private String preferredContact;
}
