package com.gcu.topic2.data;
import java.util.List;
public interface DataAccessInterface<T> {
    java.util.List<T> findAll();
    T findById(int id);
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
}
