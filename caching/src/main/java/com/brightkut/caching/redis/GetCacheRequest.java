package com.brightkut.caching.redis;

import lombok.Data;

@Data
public class GetCacheRequest {
    private String cacheName;
    private String key;
}
