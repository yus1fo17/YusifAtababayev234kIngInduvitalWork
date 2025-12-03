package com.mealpass.api;

import com.mealpass.application.dto.GetAllResponseDto;
import com.mealpass.application.dto.JwtResponseDto;
import com.mealpass.application.dto.LoginRequestDto;
import com.mealpass.application.dto.RegisterRequestDto;
import com.mealpass.application.services.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto dto) {
        accountService.register(dto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto request) {
        JwtResponseDto token = accountService.login(request);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetAllResponseDto>> getAll() {
        List<GetAllResponseDto> users = accountService.getAll();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        accountService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
