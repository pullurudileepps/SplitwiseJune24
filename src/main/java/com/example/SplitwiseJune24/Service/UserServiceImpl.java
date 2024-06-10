package com.example.SplitwiseJune24.Service;

import com.example.SplitwiseJune24.Exceptions.RegisterUserException;
import com.example.SplitwiseJune24.Model.User;
import com.example.SplitwiseJune24.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(String username, String password, String phoneNumber) throws RegisterUserException {
        Optional<User> userExist = this.userRepository.findByUsernameEqualsOrPassword(username, phoneNumber);
        if (userExist.isPresent()) {
            throw new RegisterUserException("User already registered");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return this.userRepository.save(user);
    }
}
