package com.example.demo.ejercicio30.parte2.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.ejercicio30.parte2.customValidators.ContactFormValidator;
import com.example.demo.ejercicio30.parte2.models.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/contact")
@SessionAttributes({"contactForm", "confirmationId"})
public class ContactController {
    
    @Autowired
    private ContactFormValidator contactValidator;

    @InitBinder(value = "contactForm")
    private void configInitBinder(WebDataBinder binder){
        binder.setValidator(contactValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getContactForm(Model model){
        log.info("Loading contact form");
        Contact contactForm = new Contact();

        contactForm.setHiddenMessage("contact-form-1");
        model.addAttribute("contactForm", contactForm);

        return "contactForm/contact_form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @Valid @ModelAttribute("contactForm") Contact contactForm, BindingResult result){
        log.info("Contact form submited");

        if(result.hasErrors()){
            return "contactForm/contact_form";
        }

        String confirmationId = "5";
        model.addAttribute("confirmationId", confirmationId);
        model.addAttribute("contactForm", contactForm);

        log.info("submition completed", confirmationId);

        return "redirect:/contact/success";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String successProcess(@ModelAttribute("contactForm") Contact contactForm){
        log.info("Success process");

        return "contactForm/show_data";
    }

    @ModelAttribute("availableCourses")
    public List<String> availableCourses(){
        List<String> courses = new ArrayList<>();

        courses.add("Java");
        courses.add("C#");
        courses.add("Python");
        courses.add("NodeJS");
        courses.add("Angular");
        courses.add("PHP");

        return courses;
    }

    @ModelAttribute("availableTutors")
    public List<String> availableTutors(){
        List<String> tutors = new ArrayList<>();

        tutors.add("MR OGA");
        tutors.add("MR Bruce Wayne");
        tutors.add("MR Kent");

        return tutors;
    }

    @ModelAttribute("genders")
    public List<String> genders(){
        List<String> genders = new ArrayList<>();

        genders.add("Female");
        genders.add("Male");

        return genders;
    }

}
