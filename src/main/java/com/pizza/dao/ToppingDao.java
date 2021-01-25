package com.pizza.dao;


import com.pizza.model.Topping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingDao extends CrudRepository<Topping, Long> {


}



