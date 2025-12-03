package com.mealpass.infrastructure.persistence;

import com.mealpass.domain.interfaces.IRepository;
import com.mealpass.domain.interfaces.IUnitOfWork;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UnitOfWorkImpl implements IUnitOfWork {

    @PersistenceContext
    private EntityManager em;

    private final Map<Class<?>, IRepository<?>> repositories = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <T> IRepository<T> repository(Class<T> clazz) {
        return (IRepository<T>) repositories.computeIfAbsent(clazz, c -> new JpaRepositoryImpl<>(em, clazz));
    }

    @Override
    public void beginTransaction() {
        em.getTransaction().begin();
    }

    @Override
    public void commit() {
        em.getTransaction().commit();
    }

    @Override
    public void rollback() {
        em.getTransaction().rollback();
    }
}
