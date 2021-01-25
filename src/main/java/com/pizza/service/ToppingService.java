package com.pizza.service;

import com.pizza.model.Topping;


import java.util.List;

public interface ToppingService {

    Topping save(Topping user);
    List<Topping> findAll();

}
