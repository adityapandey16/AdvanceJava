package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select c from User c left join fetch c.recepies where c.id=:id")
	Optional<User> getUserAndRecepies(Long id);
}
