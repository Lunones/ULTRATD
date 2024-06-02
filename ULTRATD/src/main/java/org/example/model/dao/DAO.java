package org.example.model.dao;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface for Data Access Objects (DAOs).
 *
 * @param <T> The type of the entity managed by the DAO.
 * @param <K> The type of the entity's primary key.
 */
public interface DAO<T, K> extends Closeable {
    /**
     * Saves an entity.
     *
     * @param entity The entity to be saved.
     * @return The saved entity.
     */
    T save(T entity);

    /**
     * Deletes an entity.
     *
     * @param entity The entity to be deleted.
     * @return The deleted entity.
     * @throws SQLException if a database access error occurs.
     */
    T delete(T entity) throws SQLException;

    /**
     * Finds an entity by its primary key.
     *
     * @param key The primary key of the entity to find.
     * @return The found entity, or null if not found.
     */
    T findById(K key);

    /**
     * Finds all entities.
     *
     * @return A list of all entities.
     */
    List<String> findAll();
}

