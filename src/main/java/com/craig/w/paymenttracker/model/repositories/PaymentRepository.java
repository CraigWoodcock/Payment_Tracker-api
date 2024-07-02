package com.craig.w.paymenttracker.model.repositories;

import com.craig.w.paymenttracker.model.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


  }