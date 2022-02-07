package com.nx.phone_book.service;

import com.nx.phone_book.data.persistant.PhoneEntity;
import com.nx.phone_book.data.persistant.UserEntity;
import com.nx.phone_book.data.ui_model.User;
import com.nx.phone_book.repository.PhoneRepository;
import com.nx.phone_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Denys Laptiev
 * Date: 1/19/2022
 */

@Service
public class UserService implements CRUDService<User, Long> {

    public static final String NO_DATA = "no data";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void create(User user) {
        UserEntity entity = convertDomainToEntity(user);
        userRepository.save(entity);
    }

    @Override
    public User findById(Long id) {
        UserEntity entity = userRepository.findById(id).orElse(null);
        User user = convertEntityToDomain(entity);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entityList = userRepository.findAll();
        List<User> users = convertEntityListToDomainList(entityList);
        return users;
    }

    @Override
    public User update(User user) {
        UserEntity entity = convertDomainToEntity(user);
        userRepository.save(entity);
        return user;
    }

    @Override
    public void delete(User user) {
        UserEntity entity = convertDomainToEntity(user);
        userRepository.delete(entity);
    }

    /*
    public class UserEntity {
        private Long id;
        private String name;
    }

    public class User {
        private Long id;
        private String name;
        private String phonesString;
    }
     */

    private User convertEntityToDomain(UserEntity entityObj) {

        Long id = entityObj.getId();
        String name = entityObj.getName();
        String phonesString = getPhonesString(entityObj);

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhonesString(phonesString);

        return user;
    }

    private String getPhonesString(UserEntity entityObj) {
        Long userEntityId = entityObj.getId();
        List<PhoneEntity> phoneEntities = phoneRepository.findByUserEntityId(userEntityId);
        List<String> numbers = getNumbersListFromPhoneEntitiesList(phoneEntities);
        String phonesString = aggregatePhones(numbers);
        return phonesString;
    }

    private List<String> getNumbersListFromPhoneEntitiesList(List<PhoneEntity> phoneEntities) {
        List<String> numbers = new ArrayList<>();
        for (PhoneEntity phoneEntity : phoneEntities) {
            numbers.add(phoneEntity.getNumber());
        }
        return numbers;
    }

    /*
    public class UserEntity {
        private Long id;
        private String name;
    }

    public class User {
        private Long id;
        private String name;
        private String phonesString;
    }
     */
    private UserEntity convertDomainToEntity(User domainObj) {

        Long id = domainObj.getId();
        String name = domainObj.getName();
        //List<PhoneEntity> phoneEntities = getPhoneEntities(domainObj);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(name);

        return userEntity;
    }

    private List<PhoneEntity> getPhoneEntities(User domainObj) {

        List<PhoneEntity> phoneEntities = new ArrayList<>();

        String phonesString = domainObj.getPhonesString();
        if(phonesString!=null) {
            List<String> numbers = Stream.of(phonesString.split(",", -1)).collect(Collectors.toList());

            for (String number : numbers) {
                PhoneEntity phoneEntity = phoneRepository.findByNumber(number);
                phoneEntities.add(phoneEntity);
            }
        }
        return phoneEntities;
    }

    private List<User> convertEntityListToDomainList(List<UserEntity> entityList) {
        //TODO: make Stream implementation
        List<User> domainList = new ArrayList<>();
        for (UserEntity entity : entityList) {
            User domain = convertEntityToDomain(entity);
            domainList.add(domain);
        }
        return domainList;
    }

    private List<UserEntity> convertDomainListToEntityList(List<User> domainList) {
        //TODO: make Stream implementation
        List<UserEntity> entityList = new ArrayList<>();
        for (User domain : domainList) {
            UserEntity entity = convertDomainToEntity(domain);
            entityList.add(entity);
        }
        return entityList;
    }

    private String aggregatePhones(List<String> numbers) {
        String phonesString = "";
        if (numbers == null || numbers.isEmpty()) {
            phonesString = NO_DATA;
        } else if (numbers.size() == 1) {
            phonesString = numbers.get(0);
        } else {
            StringBuilder phonesStringBuilder = new StringBuilder();
            for (int i = 0; i < numbers.size() - 1; i++) {
                phonesStringBuilder.append(numbers.get(i)).append(", ");
            }
            phonesStringBuilder.append(numbers.get(numbers.size() - 1));
            phonesString = String.valueOf(phonesStringBuilder);
        }
        return phonesString;
    }
}
