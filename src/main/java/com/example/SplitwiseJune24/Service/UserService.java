package com.example.SplitwiseJune24.Service;

import com.example.SplitwiseJune24.Exceptions.RegisterUserException;
import com.example.SplitwiseJune24.Model.User;

public interface UserService {
    User registerUser(String username, String password, String phoneNumber) throws RegisterUserException;
}
