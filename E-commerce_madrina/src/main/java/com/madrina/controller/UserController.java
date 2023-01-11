package com.madrina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madrina.Service.UserService;
import com.madrina.exception.UserException;
import com.madrina.model.User;


@RestController
public class UserController {
	
	@Autowired
	private UserService UService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException {

		User resisteredUser = UService.addUser(user);

		return new ResponseEntity<User>(resisteredUser, HttpStatus.ACCEPTED);

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> viewUser(@PathVariable("id") Integer UserId) throws UserException {

		User resisteredUser = UService.viewUser(UserId);

		return new ResponseEntity<User>(resisteredUser, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getusers")
	ResponseEntity<List<User>> viewAllUser() throws UserException {

		List<User> allAUsers = UService.viewAllUsers();

		return new ResponseEntity<List<User>>(allAUsers, HttpStatus.ACCEPTED);

	}

	@PutMapping("/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException {

		User updatedUser = UService.updateUser(user);

		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<User>  removeUser(@PathVariable("id") Integer Userid) throws UserException{
		
		User removedUser = UService.removeUser(Userid);

		return new ResponseEntity<User>(removedUser, HttpStatus.ACCEPTED);
		

		
	}

}
