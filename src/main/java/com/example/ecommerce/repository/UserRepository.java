package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findFirstByEmail(String email);

	User findByEmail(String username);
}
