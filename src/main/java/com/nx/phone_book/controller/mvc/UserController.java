package com.nx.phone_book.controller.mvc;

import com.nx.phone_book.data.persistant.User;
import com.nx.phone_book.data.ui_model.UserModel;
import com.nx.phone_book.service.CRUDService;
import com.nx.phone_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(UserController.USER_URL_MVC)
public class UserController extends CRUDController<User, Long> {

    public static final String USER_URL_MVC = "ui/user";
    public static final String USER_NAME = "user";

    @Autowired
    private UserService userService;

    @Override
    String getEntityName() {
        return USER_NAME;
    }

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }

    @Override
    @GetMapping("/list")
    public String showList(Model model) {

        List<User> entitiesList = getService().findAll();
        List<UserModel> modelsList = userService.convertList(entitiesList);
        model.addAttribute("modelsList", modelsList);

        return getEntityName() + "/list";
    }
}
