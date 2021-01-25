package com.pizza.topping.service;

import com.pizza.topping.domain.Topping;


import java.util.List;
import java.util.Optional;

public interface ToppingService {

    Optional<Topping> findOneBytopping(String topping);
    Topping save(Topping user);
    List<Topping> findAll();
    void delete(long id);
    void deleteByTopping(String topping);

}
