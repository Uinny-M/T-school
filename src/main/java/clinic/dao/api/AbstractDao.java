package clinic.dao.api;

import java.util.List;

public interface AbstractDao <T>{
    T findById(Number id);

    List<T> findAll();

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(Number id);
}
