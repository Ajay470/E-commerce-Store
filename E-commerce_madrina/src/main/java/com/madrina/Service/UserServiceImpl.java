package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madrina.exception.UserException;
import com.madrina.model.User;
import com.madrina.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo URepo;

	@Override
	public User addUser(User user) throws UserException {
		Optional<User> checkExistance = URepo.findById(user.getId());

		if (checkExistance.isPresent())
			throw new UserException("This user alreday present...!");

		else

			return URepo.save(user);
	}

	@Override
	public User viewUser(Integer UserId) throws UserException {
		Optional<User> checkExistance = URepo.findById(UserId);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new UserException("User not found...!");
	}

	@Override
	public List<User> viewAllUsers() throws UserException {
		List<User> allUser = URepo.findAll();

		if (allUser.size() != 0)
			return allUser;
		else
			throw new UserException("No User found...!");
	}

	@Override
	public User updateUser(User user) throws UserException {
		Optional<User> checkExistance = URepo.findById(user.getId());

		if (checkExistance.isPresent())
			return URepo.save(user);

		else

			throw new UserException("Invalid User...!");
	}

	@Override
	public User removeUser(Integer UserId) throws UserException {
		Optional<User> checkExistance = URepo.findById(UserId);

		if (checkExistance.isPresent()) {
			URepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new UserException("Invalid User...!");
		
		}
	}

}
