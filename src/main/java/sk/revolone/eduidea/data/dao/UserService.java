package sk.revolone.eduidea.data.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sk.revolone.eduidea.data.entity.User;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.exception.UsernameOrEmailTaken;
import sk.revolone.eduidea.exception.UsernameTaken;
import sk.revolone.eduidea.viewmodel.SignUpViewModel;

public interface UserService {
 	public User create(User user) throws UsernameOrEmailTaken;
    public User delete(Long id) throws EntityNotFound;
    public List<User> findAll();
    public User updateProfile(User user) throws EntityNotFound, UsernameTaken;
    public User findById(Long id);
    public User findByUsername(String username) throws EntityNotFound;
    public User findByEmail(String email) throws EntityNotFound;
    public void registerUser(SignUpViewModel viewModel, HttpServletRequest request) throws UsernameOrEmailTaken;
}
