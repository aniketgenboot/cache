package com.example.CacheImpl.config;

import com.example.CacheImpl.entity.Book;
import com.example.CacheImpl.service.BookService;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class EhCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager= new CaffeineCacheManager("application");
        cacheManager.setCaffeine(Caffeine.newBuilder());
        return  cacheManager;
    }
    Caffeine<Object,Object> caffeineCacheBuilder(){
        return Caffeine.newBuilder().initialCapacity(100)
                .maximumSize(500).expireAfterAccess(10, TimeUnit.MILLISECONDS)
                .recordStats();
    }
//    @Autowired
//    CacheManager cacheManager;
//    @Autowired
//    BookService bookService;
//
//    @PostConstruct
//    public void preload(){
//        Cache cache= cacheManager.getCache("application");
//        System.out.print("initialising cache");
//        List<Book> getAllBooks=bookService.getAll();
//        for(Book book:getAllBooks){
//            cache.put(book.getId(),book);
//        }
//    }
//
}
