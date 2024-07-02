package com.craig.w.paymenttracker.model.repositories;

import com.craig.w.paymenttracker.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {


    List<Person> findByHolidayId(Integer holidayId);
}

