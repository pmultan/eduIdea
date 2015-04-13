package sk.revolone.eduidea.data.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.data.repository.UserRepository;
import sk.revolone.eduidea.exception.EntityNotFound;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}

	@Override
	@Transactional(rollbackOn=EntityNotFoundException.class)
	public User delete(Long id) throws EntityNotFound {
		User deletedUser = userRepository.findOne(id);
		if (deletedUser == null)
			throw new EntityNotFound(
					"User that you are trying to remove was not found in DB.");
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(rollbackOn=EntityNotFoundException.class)
	public User updateProfile(User user) throws EntityNotFound {
		
		User updatedUser = userRepository.findByUsernameOrEmail(user.getEmail(), user.getEmail());
		if (updatedUser == null) 
			throw new EntityNotFoundException("User that you are trying to update was not found in DB.");
		
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setUsername(user.getUsername());
		
		userRepository.save(updatedUser);
		
		return updatedUser;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByUsername(String username) throws EntityNotFound {
		User user = userRepository.findByUsername(username);
		if(user == null)
			throw new EntityNotFoundException("User with given username was not found in DB.");
		return user;
	}

	@Override
	public User findByEmail(String email) throws EntityNotFound {
		User user = userRepository.findByEmail(email);
		if(user == null)
			throw new EntityNotFoundException("User with given email was not found in DB.");
		return user;
	}

}