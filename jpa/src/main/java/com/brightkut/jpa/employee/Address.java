package com.brightkut.jpa.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer id;
    private String streetName;
    private String streetNumber;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
