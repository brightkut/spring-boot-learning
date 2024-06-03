package com.brightkut.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisService {

    private final RedisCacheManager redisCacheManager;

    public RedisService(RedisCacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    // value กับ cacheNames (เหมือนกัน) คือ set config cache name
    // key คือ ค่า key ที่เก็บ
    @Cacheable( value = "test", key = "#request.key")
    public String testCache(PostCacheRequest request){
        return request.getData();
    }

    // HardCode Cache Key
    // cache ค่าที่ return
    @Cacheable( value = "test2", key = "'fix_key'")
    public String testCacheWithFixKey(String data){
        return data;
    }

    // unless หมายถึง จะไม่ cache ถ้า value ที่ return จาก method == hello
    @Cacheable( value = "test3", key = "'cacheUnless'" , unless = "#result == 'hello'")
    public String testCacheWithUnless(String data){
        return data;
    }

    public String getCache(GetCacheRequest request){
        return redisCacheManager.getCache(request.getCacheName()).get(request.getKey(),String.class);
    }

    public List<String> getAllCacheName(){
        return new ArrayList<>(redisCacheManager.getCacheNames());
    }
}
