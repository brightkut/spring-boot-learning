## Learn Json 

### Package (Json)
- We add `@JsonProperty("description")` in `Product` class to custom json response field name
- We add `@JsonIgnore` in `User` class it is not return this `attribute` in json output
- We add `@JsonIgnoreProperties({"name","surname"})` in `UserDetail` class 
it is not return field `name` and `surname` in json response
- We add `@JsonIgnoreProperties(ignoreUnknown = true)` in `UserDetail` class
when we use this model to receive data from third part api that 
they are able to return another field does not exist in our model
- We add `@JsonInclude(JsonInclude.Include.NON_NULL)` in `UserDetail2` class
to return field email when it is not null