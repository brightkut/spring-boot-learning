package com.brightkut.jpa.book;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)// Add this to allow using @CreatedDate and @LastModifiedDate
public class Book {

    @Id
    @GeneratedValue
    private Integer id;
    private String author;
    private String isbn;

    @CreatedDate
    @Column(updatable = false)// set this to add this field only when the first time we insert this data
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)// set this to make sure the first time we insert the data the lastModifiedDate will be null
    private LocalDateTime lastModifiedDate;
}
