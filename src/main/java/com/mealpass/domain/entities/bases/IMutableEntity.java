package com.mealpass.domain.entities.bases;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IMutableEntity {
    UUID getLastModifiedBy();
    void setLastModifiedBy(UUID lastModifiedBy);

    LocalDateTime getLastModifiedAt();
    void setLastModifiedAt(LocalDateTime lastModifiedAt);
}
