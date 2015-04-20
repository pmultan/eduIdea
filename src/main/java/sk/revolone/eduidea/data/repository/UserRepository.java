package sk.revolone.eduidea.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.revolone.eduidea.data.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsernameAndIsActivatedTrue(String username);
	User findByUsername(String username);
	User findByUsernameOrEmail(String username, String email); // Used when logging in
	User findByEmail(String email);
}
