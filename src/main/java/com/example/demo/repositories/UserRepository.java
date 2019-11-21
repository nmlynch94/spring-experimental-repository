package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select user from User as user join fetch user.grantedRoles where user.username = ?1")
	User findByUsernameWithGrantedRoles(String username);

	void deleteByUsername(String username);
}
