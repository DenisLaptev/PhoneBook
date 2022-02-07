package com.nx.phone_book.service;

import com.nx.phone_book.data.persistant.PhoneEntity;
import com.nx.phone_book.data.persistant.UserEntity;
import com.nx.phone_book.data.ui_model.Phone;
import com.nx.phone_book.repository.PhoneRepository;
import com.nx.phone_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 1/19/2022
 */

@Service
public class PhoneService implements CRUDService<Phone, Long> {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(Phone phone) {
        PhoneEntity entity = convertDomainToEntity(phone);
        phoneRepository.save(entity);
    }

    @Override
    public Phone findById(Long id) {
        PhoneEntity entity = phoneRepository.findById(id).orElse(null);
        Phone phone = convertEntityToDomain(entity);
        return phone;
    }

    @Override
    public List<Phone> findAll() {
        List<PhoneEntity> entityList = phoneRepository.findAll();
        List<Phone> phones = convertEntityListToDomainList(entityList);
        return phones;
    }

    @Override
    public Phone update(Phone phone) {
        PhoneEntity entity = convertDomainToEntity(phone);
        phoneRepository.save(entity);
        return phone;
    }

    @Override
    public void delete(Phone phone) {
        PhoneEntity entity = convertDomainToEntity(phone);
        phoneRepository.delete(entity);
    }

    private Phone convertEntityToDomain(PhoneEntity entityObj) {
        Phone phone = new Phone();
        phone.setId(entityObj.getId());
        phone.setNumber(entityObj.getNumber());

        UserEntity userEntity = userRepository.findById(entityObj.getUserEntityId()).orElse(null);
        if(userEntity!=null){
            phone.setUserName(userEntity.getName());
            phone.setUserId(userEntity.getId());
        }
        return phone;
    }

    private PhoneEntity convertDomainToEntity(Phone domainObj) {
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setId(domainObj.getId());
        phoneEntity.setNumber(domainObj.getNumber());
        phoneEntity.setUserEntityId(domainObj.getUserId());
        return  phoneEntity;
    }

    private List<Phone> convertEntityListToDomainList(List<PhoneEntity> entityList) {
        //TODO: make Stream implementation
        List<Phone> domainList = new ArrayList<>();
        for (PhoneEntity entity : entityList) {
            Phone domain = convertEntityToDomain(entity);
            domainList.add(domain);
        }
        return domainList;
    }

    private List<PhoneEntity> convertDomainListToEntityList(List<Phone> domainList) {
        //TODO: make Stream implementation
        List<PhoneEntity> entityList = new ArrayList<>();
        for (Phone domain : domainList) {
            PhoneEntity entity = convertDomainToEntity(domain);
            entityList.add(entity);
        }
        return entityList;
    }

}
