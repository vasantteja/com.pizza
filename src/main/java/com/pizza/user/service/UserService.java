package com.pizza.user.service;

import com.pizza.user.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);

}
