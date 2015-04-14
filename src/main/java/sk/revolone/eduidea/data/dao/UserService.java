package sk.revolone.eduidea.data.dao;

import java.util.List;

import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.exception.UsernameTaken;

public interface UserService {
 	public User create(User user);
    public User delete(Long id) throws EntityNotFound;
    public List<User> findAll();
    public User updateProfile(User user) throws EntityNotFound, UsernameTaken;
    public User findById(Long id);
    public User findByUsername(String username) throws EntityNotFound;
    public User findByEmail(String email) throws EntityNotFound;
}
