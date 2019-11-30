package ru.sstu.se20.DAL.DAO;

import java.io.Serializable;
import java.util.List;

public interface IOperations<T extends Serializable> {

    T getById(final int id);

    List<T> getAll();

    void create(final T entity);

    T update(final T entity);

    void deleteById(final int entityId);

}