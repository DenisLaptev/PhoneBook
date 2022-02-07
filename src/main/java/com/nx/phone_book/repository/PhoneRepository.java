package com.nx.phone_book.repository;

import com.nx.phone_book.data.persistant.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Denys Laptiev
 * Date: 1/19/2022
 */

//JpaRepository is better then CRUDRepository because it has useful methods (i.e. saveAndFlush)
public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {

    //TODO: make correct queries

    PhoneEntity findByNumber(String number);

    List<PhoneEntity> findByUserEntityId(Long userEntityId);
}
