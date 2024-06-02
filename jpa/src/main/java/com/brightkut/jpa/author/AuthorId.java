package com.brightkut.jpa.author;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AuthorId{
    private String authorName;
    private String authorSurname;
}
