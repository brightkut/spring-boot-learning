package com.brightkut.performance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Persistable<Long> {
    @Id
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Integer age;

    @Override
    public boolean isNew() {
        // to determine every save() or saveAll() , it always insert not update
        // to prevent when using save for insert it will have selected statement first
        // that make it has more query
        return true;
    }
}
