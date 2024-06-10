package com.example.SplitwiseJune24.Repo;

import com.example.SplitwiseJune24.Model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findById(int groupId);
}
