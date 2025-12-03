package com.mealpass.domain.entities;

import com.mealpass.domain.entities.bases.MutableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "subscription_plans")
@Getter
@Setter
public class SubscriptionPlan extends MutableEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int dailyMealLimit;
    @Column
    private boolean isActive = true;
    @OneToMany(mappedBy = "subscriptionPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meal> meals;
}
