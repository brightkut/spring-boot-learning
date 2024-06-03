package com.brightkut.caching;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/cache")
    public ResponseEntity<String> cacheData(@RequestBody PostCacheRequest request){

        return ResponseEntity.ok(this.redisService.testCache(request));
    }

    @GetMapping("/fixKeyCache/{data}")
    public ResponseEntity<String> cacheFixKey(@PathVariable String data){

        return ResponseEntity.ok(this.redisService.testCacheWithFixKey(data));
    }

    @GetMapping("/cacheUnless/{data}")
    public ResponseEntity<String> cacheWithUnless(@PathVariable  String data){

        return ResponseEntity.ok(this.redisService.testCacheWithUnless(data));
    }

    @PostMapping("/getCache")
    public ResponseEntity<String> getCache(@RequestBody GetCacheRequest request){

        return ResponseEntity.ok(this.redisService.getCache(request));
    }

    @GetMapping("/getAllCacheName")
    public ResponseEntity<List<String>> getAllCacheName(){

        return ResponseEntity.ok(this.redisService.getAllCacheName());
    }
}
