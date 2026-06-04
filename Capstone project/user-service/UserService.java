package com.example.userservice.service;

import com.example.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService {

    private final Map<Long, User> db = new HashMap<>();

    public User createUser(User user) {
        user.setId(Math.abs(new Random().nextLong()));
        db.put(user.getId(), user);
        return user;
    }

    public User getUser(Long id) {
        return db.get(id);
    }
}
