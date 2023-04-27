package com.teksystems.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

// created (4/11) for custom email validation to prevent that stack trace 500 error
// considered boilerplate
// only need to change the Impl class you see on @Constraint
// and "{UserEmailUnique}"

@Documented
@Constraint(validatedBy = UsernameUniqueImpl.class) // it's being implemented by the other class in the folder
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME) // only to last during the run time
public @interface UsernameUnique { // @interface is saying it's a new annotation

    String message() default "{UserUsernameUnique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
