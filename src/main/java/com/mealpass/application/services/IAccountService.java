package com.mealpass.application.services;

import com.mealpass.application.dto.GetAllResponseDto;
import com.mealpass.application.dto.JwtResponseDto;
import com.mealpass.application.dto.LoginRequestDto;
import com.mealpass.application.dto.RegisterRequestDto;

import java.util.List;
import java.util.UUID;

public interface IAccountService {

    void register(RegisterRequestDto dto);

    JwtResponseDto login(LoginRequestDto request);

    void delete(UUID id);
    List<GetAllResponseDto> getAll();
}
