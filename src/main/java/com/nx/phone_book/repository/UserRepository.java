package com.nx.phone_book.repository;

import com.nx.phone_book.data.persistant.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Denys Laptiev
 * Date: 1/19/2022
 */

//JpaRepository is better then CRUDRepository because it has useful methods (i.e. saveAndFlush)
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //TODO: make correct queries

    UserEntity findByName(String userName);
}
