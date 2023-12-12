package com.example.CacheImpl;

import com.example.CacheImpl.entity.Book;
import com.example.CacheImpl.repo.BookRepository;
import com.example.CacheImpl.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
public class Service {
    @Autowired
    BookService service;
    @MockBean
    BookRepository repo;
    @Test
    public void getBookByIdTest() throws Exception {
        Book book =new Book(16,"def");
        when(repo.findById(16)).thenReturn(Optional.of(book));
        assertEquals("def", service.findById(16).getName());
    }

}
