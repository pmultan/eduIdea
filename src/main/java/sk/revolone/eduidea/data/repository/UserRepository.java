package sk.revolone.eduidea.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.revolone.eduidea.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByUsernameOrEmail(String username, String email);
	User findByEmail(String email);
}
