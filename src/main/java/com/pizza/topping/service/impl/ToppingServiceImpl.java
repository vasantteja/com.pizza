package com.pizza.topping.service.impl;

import com.pizza.topping.controller.ToppingController;
import com.pizza.topping.repository.ToppingDao;

import com.pizza.topping.domain.Topping;

import com.pizza.topping.service.ToppingService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service(value = "toppingService")
public class ToppingServiceImpl implements ToppingService {

    private static final Logger logger = LoggerFactory.getLogger(ToppingService.class);

    @Autowired
    private ToppingDao toppingDao;


    public List<Topping> findAll() {
        logger.debug("Retrieving all the toppings existing in the database.");
        List<Topping> list = new ArrayList<>();
        toppingDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Topping save(Topping topping) {
        logger.debug("Saving the topping to the database.");
        return toppingDao.save(topping);
    }

    @Override
    public void delete(long id) {
        logger.debug("Deleting the topping from the database using the topping id.");
        toppingDao.deleteById(id);
    }

    @Override
    public Optional<Topping> findOneBytopping(String topping) {
        logger.debug("Retrieving the topping existing in the database using topping name.");
        return toppingDao.findOneBytopping(topping);
    }

    @Override
    public void deleteByTopping(String topping) {
        logger.debug("Deleting the topping from the database using the topping name.");
        toppingDao.deleteByTopping(topping);
    }
}

