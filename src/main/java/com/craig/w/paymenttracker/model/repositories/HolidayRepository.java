package com.craig.w.paymenttracker.model.repositories;

import com.craig.w.paymenttracker.model.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
}