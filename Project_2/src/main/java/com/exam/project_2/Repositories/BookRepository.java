package com.exam.project_2.Repositories;

import com.exam.project_2.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookNameStartingWith(String word);
}
