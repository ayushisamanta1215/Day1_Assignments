package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<Long, User> db = new HashMap<>();

    public User save(User user) {
        db.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return db.get(id);
    }
}
