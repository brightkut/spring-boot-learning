## Learn Spring Caching

### Package (Product)
- For using `Spring Cache` we need to add `@EnableCaching` in main class to enable it. And 
add dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

- We add `@Cacheable(value = "product", key = "#productId")` for caching the data that 
return from function. It will read data from cache first if not found it will get from DB and cache.
`value` is the name of cache. `key` is the key of cache that we need to cache
it will use `#` this in parameter of function to reference it.
- We add `@CachePut(...)` when we need to cache the data that we insert/update to DB.
- We add `@CacheEvict(...)` to remove data in cache

### Package (Redis)
- For using `Spring Data Redis` we need to add dependency

```xml	
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```
- To use more built-in function of spring data we can inject
`RedisCacheManager` but we need to initialize bean before in `config` class
- We are able to config redis via class `RedisCacheConfiguration` 
by initialize it in `config` class 
