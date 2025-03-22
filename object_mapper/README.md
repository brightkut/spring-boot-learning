## Learn Serialize

### Package (Object Mapper)
- We can use `objectMapper.readValue(file, new TypeReference<Product>() {
  });` function to convert file to object
- We can use `objectMapper.writeValueAsString` to convert java object to string
- We use this sample code to read file from class path 

```java
  private File getFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/products/product.json");
    
        return resource.getFile() ;
  }
```