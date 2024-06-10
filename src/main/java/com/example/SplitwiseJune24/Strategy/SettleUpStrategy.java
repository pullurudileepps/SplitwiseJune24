package com.example.SplitwiseJune24.Strategy;

import com.example.SplitwiseJune24.Model.Transaction;
import com.example.SplitwiseJune24.Model.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    List<Transaction> settleUp(Map<User, Double> userTotal);
}
