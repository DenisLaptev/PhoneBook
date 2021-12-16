package com.nx.phone_book.controller.rest;

/**
 * @author Denys Laptiev
 * Date: 11/8/2021
 */

import com.nx.phone_book.service.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public abstract class CRUDRestController<E, K> {

    abstract CRUDService<E, K> getService();

    @PostMapping
    public ResponseEntity<E> create(@RequestBody E entity) {

        getService().create(entity);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<E> findById(@PathVariable K id) {

        E entity = getService().findById(id);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<E>> findAll() {

        List<E> entities = getService().findAll();
        return ResponseEntity.ok(entities);
    }

    @PutMapping
    public ResponseEntity<E> update(@RequestBody E entity){

        E updatedEntity = getService().update(entity);
        return ResponseEntity.ok(updatedEntity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable K id) throws Exception {

        E entityForDelete = getService().findById(id);
        getService().delete(entityForDelete);
        return ResponseEntity.noContent().build();
    }

}
