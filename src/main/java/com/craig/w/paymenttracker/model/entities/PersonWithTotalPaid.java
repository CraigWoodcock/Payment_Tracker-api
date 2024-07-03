package com.craig.w.paymenttracker.model.entities;

import java.math.BigDecimal;

public class PersonWithTotalPaid {
    private Person person;
private BigDecimal totalPaid;

    public PersonWithTotalPaid(Person person, BigDecimal totalPaid) {
        this.person = person;
        this.totalPaid = totalPaid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }
}
