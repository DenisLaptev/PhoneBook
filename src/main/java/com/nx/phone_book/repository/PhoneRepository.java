package com.nx.phone_book.repository;


import com.nx.phone_book.data.persistant.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
