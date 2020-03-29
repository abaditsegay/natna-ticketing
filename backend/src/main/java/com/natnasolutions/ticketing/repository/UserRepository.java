package com.natnasolutions.ticketing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.natnasolutions.ticketing.model.User;
import com.natnasolutions.ticketing.model.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	@Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
	public List<User> authenticateUser(@Param("username") String username, @Param("password") String password);

}
