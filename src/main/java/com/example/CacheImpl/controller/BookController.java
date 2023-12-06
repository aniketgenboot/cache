package com.example.CacheImpl.controller;

import com.example.CacheImpl.entity.Book;
import com.example.CacheImpl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService service;
    @PostMapping("book/save")
    public Book saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }
    @GetMapping("/book/findAll")
    public List<Book> findAll() {
        return service.getAll();
    }

    @GetMapping("/book/find/{id}")
    public Book findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/book/clearAllCache")
    public String clearAllCache() {
        service.clearAllCache();
        return "Data cleared from cache";
    }

    @GetMapping("/book/clearDataFromCache/{id}")
    public String clearDataFromCache(@PathVariable Long id) {
        service.clearDataFromCache(id);
        return id+" cleared from cache";
    }
}
