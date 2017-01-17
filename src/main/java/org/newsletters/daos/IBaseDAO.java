package org.newsletters.daos;

import java.util.List;

public interface IBaseDAO<T>{
    void insert(T entity);
    List<T> get();
}
