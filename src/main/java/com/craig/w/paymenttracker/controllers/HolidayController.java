package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @RequestMapping("/allholidays")
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @RequestMapping("/holiday/{id}")
    public Optional<Holiday> getHolidayById(@PathVariable Integer id) {
        return holidayService.getHoliday(id);
    }

    @RequestMapping("/holidaybyname/{name}")
    public Optional<Holiday> getHolidayByName(@PathVariable String name) {
        return holidayService.getHolidayByName(name);
    }
}
