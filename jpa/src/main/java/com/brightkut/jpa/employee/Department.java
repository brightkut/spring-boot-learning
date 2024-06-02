package com.brightkut.jpa.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
