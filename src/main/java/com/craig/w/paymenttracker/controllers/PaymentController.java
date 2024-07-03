package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.entities.Person;
import com.craig.w.paymenttracker.model.services.PaymentService;
import com.craig.w.paymenttracker.model.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PersonService personService;

    @GetMapping("/add")
    public String addPaymentForm(@RequestParam Integer holidayId, Model model) {
        List<Person> people = personService.findPeopleByHolidayId(holidayId);
        model.addAttribute("people", people);
        return "addPayment";
    }

    @PostMapping("/add")
    public String addPayment(@RequestParam Integer personId, @RequestParam BigDecimal amount) {
        LocalDate paymentDate = LocalDate.now();
        personService.addPayment(personId, amount, paymentDate);
        return "redirect:/holidays";
    }

    @RequestMapping("/allpayments")
    public Iterable<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }


}
