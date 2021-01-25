package com.pizza.controller;

import com.pizza.model.Topping;
import com.pizza.service.ToppingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")
@Api(value="toppings")
public class ToppingController {

    @Autowired
    private ToppingService toppingService;

    @ApiOperation(value = "View a list of available toppings",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value="/fetchalltoppings", method = RequestMethod.GET, produces = "application/json")
    public List<Topping> listUser(){
        return toppingService.findAll();
    }

    @ApiOperation(value = "Add a topping")
    @RequestMapping(value = "/createtopping", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity create(@RequestBody Topping topping){
         toppingService.save(topping);
        return new ResponseEntity("Topping saved successfully", HttpStatus.OK);
    }

   @ApiOperation(value = "Delete a topping")
   @RequestMapping(value = "/deletetopping/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        toppingService.delete(id);
        return new ResponseEntity("Topping deleted successfully", HttpStatus.OK);
    }
}
