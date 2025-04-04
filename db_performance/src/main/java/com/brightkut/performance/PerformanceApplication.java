package com.brightkut.performance;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static com.brightkut.performance.Util.measureExecutionTime;
import static com.brightkut.performance.Util.printMemoryUsed;

@SpringBootApplication
public class PerformanceApplication implements ApplicationRunner {

    private final Flyway flyway;
    private final PersonRepository personRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public PerformanceApplication(Flyway flyway, PersonRepository personRepository) {
        this.flyway = flyway;
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PerformanceApplication.class, args);
    }

    @PreDestroy
    public void cleanDatabaseOnShutdown() {
        System.out.println("Cleaning database with Flyway...");
        flyway.clean();  // Drops all objects managed by Flyway
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        // #1
//        var persons = personRepository.findByFirstName("First9999");
//        System.out.println("Person id : "+ persons.get().getId());

//        personRepository.deleteByFirstName("First9999");

        // #2
//        personRepository.deleteByFirstNameIn(listOfFirstName());

//        System.out.println("Number of records : " + personRepository.count());

        // ------------ Don't forget to check in application.yml If want to use bulk insert ------------
        // #3 Bulk Insert this will use saveAll(), require to implement Persistable and
        // update isNew() to true for prevent select statement
//        bulkInsertSaveAll();

        // #4 Bulk Insert2 this is use native query
//        bulkInsertNativeQuery();

        // ------------ Don't forget to update V2.sql in flyway for testing to align with test condition ------------
        // #5 findAll 5,000,000 records
//          findLargeResult();

//        #5 findAll 5,000,000 records but lower memory
//        findLargeResult2();

        //#5 findAll 5,000,000 records
        findLargeResult3();

    }

    private long findAllPersonStream(){
        AtomicLong totalPerson = new AtomicLong();
        try(Stream<Person> persons = personRepository.findAllStream()) {
            persons.forEach((_) -> {
                totalPerson.getAndIncrement();});
            entityManager.clear();
        }

        return totalPerson.longValue();
    }

    private long findAllPersonPagination(){
        int page = 0;
        int batchSize = 500;
        Page<Person> personPage;

        long totalPerson = 0;

        do {
            var pageable = PageRequest.of(page, batchSize);
            personPage = personRepository.findAll(pageable);

            List<Person> persons = personPage.getContent();
            if (persons.isEmpty()) break; // Stop if no more records

            totalPerson += persons.size();
            page++; // Move to the next batch
        } while (personPage.hasNext()); // Continue until no more records

        return totalPerson;
    }

    private List<String> listOfFirstName(){
        var firstNames = new ArrayList<String>();

        int c = 1000;

        for(int i = 1; i <= c; i++) {
            firstNames.add("First"+i);
        }

        return firstNames;
    }

    private void findLargeResult(){
        /*
        Execution time: 15303 milliseconds (15 seconds)
        Used memory is bytes: 2039092928
        Used memory is megabytes: 1944
        Persons count: 5000000
        */
        var persons = measureExecutionTime(personRepository::findAll);
        printMemoryUsed();
        System.out.println("Persons count: " + persons.size());
    }

    private void findLargeResult2(){
        /*   Execution time: 20129 milliseconds (20 seconds)
             Used memory is bytes: 98675768
             Used memory is megabytes: 94
             Persons count: 5000000
         */
        var totalPersons = measureExecutionTime(this::findAllPersonStream);
        printMemoryUsed();
        System.out.println("Persons count: " + totalPersons);
    }

    private void findLargeResult3(){
        /*   took so long time and high memory used
         */
        var totalPersons = measureExecutionTime(this::findAllPersonPagination);
        printMemoryUsed();
        System.out.println("Persons count: " + totalPersons);
    }

    private void bulkInsertSaveAll(){
        var persons = getPerson();

        for(int i = 0 ; i < 10 ; i++){
            var person = Person.builder()
                    .id((long) i)
                    .firstName("Boby"+i)
                    .lastName("Tomus"+i)
                    .age(i)
                    .build();

            persons.add(person);
        }

        personRepository.saveAll(persons);
    }

    private void bulkInsertNativeQuery(){
        var persons = getPerson();

        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO Person (id, first_name, last_name, age) VALUES ");
        Map<String, Object> parameters = new HashMap<>();

        for (int i = 0; i < persons.size(); i++) {
            sqlBuilder.append("(:id").append(i)
                    .append(", :firstName").append(i)
                    .append(", :lastName").append(i)
                    .append(", :age").append(i).append("), ");

            parameters.put("id" + i, persons.get(i).getId());
            parameters.put("firstName" + i, persons.get(i).getFirstName());
            parameters.put("lastName" + i, persons.get(i).getLastName());
            parameters.put("age" + i, persons.get(i).getAge());
        }

        // Remove the last comma and space
        sqlBuilder.setLength(sqlBuilder.length() - 2);

        String sql = sqlBuilder.toString();

        Query query = entityManager.createNativeQuery(sql);

        parameters.forEach(query::setParameter);
        query.executeUpdate();
    }

    private List<Person> getPerson(){
        var persons = new ArrayList<Person>();

        for(int i = 0 ; i < 10 ; i++){
            var person = Person.builder()
                    .id((long) i)
                    .firstName("Boby"+i)
                    .lastName("Tomus"+i)
                    .age(i)
                    .build();

            persons.add(person);
        }

        return persons;
    }

}
