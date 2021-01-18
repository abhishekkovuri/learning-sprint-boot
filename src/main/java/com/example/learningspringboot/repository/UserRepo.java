package com.example.learningspringboot.repository;

import com.example.learningspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, String> {
  List<UserEntity> findByUsernameIgnoringCaseContaining(String username);
}
