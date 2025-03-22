package com.brightkut.object_mapper.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class JsonMapperService {

    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    public JsonMapperService() {
        this.resourceLoader = new DefaultResourceLoader();
        this.objectMapper = new ObjectMapper();
        objectMapper
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule());
    }

    public Product readJsonFileToProductObject() throws IOException {
        File file = getFile("classpath:/products/product.json");

        Product product = objectMapper.readValue(file, new TypeReference<Product>() {
        });

        return product;
    }


    private File getFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource(filePath);

        return resource.getFile() ;
    }

    public String convertProductToString(Product product) throws JsonProcessingException {
        return "This is a product string: ".concat(objectMapper.writeValueAsString(product));
    }
}
