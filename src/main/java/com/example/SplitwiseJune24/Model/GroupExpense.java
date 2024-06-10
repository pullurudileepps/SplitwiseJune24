package com.example.SplitwiseJune24.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class GroupExpense extends BaseModel {
    @ManyToOne
    private Group group;
    @ManyToOne
    private Expense expense;
}
