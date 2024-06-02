package com.brightkut.jpa.product;

public record PageResult<T>(
        Iterable<T> data,
        long totalElements,
        int totalPages,
        int pageNumber
) { }
