package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

}
