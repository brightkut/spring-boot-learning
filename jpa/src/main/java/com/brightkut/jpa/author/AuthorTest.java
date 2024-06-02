package com.brightkut.jpa.author;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthorTest {
    @EmbeddedId
    private AuthorId id;
}
