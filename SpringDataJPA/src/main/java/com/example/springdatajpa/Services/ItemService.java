package com.example.springdatajpa.Services;

import com.example.springdatajpa.Models.Item;
import com.example.springdatajpa.Models.Person;
import com.example.springdatajpa.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findByItemName(String itemName){
        return itemRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner){
        return itemRepository.findByOwner(owner);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findOne(int id){
        return itemRepository.findById(id).orElse(null);
    }

    public void save(Item item){
        itemRepository.save(item);
    }

    public void update(int id, Item item){
        item.setId(id);
        itemRepository.save(item);
    }

    public void delete(int id){
        itemRepository.deleteById(id);
    }
}
