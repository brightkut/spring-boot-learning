package com.brightkut.caching.redis;

import lombok.Data;

@Data
public class PostCacheRequest {
    private String data;
    private String key;
}
