package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @RequestMapping("/allholidays")
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }
}
