package com.nx.phone_book.service;

import com.nx.phone_book.data.persistant.Phone;
import com.nx.phone_book.data.persistant.User;
import com.nx.phone_book.data.ui_model.UserModel;
import com.nx.phone_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends AbstractCRUDService<User, UserModel, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CrudRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public UserModel convert(User entity) {

        UserModel userModel = new UserModel();
        userModel.setId(entity.getId());
        userModel.setName(entity.getName());

        List<String> phones = new ArrayList<>();
        List<Phone> phonesObj = entity.getPhones();
        for (Phone phone : phonesObj) {
            phones.add(phone.getNumber());
        }
        userModel.setPhones(phones);

        String phonesString = userModel.aggregatePhones(phones);
        userModel.setPhonesString(phonesString);
        return userModel;
    }
}
