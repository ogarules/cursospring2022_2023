package com.example.demo.ejercicio30.parte2.customValidators;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.demo.ejercicio30.parte2.models.Contact;

@Component
public class ContactFormValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Contact.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contact contactForm = (Contact) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Enter your name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "", "Select your gender");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Enter your password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "", "Enter the confirmation password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tutor", "", "You must select your tutor");

        if(!contactForm.getEmail().matches(EMAIL_PATTERN)){
            errors.rejectValue("email", "", "Enter a valid email");
        }

        if(!contactForm.getPassword().equals(contactForm.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "", "The confirmation password must be the same than the provided password");
        }

        List<String> courses = contactForm.getCourses();

        if(courses == null || courses.size() < 2){
            errors.rejectValue("courses", "", "Select atl least two courses");
        }
    }
    
}
