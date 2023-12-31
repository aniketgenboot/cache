package com.example.CacheImpl.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager= new CaffeineCacheManager("application");
        cacheManager.setCaffeine(Caffeine.newBuilder());
        return  cacheManager;
    }
    Caffeine<Object,Object> caffeineCacheBuilder(){
        return Caffeine.newBuilder().initialCapacity(100)
                .maximumSize(500).expireAfterAccess(10000, TimeUnit.MILLISECONDS)
                .recordStats();
    }
}
