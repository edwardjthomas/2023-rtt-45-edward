package springexamples.formbeans;

// why am i doing this rather than using the database?
// that's the thing, you can't
// it's better to copy this way?

// but in our own words, what does this do?
// it appears to help us fill out forms that we make in our jsp
// for the sake of this example, this is us setting what we need for create.jsp

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexamples.validation.EmailUnique;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    // adding private integer called id so that we can submit our edits
    // it's to be a hidden input field
    private Integer id;

    // @NotNull is valid if the value is not null or if the value is "" (4/11)
    // @NotEmpty is valid if the value is not null and if the value is not "" and if
    // the value length > 0
    // @Length
    // @Pattern
    // if you want to search for anything look into JSR 303
    // it helps to at least input a @Length
    // best way to be safe about securing database things would be through the
    // formbean (here)
    @NotEmpty(message = "Email address is required.")
    @Length(max = 100, message = "Email cannot be longer than 100 characters")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email format")
    @EmailUnique(message = "Email already exists in database")
    private String email;

    @NotEmpty(message = "First Name is required.")
    @Length(max = 40, message = "First name cannot be longer than 40 characters")
    private String firstName;

    @NotEmpty(message = "Last Name is required.")
    @Length(max = 40, message = "First name cannot be longer than 40 characters")
    private String lastName;

    @Length(max = 40, message = "First name cannot be longer than 40 characters")
    private String jobTitle;

    private String extension;

    private String profileImage;

    @Max(value = 100, message = "You can not have more than 100 vacation hours.")
    @Min(value = 0, message = "You can not have less than 0 vacation hours.")
    private Integer vacationHours;

    // will need to add officeid here as well
    private Integer officeId;

}
