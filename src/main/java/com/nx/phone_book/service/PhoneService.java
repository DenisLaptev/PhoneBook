package com.nx.phone_book.service;

import com.nx.phone_book.data.persistant.Phone;
import com.nx.phone_book.data.persistant.User;
import com.nx.phone_book.data.ui_model.Model;
import com.nx.phone_book.data.ui_model.PhoneModel;
import com.nx.phone_book.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService extends AbstractCRUDService<Phone, PhoneModel, Long> {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public CrudRepository<Phone, Long> getRepository() {
        return phoneRepository;
    }

    @Override
    public PhoneModel convert(Phone entity) {
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.setId(entity.getId());
        phoneModel.setNumber(entity.getNumber());
        User user = entity.getUser();
        if (user != null) {
            phoneModel.setUserName(user.getName());
        } else {
            phoneModel.setUserName(Model.NO_DATA);
        }

        return phoneModel;
    }
}
