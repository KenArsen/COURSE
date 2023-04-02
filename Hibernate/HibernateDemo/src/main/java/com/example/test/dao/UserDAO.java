package com.example.test.dao;

import com.example.test.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    static int user_count;
    List<User> users = new ArrayList<>();

    {
        users.add(new User(1, "Arsen", 22, "arsen@gmail.com"));
        users.add(new User(2, "Arnas", 13, "arnas@gmail.com"));
        users.add(new User(3, "Erbol", 27, "erbol@gmail.com"));
        users.add(new User(4, "Bakbol", 26, "bakbol@gmail.com"));
    }

//    public void add(){
//        users.add(new User(1, "Arsen", 22, "arsen@gmail.com"));
//        users.add(new User(1, "Arnas", 13, "arnas@gmail.com"));
//        users.add(new User(1, "Erbol", 27, "erbol@gmail.com"));
//        users.add(new User(1, "Bakbol", 26, "bakbol@gmail.com"));
//    }

    public List<User> index(){
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++user_count);
        users.add(user);
    }

    public void update(int id, User user) {
        User findByUser = show(id);
        findByUser.setName(user.getName());
        findByUser.setAge(user.getAge());
        findByUser.setEmail(user.getEmail());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }

    public void testAdmin(int id){
        User u = users.get(id - 1);
        u.setAdmin(true);
    }
}
