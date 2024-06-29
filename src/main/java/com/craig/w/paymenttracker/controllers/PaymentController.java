package com.craig.w.paymenttracker.controllers;

import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/allpayments")
    public Iterable<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
