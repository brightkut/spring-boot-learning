# Springboot Learning

This project will explain about the best practices and technique that you can use in springboot. Including

- JPA
- Microservice
- Concurrency
- Caching
- Other
- Security (TO DO)
- Testing (TO DO)

## Learn Spring JPA

### Topic (Product)
- Setup DB configuration for JPA
- Build-in query of JPA (1) Top (2) OrderBy
- Projection to improve performance (Example Query only necessary field)
- Sort
- Pagination
- @Transactional

### Topic (Employee)
- Join

### Topic (Book)
- JPA Auditing (@CreatedDate , @LastModifiedDate)

### Topic (Author)
- @MappedSuperClass
- @EmbeddedId (Composite key inside AuthorTest , AuthorId)

## Learn Spring Microservice

You can look into this repository (https://github.com/brightkut/e-commerce-springboot).

### Topic
- Eureka Discovery
- Config server
- Gateway
- Kafka Integrate
- Sending Email (JavaMailSender)
- Create Email Template from Html (Thymeleaf)
- Distribute tracing (Zipkin)

## Learn Spring With Concurrency

- Performance of CompletableFuture(Parallelism) vs Normal Process
- Custom Task Executor (configure thread pool)
- Describe about why we didn't use @Async

## Learn Spring Caching

### Topic (Redis)
- Describe how to use each Annotation for caching

### Topic (Product)
- @Cacheable in real life (for get)
- @CachePut in real life (for insert/update)
- @CacheEvict in real life (for delete)

## Learn Spring Other

### Topic JSON (Product)
- @JsonProperty

### Topic JSON (User)
- @JsonIgnore
- @JsonIgnoreProperties
- @JsonInclude

### Topic Object Mapper (Product)
- Read json file and convert to object
- Convert json object to string

### Topic Java Time (time package)
- Build-in function for java time
- Describe LocalDate, LocalTime, LocalDateTime, ZonedDateTime
- Calculate Period of time (Period, ChronoUnit, Duration)

### Topic Java Time (Student)
- Custom Serializer and Deserializer
- @JsonSerialize/@JsonDeserialize 

### Topic Java Time (Teacher)
- @JsonFormat

### Topic MapStruct (Human)
- How to use mapstruct to create mapper via @Mapper and @Mapping
- Configure pom.xml to build mapper implemented class from `mvn clean install`

### Topic Custom Annotation (Annotation)
- Create custom Annotation
- Create AOP @Aspect for custom annotation

### Topic Generate Report (Jasper)
- used Jasper to generate report (pdf,xls,html)

### Topic Wrapper (Wrapper_Test)
- Test performance between Wrapper class and primitive via Profiler Intelij tool

### Topic Virtual Thread (TO DO)


## Learn Spring AI