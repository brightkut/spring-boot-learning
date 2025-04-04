package com.brightkut.performance;

import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByFirstName(String name);

    @Modifying
    @Query(value = "INSERT INTO Person (id, first_name, last_name, age) VALUES (:id, :firstName, :lastName, :age)", nativeQuery = true)
    void insertPerson(
            @Param("id") long id,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("age") int age
    );

    @QueryHints({
            @QueryHint(name = AvailableHints.HINT_FETCH_SIZE, value = "500"),
            @QueryHint(name = AvailableHints.HINT_CACHEABLE, value = "false")
    })
    @Query("SELECT p FROM  Person p")
    Stream<Person> findAllStream();

    @Modifying
    @Query("DELETE FROM Person p where p.firstName = :firstName")
    int deleteByFirstName(String firstName);

    @Modifying
    @Query("DELETE FROM Person p where p.firstName in :firstNames")
    int deleteByFirstNameIn(List<String> firstNames);

    @Query("SELECT count(1) FROM Person")
    long countAll();
}
