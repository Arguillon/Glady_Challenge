package com.glady.challenge.data.repository;

import com.glady.challenge.data.entity.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserClient, Integer> {
    Optional<UserClient> findByName(String name);

}
