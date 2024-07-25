package com.scm.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.scm.entity.User;


public interface UserService {
   User saveUser(User user);

   Optional<User> getUserById(String id);

   Optional<User> updateUser(User user);

   void deleteUser(String id);

   boolean isUserExist(String userId);

   boolean isUserExistByEmail(String email);

   List<User> getAllUsers();

   //add more methods here related user service[logic]


}
