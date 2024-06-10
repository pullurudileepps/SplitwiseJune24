package com.example.SplitwiseJune24.Repo;

import com.example.SplitwiseJune24.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByUsernameEqualsOrPassword(String username, String password);
}
