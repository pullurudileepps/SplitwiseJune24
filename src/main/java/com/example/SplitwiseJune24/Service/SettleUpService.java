package com.example.SplitwiseJune24.Service;

import com.example.SplitwiseJune24.Exceptions.InvalidRequestException;
import com.example.SplitwiseJune24.Model.Transaction;

import java.util.List;

public interface SettleUpService {
    List<Transaction> settleGroup(int groupId) throws InvalidRequestException;
}
