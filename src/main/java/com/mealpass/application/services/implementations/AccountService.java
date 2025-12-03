package com.mealpass.application.services.implementations;

import com.mealpass.application.dto.GetAllResponseDto;
import com.mealpass.application.dto.JwtResponseDto;
import com.mealpass.application.dto.LoginRequestDto;
import com.mealpass.application.dto.RegisterRequestDto;
import com.mealpass.application.services.IAccountService;
import com.mealpass.domain.entities.User;
import com.mealpass.domain.interfaces.IUnitOfWork;
import com.mealpass.shared.jwt.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service
public class AccountService implements IAccountService {
    private final IUnitOfWork _unitOfWork;
    private final PasswordEncoder _passwordEncoder;
    private final JwtService _jwtService;

    public AccountService(IUnitOfWork unitOfWork, PasswordEncoder passwordEncoder, JwtService jwtService) {
        _unitOfWork = unitOfWork;
        _passwordEncoder = passwordEncoder;
        _jwtService = jwtService;
    }

    @Override
    public void register(RegisterRequestDto dto) {

        var userRepo = _unitOfWork.repository(User.class);

        var existing = userRepo.getAll()
                .stream()
                .filter(u -> u.getEmail().equals(dto.getEmail()))
                .findFirst()
                .orElse(null);

        if (existing != null)
            throw new RuntimeException("User already exists!");

        var user = new User();
        user.setId(UUID.randomUUID());

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        user.setPassword(_passwordEncoder.encode(dto.getPassword()));
        user.setIsActive(true);
        user.setEmailConfirmed(false);

        user.setLastLoginAt(LocalDateTime.now());

        userRepo.add(user);
        _unitOfWork.commit();
    }


    @Override

    public JwtResponseDto login(LoginRequestDto request) {

        var user = _unitOfWork.repository(User.class)
                .getAll()
                .stream()
                .filter(u -> u.getEmail().equals(request.getEmail()))
                .findFirst()
                .orElse(null);

        if (user == null)
            throw new RuntimeException("User not found!");

        if (!_passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("Incorrect password!");
        String token = _jwtService.generateToken(user);
        return new JwtResponseDto(token);
    }

    @Override
    public void delete(UUID id) {

        var userRepo = _unitOfWork.repository(User.class);

        var user = userRepo.getById(id).orElse(null);
        if (user == null)
            throw new RuntimeException("User not found!");

        userRepo.delete(user);
        _unitOfWork.commit();
    }
    @Override
    public List<GetAllResponseDto> getAll() {
        var users = _unitOfWork.repository(User.class).getAll();

        return users.stream()
                .map(u -> new GetAllResponseDto(u.getId(), u.getEmail(), u.getUsername()))
                .toList();
    }



}
