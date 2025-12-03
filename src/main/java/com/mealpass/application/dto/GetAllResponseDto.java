package com.mealpass.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllResponseDto {
    private UUID id;
    private String email;
    private String username;
}
