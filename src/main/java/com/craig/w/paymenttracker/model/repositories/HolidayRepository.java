package com.craig.w.paymenttracker.model.repositories;

import com.craig.w.paymenttracker.model.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HolidayRepository extends JpaRepository<Holiday, Integer> {
    Optional<Holiday> findAllByName(String name);

    Object findAllById(Long id);
}