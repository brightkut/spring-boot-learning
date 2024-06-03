package com.brightkut.caching;

import lombok.Data;

@Data
public class GetCacheRequest {
    private String cacheName;
    private String key;
}
