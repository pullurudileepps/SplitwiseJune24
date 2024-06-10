package com.example.SplitwiseJune24.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaction extends BaseModel {
    @ManyToOne
    private User paidFrom;
    @ManyToOne
    private User paidTo;
    private double amount;
}
