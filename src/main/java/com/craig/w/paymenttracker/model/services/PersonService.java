package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.entities.PersonWithTotalPaid;
import com.craig.w.paymenttracker.model.repositories.PaymentRepository;
import com.craig.w.paymenttracker.model.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PersonWithTotalPaid> getPeopleWithTotalPaidByHolidayId(Integer holidayId) {
        List<Person> people = personRepository.findByHolidayId(holidayId);
        return people.stream().map(person -> {
            BigDecimal totalPaid = person.getPayments().stream()
                    .map(Payment::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return new PersonWithTotalPaid(person, totalPaid);
        }).collect(Collectors.toList());
    }

    public Person findPersonById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> findPeopleByHolidayId(Integer holidayId) {
        return personRepository.findByHolidayId(holidayId);
    }
@Transactional
    public void addPayment(Integer personId, BigDecimal amount, LocalDate paymentDate) {

        Person person = personRepository.findById(personId).orElse(null);
        if (person != null) {
            Payment payment = new Payment();
            payment.setAmount(amount);
            payment.setPerson(person);
            payment.setPaymentDate(paymentDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            paymentRepository.save(payment);

            person.setToPay(person.getToPay().subtract(amount));
            personRepository.save(person);
        }
    }





    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }
}
