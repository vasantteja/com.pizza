package com.pizza.user.service.impl;

import com.pizza.topping.service.ToppingService;
import com.pizza.user.repository.UserDao;
import com.pizza.user.domain.User;
import com.pizza.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@Service(value = "userService")
@Component
public class UserServiceImpl implements UserDetailsService, UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/*@Autowired
	private UserDao userDao;*/

	private static List<User> users = new ArrayList<>();

	static {
		//Initialize Data
		User user1 = new User(1, "Alex123", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu");
		User user2 = new User(2, "Tom234", "$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK");
		User user3 = new User(3, "Adam", "$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu");
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		//User user = userDao.findByUsername(userId);
		User user = users.stream()
				.filter(x -> userId.equals(x.getUsername()))
				.findAny()
				.orElse(null);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		logger.debug("Retrieving all the users existing in the database.");
		//List<User> list = new ArrayList<>();
		//userDao.findAll().iterator().forEachRemaining(list::add);
		return users;
	}

	@Override
	public void delete(long id) {
		logger.debug("Deleting the user from the database using the user id.");
		//userDao.deleteById(id);
		users.removeIf(x -> String.valueOf(x.getId()).equals(String.valueOf(id)));
	}

	@Override
    public User save(User user) {
		logger.debug("Saving the user to the database.");
		users.add(user);
		//return userDao.save(user);
		return user;
    }
}
