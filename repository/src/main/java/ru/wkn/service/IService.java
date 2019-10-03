package ru.wkn.service;

import org.springframework.data.repository.CrudRepository;

public interface IService<K, V> {

    CrudRepository<V, K> getRepository();
}
