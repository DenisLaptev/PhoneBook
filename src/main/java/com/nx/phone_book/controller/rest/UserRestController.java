package com.nx.phone_book.controller.rest;

import com.nx.phone_book.data.persistant.Phone;
import com.nx.phone_book.data.persistant.User;
import com.nx.phone_book.service.CRUDService;
import com.nx.phone_book.service.PhoneService;
import com.nx.phone_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 11/8/2021
 */
@RestController
@RequestMapping(UserRestController.USER_URL)
public class UserRestController extends CRUDRestController<User, Long> {

    public static final String USER_URL = "user";

    @Autowired
    private UserService userService;
    @Autowired
    private PhoneService phoneService;

    @Override
    CRUDService<User, Long> getService() {
        return userService;
    }


    @GetMapping("/init")
    public ResponseEntity<List<User>> findAll() {

        List<User> users = new ArrayList();
        users.add(new User(1L, "Name1", null));
        users.add(new User(2L, "Name2", null));
        users.add(new User(3L, "Name3", null));
        users.add(new User(4L, "Name4", null));
        users.add(new User(5L, "Name5", null));

        for (User user : users) {
            userService.create(user);
        }

        List<Phone> phones = new ArrayList();
        phones.add(new Phone(1L, "111111", users.get(0)));
        phones.add(new Phone(2L, "222222", users.get(0)));
        phones.add(new Phone(3L, "333333", users.get(0)));
        phones.add(new Phone(4L, "444444", users.get(4)));
        phones.add(new Phone(5L, "555555", users.get(4)));

        for (Phone phone : phones) {
            phoneService.create(phone);
        }
        return ResponseEntity.ok(users);
    }
}
