package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/people/{id}")
    public String getPerson(@PathVariable Integer id, Model model) {
        Person person = personService.findPersonById(id);
        model.addAttribute("person", person);
        return "personDetails";
    }


    @RequestMapping("/allpeople")
    public Iterable<Person> getAllPeople() {
        return personService.findAll();
    }


}
