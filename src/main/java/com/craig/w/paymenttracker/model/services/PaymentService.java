package com.craig.w.paymenttracker.model.services;

import com.craig.w.paymenttracker.model.entities.Payment;
import com.craig.w.paymenttracker.model.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Iterable<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
