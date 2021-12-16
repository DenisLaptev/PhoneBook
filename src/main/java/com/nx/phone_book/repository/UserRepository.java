package com.nx.phone_book.repository;


import com.nx.phone_book.data.persistant.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
