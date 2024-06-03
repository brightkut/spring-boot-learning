package com.brightkut.caching;

import lombok.Data;

@Data
public class PostCacheRequest {
    private String data;
    private String key;
}
