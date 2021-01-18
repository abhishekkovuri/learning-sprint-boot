package com.example.learningspringboot.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="user_details")
public class UserEntity {
  @Id
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  @GeneratedValue(generator = "system-uuid")
  @Column(name = "id", updatable = false, nullable = false)
  private String userId;

  @Column(name="user_name")
  private String username;
}
