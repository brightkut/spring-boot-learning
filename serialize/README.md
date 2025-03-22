## Learn Serialize

### Package (Student)
- We create class `ZonedDateTimeDeserializer` and `ZonedDateTimeSerializer` for implement custom serializer and deserializer by 
extend class `JsonDeserializer<T>` or `JsonSerializer<T>`  that serializer use when write the java object to json 
and deserializer write json string to java object. Next after we create custom serializer and deserializer we are able to use it via
`@JsonSerialize` annotation and `@JsonDeserialize`

```
    @JsonSerialize(using = ZonedDateTimeSerializer.class)  
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    ZonedDateTime birthDate;
```

### Package (Teacher)
- We can use `@JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "Asia/Bangkok",pattern = "dd-MM-yyyy'T'HH:mm:ss.SSSZ")` to custom
for serializer and deserializer
