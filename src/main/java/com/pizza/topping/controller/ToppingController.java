package com.pizza.topping.controller;

import com.pizza.topping.domain.Topping;
import com.pizza.topping.service.ToppingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/toppings")
@Api(value="toppings")
public class ToppingController {

    private static final Logger logger = LoggerFactory.getLogger(ToppingController.class);

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

    @ApiOperation(value = "Search topping by topping name",response = Topping.class)
    @RequestMapping(value = "/fetchtoppingbyname/{toppingName}", method= RequestMethod.GET, produces = "application/json")
    public Topping fetchToppingByName(@PathVariable("toppingName") String toppingName){
        logger.debug("Retrieving the topping using name");
        Optional<Topping> topping = toppingService.findOneBytopping(toppingName);
        return topping.isPresent() ? topping.get() : new Topping();
    }

    @ApiOperation(value = "Add a topping")
    @RequestMapping(value = "/createtopping", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity create(@RequestBody Topping topping){
         toppingService.save(topping);
        logger.debug("Creating the topping");
        return new ResponseEntity("Topping saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/updatetopping", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@RequestBody Topping topping){
        logger.debug("Updating the topping");
        Optional<Topping> toppingOptional = toppingService.findOneBytopping(topping.getTopping());
        if(toppingOptional.isPresent()) {
            Topping retrievedTopping = toppingOptional.get();
            retrievedTopping.setTopping(topping.getTopping());
            if(topping.getPrice() != null) {
                retrievedTopping.setPrice(topping.getPrice());
            }
            Boolean veganFlag = topping.isVeganFlag();
            if (veganFlag != null) {
                retrievedTopping.setVeganFlag(topping.isVeganFlag());
            }

            toppingService.save(retrievedTopping);
            logger.debug("The topping exists and we are updated it.");
            return new ResponseEntity("Topping updated successfully", HttpStatus.OK);
        }
        logger.debug("The topping does not exist in the database.");
        return new ResponseEntity("Topping does not exist. Please verify!!", HttpStatus.NOT_FOUND);
    }

   @ApiOperation(value = "Delete a topping by id")
   @RequestMapping(value = "/deletetoppingbyid/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteById(@PathVariable(value = "id") Long id){
        logger.debug("Deleting the topping from the database using id.");
        toppingService.delete(id);
        return new ResponseEntity("Topping deleted successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a topping by topping name")
    @RequestMapping(value = "/deletetoppingbyname/{toppingname}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteByToppingName(@PathVariable(value = "toppingname") String toppingName){
        logger.debug("Deleting the topping from the database using topping name.");
        toppingService.deleteByTopping(toppingName);
        return new ResponseEntity("Topping deleted successfully", HttpStatus.OK);
    }
}
