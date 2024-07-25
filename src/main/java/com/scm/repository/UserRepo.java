package com.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entity.User;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,String> {
  //extra methods db relationships
  //custom query methods
  //custom finder methods

  Optional<User> findByEmail(String email);
}
