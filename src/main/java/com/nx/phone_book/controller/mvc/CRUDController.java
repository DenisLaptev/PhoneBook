package com.nx.phone_book.controller.mvc;

/**
 * @author Denys Laptiev
 * Date: 10/22/2021
 */

import com.nx.phone_book.service.CRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public abstract class CRUDController<E, K> {

    abstract String getEntityName();

    abstract CRUDService<E, K> getService();

    @GetMapping("/list")
    public String showList(Model model) {

        List<E> list = getService().findAll();
        model.addAttribute("list", list);

        return getEntityName() + "/list";
    }

    @GetMapping("/read/{id}")
    public String showRead(@PathVariable K id, Model model) {

        E entity = getService().findById(id);
        model.addAttribute("id", id);
        model.addAttribute("entity", entity);

        return getEntityName() + "/read";
    }

    @GetMapping("/create")
    public String showCreate() {

        return getEntityName() + "/create";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable K id, Model model) {

        model.addAttribute("id", id);

        return getEntityName() + "/update";
    }

}
