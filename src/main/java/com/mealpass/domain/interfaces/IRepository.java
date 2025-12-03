package com.mealpass.domain.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepository<T> {
    T add(T entity);
    Optional<T> getById(UUID id);
    List<T> getAll();
    T update(T entity);
    void delete(T entity);
}
