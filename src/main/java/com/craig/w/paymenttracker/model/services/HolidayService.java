package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.repositories.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class    HolidayService {

    @Autowired
    private HolidayRepository holidayRepository;

    public Holiday createHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Optional<Holiday> getHoliday(Integer id) {
        return holidayRepository.findById(id);
    }

    public Optional<Holiday> getHolidayByName(String name) {
        return holidayRepository.findAllByName(name);
    }
}
