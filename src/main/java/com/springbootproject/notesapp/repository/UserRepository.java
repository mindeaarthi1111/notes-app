package com.springbootproject.notesapp.repository;

import com.springbootproject.notesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUserName(String username);
}
