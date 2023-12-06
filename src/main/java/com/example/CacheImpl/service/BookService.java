package com.example.CacheImpl.service;

import com.example.CacheImpl.entity.Book;
import com.example.CacheImpl.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Cacheable(value = "application")
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
    @Cacheable(value = "application",key="#id")
    public Book findById(Long id) {
        System.out.print("find by repository");
        return bookRepository.findById(id).orElse(null);

    }
      @CacheEvict(value = "application", allEntries = true)
    public void clearAllCache() {
        System.out.print("All cache cleared");
    }


    @CacheEvict(value = "application",key = "#id")
    public void clearDataFromCache(Long id) {
        System.out.print("cache cleared"+id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
}
