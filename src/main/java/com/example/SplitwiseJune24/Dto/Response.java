package com.example.SplitwiseJune24.Dto;

import lombok.Data;

@Data
public class Response {
    private String error;
    private ResponseType responseType;

    public Response(ResponseType responseType, String error) {
        this.responseType = responseType;
        this.error = error;
    }

    public static Response getFailedResponse(String error) {
        return new Response(ResponseType.FAILED, error);
    }
    public static Response getSuccessResponse() {
        return new Response(ResponseType.SUCCESS, null);
    }
}
