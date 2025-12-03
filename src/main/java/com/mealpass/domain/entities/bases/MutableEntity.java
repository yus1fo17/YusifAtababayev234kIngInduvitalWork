package com.mealpass.domain.entities.bases;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class MutableEntity extends CreatableEntity implements IMutableEntity {

    @Column
    private UUID lastModifiedBy;

    @Column
    private LocalDateTime lastModifiedAt;
}
