package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.repositories.HolidayRepository;
import com.craig.w.paymenttracker.model.repositories.PaymentRepository;
import com.craig.w.paymenttracker.model.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Holiday> findAllHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday findHolidayById(Integer id) {
        return holidayRepository.findById(id).orElse(null);
    }

    public void saveHoliday(Holiday holiday) {

        holidayRepository.save(holiday);
    }

    public Optional<Holiday> getHolidayByName(String name) {
        return holidayRepository.findAllByName(name);
    }

    public void createHoliday(String name, BigDecimal totalAmount, int numPeople, String personNames) {
        Holiday holiday = new Holiday();

        holiday.setName(name);
        holiday.setTotalAmount(totalAmount);
        holiday.setNumPeople(numPeople);
        Holiday savedHoliday = holidayRepository.save(holiday);

        String[] names = personNames.split(",");
        BigDecimal amountPerPerson = totalAmount.divide(BigDecimal.valueOf(numPeople),2, BigDecimal.ROUND_HALF_UP);
        List<Person> people = new ArrayList<>();


        for(String personName : names) {
            Person person = new Person();
            person.setName(personName.trim());
            person.setToPay(amountPerPerson);
            person.setHoliday(savedHoliday);
            person.setPayments(new ArrayList<>());
            people.add(person);
        }
        personRepository.saveAll(people);

    }

    public String formatAmount(BigDecimal amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        return currencyFormat.format(amount);
    }

    public List<Payment> getAllPayments(Holiday holiday) {
    List<Payment> allPayments = new ArrayList<>();
    for(Person person : holiday.getPeople()){
        allPayments.addAll(person.getPayments());
    }

        return allPayments;
    }
}
