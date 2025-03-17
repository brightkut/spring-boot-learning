## Learn Spring JPA

### Package (Product)
- Setup DB configuration for JPA
- We create `findTop2ByOrderByPriceDesc` function using a Build-in query of JPA (1) Top (2) OrderBy
- We use projection technique with `java record` to improve performance (Query only necessary field)

```
@Query("select new com.brightkut.jpa.product.ProductName(p.productName) from Product p")
Optional<List<ProductName>> getAllProductNames();
```

- We use projection technique with `mapping correct type` to improve performance (Query only necessary field)

```
@Query("select p.productName from Product p")
Optional<List<String>> getAllProductNames();
```

- We use projection technique with `interface` to improve performance (Query only necessary field)

```
@Query("select p.productName as productName from Product p where p.price = 40000")
Optional<ProductNameProjection> getProductName();
```

- We use sort function to sort value in function `getProductSort`
- We query with pagination in function `getProductPage`
- We want to create transaction and rollback it by add `@Transactional` in function
  `addProduct`
### Package (Employee) 
- In entity `Employee` we need to have relation one to one (1:1) with `Address` we need to do 2 steps
1. Add attribute `Address` in entity `Employee`, Add `@OneToOne` on attribute `Address` and Add `@JoinColumn("addr_id")` 
for a foreign key
2. Add attribute `Employee` in entity `Address`, Add `@OneToOne` on attribute `Employee` and Add `@JoinColumn("emp_id")`
- In entity `Department` we need to have relation one to many (1:M) with `Employee` we need to do 2 steps
1. Add attribute `List<Employee> (employees)` in entity `Department`, Add `@OneToMany(mappedBy = "department")` on attribute `employees` with a map by itself
2. Add attribute `Department` in entity `Employee`, Add `@ManyToOne` on attribute `Department` and Add `@JoinColumn("department_id")`
- In entity `Employee`we need to have relation many to many (M:M) with `Mission` we need to do 2 steps
1. Add attribute `List<Mission>` in entity `Employee`, Add `@ManyToMany` on attribute `missions` and Add 

` @JoinTable(
name = "employee_mission",
joinColumns = @JoinColumn(name = "employee_id"),
inverseJoinColumns = @JoinColumn(name = "mission_id")
)`
2. Add attribute `List<Employee>` in entity `Employee`, Add `@ManyToMany(mappedBy = "missions")` with a map by itself

### Package (Book)   
- In entity `Book` we use the annotation `@CreatedDate` and `@LastModifiedDate` to auto generate the value when we create
entity first time or update the value of entity. For this it requires to add two annotations 
1. Add `@EntityListeners(AuditingEntityListener.class)` in an entity model
2. Add `@EnableJpaAuditing` in main class of spring boot application

### Package (Author)
- In entity `Author` we need to create `BaseEntity` to be like abstract class for every entity to reduce redundant code
for generate id (Primary key) it require to use `@MappedSuperClass` annotation
- In entity `Author` we need to use a Builder pattern to create object then we use `@SuperBuilder` instead `@Builder` because it inheritance class
- In entity `Author2` we need to have composite key as a Primary key then we use two annotation 
1. Add `@EmbeddedId` on attribute (id) that we want to be composite in entity class
2. Add `@Embeddable` on entity that be composite class (`AuthorId`)