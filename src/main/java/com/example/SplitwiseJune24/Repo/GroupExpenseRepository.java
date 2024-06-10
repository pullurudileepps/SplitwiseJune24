package com.example.SplitwiseJune24.Repo;

import com.example.SplitwiseJune24.Model.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Integer> {
    List<GroupExpense> findAllByGroupId(int groupId);
}
