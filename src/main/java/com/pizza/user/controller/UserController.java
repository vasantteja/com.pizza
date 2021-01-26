package com.pizza.user.controller;

import com.pizza.topping.controller.ToppingController;
import com.pizza.user.domain.User;
import com.pizza.user.service.UserService;
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

@RestController
@RequestMapping("/users")
@Api(value="users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @ApiOperation(value = "View a list of available users",response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value="/user/fetchallusers", method = RequestMethod.GET, produces = "application/json")
    public List<User> fetchAllUsers(){
        logger.debug("Retrieving all the users existing in the database");
        return userService.findAll();
    }

    @ApiOperation(value = "Add a user")
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createUser(@RequestBody User user){
        logger.debug("Creating the user");
        userService.save(user);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a user")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable(value = "id") Long id){
        logger.debug("Deleting the user from the database using id.");
        userService.delete(id);
        return new ResponseEntity("User deleted successfully", HttpStatus.OK);
    }

}
