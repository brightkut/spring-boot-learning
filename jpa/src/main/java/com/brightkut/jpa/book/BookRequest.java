package com.brightkut.jpa.book;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookRequest {
    private String author;
    private String isbn;
}
