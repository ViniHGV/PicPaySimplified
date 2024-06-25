package com.picpay_simplified.infra.repositories;

import com.picpay_simplified.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByIdentification(String identification);
}
