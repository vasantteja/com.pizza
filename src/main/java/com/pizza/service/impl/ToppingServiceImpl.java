package com.pizza.service.impl;

import com.pizza.dao.ToppingDao;

import com.pizza.model.Topping;

import com.pizza.service.ToppingService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service(value = "toppingService")
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingDao toppingDao;





    public List<Topping> findAll() {
        List<Topping> list = new ArrayList<>();
        toppingDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }



    @Override
    public Topping save(Topping topping) {
        return toppingDao.save(topping);
    }

    @Override
    public void delete(long id) {
        toppingDao.deleteById(id);
    }
}

