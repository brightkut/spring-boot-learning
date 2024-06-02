package com.brightkut.jpa.author;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // add this to make this is a super class
@SuperBuilder // use this instead of @Builder
public class BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
}
