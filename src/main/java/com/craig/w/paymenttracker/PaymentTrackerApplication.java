package com.craig.w.paymenttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class PaymentTrackerApplication {


    private static final Logger log = Logger.getLogger(PaymentTrackerApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(PaymentTrackerApplication.class, args);
        log.info("something happened");
    }

}
