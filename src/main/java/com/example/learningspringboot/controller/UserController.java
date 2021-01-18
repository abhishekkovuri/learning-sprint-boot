package com.example.learningspringboot.controller;

import com.example.learningspringboot.entity.UserEntity;
import com.example.learningspringboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @PostMapping(name="Create User", value="/user", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String addUser (@RequestBody UserEntity user) {
    userRepo.save(user);
    return "user created";
  }

  @GetMapping(name="get User", value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> getUsers () {
    return userRepo.findAll();
  }

  @PostMapping(name="bulk create", value="/bulkCreate", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String bulkCreate(@RequestBody List<UserEntity> user) {
    userRepo.saveAll(user);
    return "Users Created";
  }

  @GetMapping(name="get by id", value="/getUser")
  public Optional<UserEntity> getUser(@RequestParam(value = "userId") String userId) {
    return userRepo.findById(userId);
  }

  @GetMapping(name="get by name", value="/getUserName")
  public List<UserEntity> getUserByName(@RequestParam(value = "username") String username) {
    return userRepo.findByUsernameIgnoringCaseContaining(username);
  }

  @DeleteMapping(name="delete by id", value="/deleteuser")
  public String deleteUser(@RequestParam(value = "userId") String userId) {
    userRepo.deleteById(userId);
    return userId + " deleted";
  }
}
