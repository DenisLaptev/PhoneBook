package com.nx.phone_book.controller.rest;

import com.nx.phone_book.data.ui_model.Phone;
import com.nx.phone_book.service.CRUDService;
import com.nx.phone_book.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Denys Laptiev
 * Date: 2/7/2022
 */
@RestController
@RequestMapping(PhoneRestController.PHONE_URL)
public class PhoneRestController extends CRUDRestController<Phone, Long> {

    public static final String PHONE_URL = "phone";

    @Autowired
    private PhoneService phoneService;

    @Override
    CRUDService<Phone, Long> getService() {
        return phoneService;
    }
}
