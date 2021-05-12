package clinic.dao.api;

import java.util.List;
/**
 * Abstract dao
 *
 * CRUD for all entities
 */
public interface AbstractDao <T>{

    /**
     * Get a DTO by entity's id
     * @param id entity's id
     */
    T findById(Number id);

    /**
     * Get all entities
     */
    List<T> findAll();

    /**
     * Create a entity by entity's data
     * @param entity entity's data
     */
    T save(T entity);

    /**
     * Update a entity by entity's data
     * @param entity entity's data
     */
    T update(T entity);

    /**
     * Delete a entity by entity's data
     * @param entity entity's data
     */
    void delete(T entity);

    /**
     * Delete a entity by entity's id
     * @param id entity's id
     */
    void deleteById(Number id);
}
