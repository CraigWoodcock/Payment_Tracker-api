package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.repositories.PersonRepository;
import com.craig.w.paymenttracker.model.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping("/allpeople")
    public Iterable<Person> getAllPeople() {
        return personService.findAll();
    }


}
