package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Holiday;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/holidays")
public class HolidayController {

    @Autowired
    private HolidayService holidayService;

    @GetMapping
    public String listHolidays(Model model) {
        model.addAttribute("holidays", holidayService.findAllHolidays());
        return "holidays";
    }

    @GetMapping("/{id}")
    public String getHoliday(@PathVariable Integer id, Model model) {
        Holiday holiday = holidayService.findHolidayById(id);
        model.addAttribute("holiday", holiday);
        return "holidayDetails";

    }
    @GetMapping("/create")
    public String createHolidayForm(Model model) {
        model.addAttribute("holiday", new Holiday());
        return "createHoliday";
    }

    @PostMapping("/create")
    public String createHoliday(@RequestParam String name, @RequestParam BigDecimal totalAmount, @RequestParam int numPeople, @RequestParam String personNames) {
        Holiday holiday = new Holiday();

        holiday.setName(name);
        holiday.setTotalAmount(totalAmount);
        holiday.setNumPeople(numPeople);

        String[] names = personNames.split(",");
        List<Person> people = new ArrayList<>();
        for(String personName : names) {
            Person person = new Person();

            person.setName(personName.trim());
            person.setToPay(totalAmount.divide(new BigDecimal(numPeople)));
            person.setHoliday(holiday);
            people.add(person);
        }
        holiday.setPeople(people);
        holidayService.saveHoliday(holiday);

        return "redirect:/holidays";
    }


//    @RequestMapping("/holiday/{id}")
//    public Optional<Holiday> getHolidayById(@PathVariable Integer id) {
//        return holidayService.getHoliday(id);
//    }

    @RequestMapping("/holidaybyname/{name}")
    public Optional<Holiday> getHolidayByName(@PathVariable String name) {
        return holidayService.getHolidayByName(name);
    }
}
