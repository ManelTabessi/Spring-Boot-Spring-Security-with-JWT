package com.example.springbootspringsecuritywithjwt.repository;

import com.example.springbootspringsecuritywithjwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);

}
