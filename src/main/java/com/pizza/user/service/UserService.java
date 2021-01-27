package com.pizza.user.service;

import com.pizza.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);

}
