package com.example.demo3.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BBuserRepo extends JpaRepository<BBuser,Long> {
    @Query("SELECT s FROM BBuser s WHERE s.email =?1")
    Optional<BBuser> findUsersByEmail(String email);
}
//find by email
