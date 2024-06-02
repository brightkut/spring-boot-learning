package com.brightkut.jpa.author;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // use this instead of @Builder
@Entity
public class Author extends BaseEntity{

    @Column // this annotation does not require
    private String firstName;
    private String lastName;
}
