package com.nx.phone_book.controller.mvc;

import com.nx.phone_book.data.persistant.Phone;
import com.nx.phone_book.data.persistant.User;
import com.nx.phone_book.data.ui_model.PhoneModel;
import com.nx.phone_book.data.ui_model.UserModel;
import com.nx.phone_book.service.CRUDService;
import com.nx.phone_book.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(PhoneController.PHONE_URL_MVC)
public class PhoneController extends CRUDController<Phone, Long> {

    public static final String PHONE_URL_MVC = "ui/phone";
    public static final String PHONE_NAME = "phone";

    @Autowired
    private PhoneService phoneService;

    @Override
    String getEntityName() {
        return PHONE_NAME;
    }

    @Override
    CRUDService<Phone, Long> getService() {
        return phoneService;
    }

    @Override
    @GetMapping("/list")
    public String showList(Model model) {

        List<Phone> entitiesList = getService().findAll();
        List<PhoneModel> modelsList = phoneService.convertList(entitiesList);
        model.addAttribute("modelsList", modelsList);

        return getEntityName() + "/list";
    }
}
