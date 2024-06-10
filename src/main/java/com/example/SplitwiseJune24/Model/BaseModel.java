package com.example.SplitwiseJune24.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
