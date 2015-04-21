package sk.revolone.eduidea.data.dao;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sk.revolone.eduidea.data.entity.Role;
import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.data.repository.UserRepository;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.exception.UsernameOrEmailTaken;
import sk.revolone.eduidea.exception.UsernameTaken;
import sk.revolone.eduidea.init.configuration.WebAppConfig;
import sk.revolone.eduidea.utils.CustomMailSender;
import sk.revolone.eduidea.viewmodel.SignUpViewModel;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public User create(User user) throws UsernameOrEmailTaken {
		User createdUser = user;
		User existingUser = userRepository.findByUsernameOrEmail(createdUser.getUsername(), createdUser.getEmail());
		if (existingUser != null) throw new UsernameOrEmailTaken("Username: " + createdUser.getUsername()+ "Email: " + createdUser.getEmail());
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
	public User updateProfile(User user) throws EntityNotFound, UsernameTaken {
		User updatedUser = userRepository.findByUsernameOrEmail(user.getEmail(), user.getEmail());
		if (updatedUser == null) 
			throw new EntityNotFoundException("User that you are trying to update was not found or is not yet activated.");
		
		// Check if the username is not the same
		if(!updatedUser.getUsername().equals(user.getUsername()))
		{
			//If its not the same, check if username is already taken
			if(userRepository.findByUsername(user.getUsername()) != null)
				throw new UsernameTaken("Username'" + user.getUsername() + "' is already taken.");
		}
		
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

	@Override
	public void registerUser(SignUpViewModel viewModel, HttpServletRequest request)
			throws UsernameOrEmailTaken {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		Role userRole = new Role();
		User registeredUser = new User();
		
		userRole.setRole(1);
		userRole.setUser(registeredUser);
		
		registeredUser.setUsername(viewModel.getUsername());
		registeredUser.setActivationKey(UUID.randomUUID());
		registeredUser.setEmail(viewModel.getEmail());
		registeredUser.setFirstName(viewModel.getFirstname());
		registeredUser.setLastName(viewModel.getLastname());
		registeredUser.setIsActivated(false);
		registeredUser.setPassword(encoder.encodePassword(viewModel.getPassword(), viewModel.getEmail()));
		registeredUser.setRole(userRole);
		
		create(registeredUser);
		
		CustomMailSender sender = new CustomMailSender();
		sender.setMailSender(mailSender);
		sender.sendActivationEmail(registeredUser.getActivationKey(), registeredUser, request);
	}

}
