package com.madrina.Service;

import java.util.List;

import com.madrina.exception.UserException;
import com.madrina.model.User;


public interface UserService {
	User addUser(User User) throws UserException;
	 
	User viewUser(Integer UserId) throws UserException;
	 
	 List<User> viewAllUsers() throws UserException;
	 
	 User updateUser(User User) throws UserException;
	 
	 User removeUser(Integer UserId) throws UserException;

}
