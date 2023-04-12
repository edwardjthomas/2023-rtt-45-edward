package springexamples.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// created (4/11) for custom email validation to prevent that stack trace 500 error
// considered boilerplate
// only need to change the Impl class you see on @Constraint
// and "{UserEmailUnique}"

@Documented
@Constraint(validatedBy = EmailUniqueImpl.class) // it's being implemented by the other class in the folder
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) // only to last during the run time
public @interface EmailUnique {  // @interface is saying it's a new annotation

    String message() default "{UserEmailUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
