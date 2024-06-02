package com.brightkut.jpa.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(BookRequest request) {
        Book book = Book.builder()
                .author(request.getAuthor())
                .isbn(request.getIsbn())
                .build();

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Integer id,BookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Error book not found"));
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        return bookRepository.save(book);
    }
}
