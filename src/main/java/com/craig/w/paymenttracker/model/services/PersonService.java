package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.repositories.PaymentRepository;
import com.craig.w.paymenttracker.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PaymentRepository paymentRepository;



    public Person findPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> findPeopleByHolidayId(Integer holidayId) {
        return personRepository.findByHolidayId(holidayId);
    }

    public void addPayment(Integer personId, BigDecimal amount) {

        Person person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setPerson(person);
            paymentRepository.save(payment);

            person.setToPay(person.getToPay().subtract(amount));
            personRepository.save(person);
        }
    }





    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}
