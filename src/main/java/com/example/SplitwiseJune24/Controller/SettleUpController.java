package com.example.SplitwiseJune24.Controller;

import com.example.SplitwiseJune24.Dto.Response;
import com.example.SplitwiseJune24.Dto.SettleGroupRequestDto;
import com.example.SplitwiseJune24.Dto.SettleGroupResponseDto;
import com.example.SplitwiseJune24.Exceptions.InvalidRequestException;
import com.example.SplitwiseJune24.Service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SettleUpController {
    SettleUpService settleUpService;
     @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleGroupResponseDto settleGroup(SettleGroupRequestDto requestDto) {
        SettleGroupResponseDto responseDto = new SettleGroupResponseDto();
        try {
            if (requestDto.getGroupId() < 0) {
                throw new InvalidRequestException("invalid group id");
            }

        } catch (InvalidRequestException e) {
            responseDto.setResponse(Response.getFailedResponse(e.getMessage()));
        }
        return responseDto;
    }
}
