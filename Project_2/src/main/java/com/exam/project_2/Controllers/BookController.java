package com.exam.project_2.Controllers;

import com.exam.project_2.Models.Book;
import com.exam.project_2.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> printAll(@Param("page") int page,
                               @Param("perPage")int perPage){
        return bookService.findAll(page ,perPage);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable("id") int id){
        return bookService.findOne(id);
    }

    @GetMapping("/search/{word}")
    public List<Book> findNameStartingWith(@PathVariable("word") String word){
        return bookService.findByNameStartingWith(word);
    }

    @GetMapping("/add")
    public String add(){
        return "redirect:";
    }

    @PostMapping("/")
    public List<Book> newBook(@RequestParam String bookName,
                        @RequestParam int year){
        bookService.save(bookName, year);
        return bookService.index();
    }

    @GetMapping()
    public List<Book> all(){
        return bookService.index();
    }
}
