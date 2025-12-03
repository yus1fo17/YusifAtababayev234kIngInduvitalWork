package com.mealpass.domain.interfaces;
public interface IUnitOfWork {
    <T> IRepository<T> repository(Class<T> clazz);
    void beginTransaction();
    void commit();
    void rollback();
}
