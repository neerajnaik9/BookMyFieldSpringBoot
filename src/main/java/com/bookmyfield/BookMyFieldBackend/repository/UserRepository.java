package com.bookmyfield.BookMyFieldBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookmyfield.BookMyFieldBackend.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}