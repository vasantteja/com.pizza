package com.pizza.controller;

import com.pizza.model.Topping;
import com.pizza.model.User;
import com.pizza.service.ToppingService;
import com.pizza.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;

    @RequestMapping(value="/fetchalltoppings", method = RequestMethod.GET)
    public List<Topping> listUser(){
        return toppingService.findAll();
    }

    @RequestMapping(value = "/createtopping", method = RequestMethod.POST)
    public Topping create(@RequestBody Topping topping){
        return toppingService.save(topping);
    }

   /* @RequestMapping(value = "/deletetopping/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        toppingService.delete(id);
        return "success";
    }*/
}
