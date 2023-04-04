package com.exam.project_2.Services;

import com.exam.project_2.Models.Book;
import com.exam.project_2.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> index(){
        return bookRepository.findAll();
    }

    public List<Book> findAll(int page, int perPage){
        return bookRepository.findAll(PageRequest.of(page, perPage, Sort.by("year"))).getContent();
    }

    public Book findOne(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> findByNameStartingWith(String word){
        return bookRepository.findByBookNameStartingWith(word);
    }

    public void save(String name, int year){
        bookRepository.save(new Book(name, year));
    }
}
