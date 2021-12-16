package com.nx.phone_book.service;


import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCRUDService<E, M, K> implements CRUDService<E, K> {

    @Override
    public void create(E entity) {
        getRepository().save(entity);
    }

    @Override
    public E findById(K id) {
        return (E) getRepository().findById(id).orElse(null);
    }

    @Override
    public List<E> findAll() {
        List<E> entities = new ArrayList<>();
        getRepository().findAll().forEach(entities::add);
        return entities;
    }

    @Override
    public E update(E entity) {
        getRepository().save(entity);
        return entity;
    }

    @Override
    public void delete(E entity) {
        getRepository().delete(entity);
    }

    public abstract M convert(E entity);

    public List<M> convertList(List<E> entitiesList) {
        List<M> modelsList = new ArrayList<>();
        for (E entity : entitiesList) {
            M model = convert(entity);
            modelsList.add(model);
        }
        return modelsList;
    }

}
