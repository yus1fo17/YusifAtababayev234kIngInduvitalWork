package com.mealpass.domain.entities;

import com.mealpass.domain.entities.bases.MutableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends MutableEntity {


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean isUsed = false;

    @Column(nullable = false)
    private boolean isRevoked = false;

    @Column(nullable = false)
    private LocalDateTime expiresTime;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    private String ipAddress;
}
