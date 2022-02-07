package com.nx.phone_book.controller.rest;

import com.nx.phone_book.service.CRUDService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */

//RestController works with domain objects (persistent objects are encapsulated inside service)

//D - domain(ui) type
//K - id type
@RestController
public abstract class CRUDRestController<D, K> {

    abstract CRUDService<D, K> getService();

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D obj) {

        getService().create(obj);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable K id) {

        D obj = getService().findById(id);

        if (obj == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<D>> findAll() {

        List<D> objs = getService().findAll();
        return ResponseEntity.ok(objs);
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D obj){

        D updatedObj = getService().update(obj);
        return ResponseEntity.ok(updatedObj);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable K id) throws Exception {

        D objForDelete = getService().findById(id);
        getService().delete(objForDelete);
        return ResponseEntity.noContent().build();
    }

}
