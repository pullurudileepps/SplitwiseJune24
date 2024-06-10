package com.example.SplitwiseJune24.Service;

import com.example.SplitwiseJune24.Exceptions.InvalidRequestException;
import com.example.SplitwiseJune24.Model.*;
import com.example.SplitwiseJune24.Repo.GroupExpenseRepository;
import com.example.SplitwiseJune24.Repo.GroupRepository;
import com.example.SplitwiseJune24.Strategy.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SettleUpServiceImpl implements SettleUpService {

    GroupRepository groupRepository;
    GroupExpenseRepository groupExpenseRepository;
    SettleUpStrategy settleUpStrategy;

    public SettleUpServiceImpl(GroupRepository groupRepository, GroupExpenseRepository groupExpenseRepository, SettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.groupExpenseRepository = groupExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    @Override
    public List<Transaction> settleGroup(int groupId) throws InvalidRequestException {
                /*
        Validate the group id using DB
        Fetch list of expenses from group expense table using group id
        Condense all the expenses down to user and their final total
        Use strategy to actually come up with list of transactions
         */
        Group group =  this.groupRepository.findById(groupId).orElseThrow(() -> new InvalidRequestException("Invalid group id"));
        List<GroupExpense> groupExpenses = this.groupExpenseRepository.findAllByGroupId(groupId);
        List<Expense> Expenses = groupExpenses.stream().map(GroupExpense::getExpense).toList();
        Map<User, Double> userTotal = new HashMap<>();
        for (Expense expense : Expenses) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                userTotal.put(expenseUser.getUser(), userTotal.getOrDefault(expenseUser.getUser(), 0D) +
                        (expenseUser.getExpenseType().equals(ExpenseType.PAID) ? 1 : -1) * expense.getAmount());
            }
        }
        return this.settleUpStrategy.settleUp(userTotal);
    }
}
