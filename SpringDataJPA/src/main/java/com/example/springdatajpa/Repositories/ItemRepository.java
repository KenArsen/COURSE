package com.example.springdatajpa.Repositories;

import com.example.springdatajpa.Models.Item;
import com.example.springdatajpa.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String ItemName);

    List<Item> findByOwner(Person owner);
}
