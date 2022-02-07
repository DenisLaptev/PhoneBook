package com.nx.phone_book.service;

import java.util.List;

//Service works with domain objects (persistent objects are encapsulated inside service)

//D - domain(ui) type
//K - id type
public interface CRUDService<D, K> {

    void create(D obj);

    D findById(K id);

    List<D> findAll();

    D update(D obj);

    void delete(D obj);
}
