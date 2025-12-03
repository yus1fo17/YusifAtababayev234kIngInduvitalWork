package com.mealpass.domain.entities;

import com.mealpass.domain.entities.bases.MutableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "subscription_usages")
@Getter
@Setter
public class SubscriptionUsage extends MutableEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "subscription_plan_id", nullable = false)
    private SubscriptionPlan subscriptionPlan;
    @Column(nullable = false, unique = true)
    private String qrCodeToken;
    @Column(nullable = false)
    private boolean isUsed = false;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    private Boolean isActive = true;
}
