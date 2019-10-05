package ru.wkn.services;

import org.springframework.data.repository.CrudRepository;

/**
 * The interface {@code IService} represents a repository services layer.
 *
 * @param <K> the type of the ID of the entity the repository manages
 * @param <V> the domain type the repository manages
 * @author Orin Adraas
 */
public interface IService<K, V> {

    /**
     * The method for the {@code CrudRepository} instance obtaining.
     *
     * @return the {@code CrudRepository} object
     */
    CrudRepository<V, K> getRepository();
}
