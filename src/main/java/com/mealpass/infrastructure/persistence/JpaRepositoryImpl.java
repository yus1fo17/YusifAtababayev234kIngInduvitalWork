package com.mealpass.infrastructure.persistence;

import com.mealpass.domain.interfaces.IRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JpaRepositoryImpl<T> implements IRepository<T> {

    private final EntityManager em;
    private final Class<T> type;

    public JpaRepositoryImpl(EntityManager em, Class<T> type) {
        this.em = em;
        this.type = type;
    }

    @Override
    public T add(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Optional<T> getById(UUID id) {
        return Optional.ofNullable(em.find(type, id));
    }

    @Override
    public List<T> getAll() {
        return em.createQuery("from " + type.getSimpleName(), type).getResultList();
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }
}
