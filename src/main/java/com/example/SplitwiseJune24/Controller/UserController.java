package com.example.SplitwiseJune24.Controller;

import com.example.SplitwiseJune24.Dto.RegisterUserRequestDto;
import com.example.SplitwiseJune24.Dto.RegisterUserResponseDto;
import com.example.SplitwiseJune24.Dto.Response;
import com.example.SplitwiseJune24.Exceptions.InvalidRequestException;
import com.example.SplitwiseJune24.Model.User;
import com.example.SplitwiseJune24.Service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto requestDto) {
        RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
        try {
            validateRegistorUserRequest(requestDto);
            User user = this.userService.registerUser(requestDto.getUserName(), requestDto.getPassword(), requestDto.getPhoneNumber());
            responseDto.setUser(user);
            responseDto.setResponse(Response.getSuccessResponse());
        } catch (Exception e) {
            responseDto.setResponse(Response.getFailedResponse(e.getMessage()));
        }
        return responseDto;
    }
    public void validateRegistorUserRequest(RegisterUserRequestDto requestDto) throws InvalidRequestException {
        if(requestDto.getUserName() == null || requestDto.getPassword() == null || requestDto.getPhoneNumber() == null){
            throw new InvalidRequestException("Username or password or phone number cannot be null");
        }
    }
}
