package com.mealpass.application.dto;

public class JwtResponseDto {
    public String token;
    public String type = "Bearer";
    public JwtResponseDto(String token) {
        this.token = token;
    }
}
