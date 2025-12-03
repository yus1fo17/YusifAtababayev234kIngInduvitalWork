package com.mealpass.domain.entities;

import com.mealpass.domain.entities.bases.MutableEntity;
import com.mealpass.domain.enums.Gender;
import com.mealpass.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends MutableEntity {
    private String username;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private Boolean isActive = true;
    private Boolean emailConfirmed = false;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;
    @Column(nullable = false)
    private String photoPath;
    @Column(nullable = false)
    private LocalDateTime lastLoginAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RefreshToken> refreshTokens = new ArrayList<>();

}
