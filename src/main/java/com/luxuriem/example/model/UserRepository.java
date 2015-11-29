package com.luxuriem.example.model;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findByEmail(final String email);

    void save(User user);
}
