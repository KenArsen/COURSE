package com.exam.project_2.Controllers;

import com.exam.project_2.Models.Book;
import com.exam.project_2.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{page}/{perPage}")
    public List<Book> printAll(@PathVariable("page") int page,
                               @PathVariable("perPage")int perPage){
        return bookService.findAll(page ,perPage);
    }

    @GetMapping("/add")
    public String add(){
        return "redirect:";
    }

    @PostMapping()
    public List<Book> newBook(@RequestParam String bookName,
                        @RequestParam int year){
        bookService.save(bookName, year);
        return bookService.index();
    }
}
