## Learn Mapstruct

### Package (Mapstruct)
- For using `mapstruct` we create `mapper` interface class
and add this annotation `@Mapper(componentModel = "spring")` to determine it is mapper class
and `componentModel = "spring"` use for create spring bean and inject via @Autowired. Next
we create function that we need to be mapper function and use `@Mapping(target = "name", source = "dto.name")`
to mapping field 