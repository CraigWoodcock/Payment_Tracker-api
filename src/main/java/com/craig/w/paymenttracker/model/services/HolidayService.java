package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

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

        String[] names = personNames.split(",");
        List<Person> people = new ArrayList<>();
        for(String personName : names) {
            Person person = new Person();
            person.setName(personName.trim());
            person.setToPay(totalAmount.divide(new BigDecimal(numPeople), RoundingMode.HALF_UP));
            person.setHoliday(holiday);
            people.add(person);
        }
        holiday.setPeople(people);
        saveHoliday(holiday);
    }
}
