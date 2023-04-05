package springexamples.formbeans;

// why am i doing this rather than using the database?
// that's the thing, you can't
// it's better to copy this way?

// but in our own words, what does this do?
// it appears to help us fill out forms that we make in our jsp
// for the sake of this example, this is us setting what we need for create.jsp

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeFormBean {

    // adding private integer called id so that we can submit our edits
    // it's to be a hidden input field
    private Integer id;

    private String email;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private String extension;

    private String profileImage;

    private Integer vacationHours;

    // will need to add officeid here as well
    private Integer officeId;

}
