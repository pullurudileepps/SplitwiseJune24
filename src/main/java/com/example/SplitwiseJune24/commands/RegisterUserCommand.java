package com.example.SplitwiseJune24.commands;

import com.example.SplitwiseJune24.Controller.UserController;
import com.example.SplitwiseJune24.Dto.RegisterUserRequestDto;
import com.example.SplitwiseJune24.Dto.RegisterUserResponseDto;
import com.example.SplitwiseJune24.Dto.ResponseType;
import com.example.SplitwiseJune24.Exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserCommand implements Command{

    private static final String REGISTER_USER_KEY = "Register";

    UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
        CommandRegistry.getInstance().addCommand(REGISTER_USER_KEY, this);
    }

    @Override
    public void execute(String input) throws InvalidCommandException {
        // eg input: Register dileep 003 xyz
        String[] s = input.split(" ");
        if(s.length != 4) {
            throw new InvalidCommandException("Register user command is not in correct format");
        }
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();
        requestDto.setUserName(s[1]);
        requestDto.setPhoneNumber(s[2]);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(s[3]);
        requestDto.setPassword(encode);
        RegisterUserResponseDto responseDto = this.userController.registerUser(requestDto);
        if(responseDto.getResponse().getResponseType().equals(ResponseType.FAILED)){
            System.out.println("Err:" + responseDto.getResponse().getError());
        } else {
            System.out.println(responseDto.getUser());
        }
    }
}
