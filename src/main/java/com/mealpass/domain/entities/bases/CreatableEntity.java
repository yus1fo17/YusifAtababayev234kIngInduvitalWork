package com.mealpass.domain.entities.bases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class CreatableEntity extends Entity implements ICreatableEntity {

    @Column(nullable = false, updatable = false)
    private UUID createdBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationAt = LocalDateTime.now();
}
