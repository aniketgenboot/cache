package com.example.CacheImpl.test;

import com.example.CacheImpl.entity.Book;
import com.example.CacheImpl.repo.BookRepository;
import com.example.CacheImpl.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestClass {
    @Autowired
    BookService service;
    @MockBean
    BookRepository repo;
    @Test
    public void getBookByIdTest() throws Exception {
        Book book =new Book(16,"def");
        when(repo.findById(16)).thenReturn(Optional.of(book));
        //redisTemplate.opsForValue().set("book:13", book);
        assertEquals(16, service.findById(16).getId());
    }
}
