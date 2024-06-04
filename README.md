# Springboot Learning

This project will explain about the best practices and technique that you can use in springboot. Including

- JPA
- Microservice
- Concurrency
- Caching (TO DO)
- Other(TODO)(JsonAnnotation, Mapstruct, ObjectMapper, Custom Serializer/Deserializer, Time)
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

## Learn Spring with concurrency

- Performance of CompletableFuture(Parallelism) vs Normal Process
- Custom Task Executor (configure thread pool) 

## Learn Spring Caching

### Topic (Redis)
- Describe how to use each Annotation for caching

### Topic (Product)
- @Cacheable in real life (for get)
- @CachePut in real life (for insert/update)
- @CacheEvict in real life (for delete)

