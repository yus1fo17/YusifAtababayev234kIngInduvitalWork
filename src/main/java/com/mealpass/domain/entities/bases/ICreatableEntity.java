package com.mealpass.domain.entities.bases;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ICreatableEntity {
    UUID getCreatedBy();
    void setCreatedBy(UUID createdBy);

    LocalDateTime getCreationAt();
    void setCreationAt(LocalDateTime creationAt);
}
