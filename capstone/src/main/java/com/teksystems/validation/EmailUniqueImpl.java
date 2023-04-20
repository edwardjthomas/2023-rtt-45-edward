package com.teksystems.validation;

import com.teksystems.database.dao.UserDAO;
import com.teksystems.database.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// created (4/11) for custom email validation to prevent that stack trace 500 error
// hey go look for this email and if it exists stop the person from creating a account with this information
// if you don't see anything in the database then let the account creation happen
@Slf4j
public class EmailUniqueImpl implements ConstraintValidator<EmailUnique, String> {

    public static final Logger LOG = LoggerFactory.getLogger(EmailUniqueImpl.class);

    // not the same as eric's push
    // have to change userDAO and user to employeedao and employee to work for our own example
    @Autowired
    private UserDAO userDAO;

    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        boolean valid = existsExample2(value);

        log.debug("Email " + value + " exists = " + valid);

        // we want this validation to return true if the email is NOT in the database

        return valid;
    }

    public boolean existsExample2(String value) {
        // in this method we have used a spring data jpa function to see if the email exists
        boolean exists = userDAO.existsByEmail(value);
        return !exists;
    }

    public boolean existsExample1(String value) {
        // if a record returns it means they exist in the database
        // if null then the user does not exist

        User user = userDAO.findByEmail(value);

        // if the result is true then the validation passes
        // so if the user returned from the query is null then we pass the validation
        return (user == null);
    }

}