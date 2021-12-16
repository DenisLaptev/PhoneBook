package com.nx.phone_book.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CRUDService<E, K> {

    void create(E entity);

    E findById(K id);

    List<E> findAll();

    E update(E entity);

    void delete(E entity);

    CrudRepository<E, K> getRepository();

}
