package com.example.SplitwiseJune24.Dto;

import com.example.SplitwiseJune24.Model.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class SettleGroupResponseDto {
    private List<Transaction> transactions;
    private Response response;
}
