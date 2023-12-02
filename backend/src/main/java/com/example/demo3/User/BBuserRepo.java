package com.example.demo3.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BBuserRepo extends JpaRepository<BBuser,Long> {
    @Query("SELECT s FROM BBuser s WHERE s.email =?1")
    Optional<BBuser> findUsersByEmail(String email);
    @Query("SELECT s FROM BBuser s WHERE s.username = :username")
    public BBuser findUsersByUsername(String username);
    @Query("SELECT u FROM BBuser u WHERE u.email = :email")
    BBuser findUsersViaEmail(String email);

    BBuser findBBuserById(long id);

    @Query("SELECT u.username FROM BBuser u WHERE u.id = :Id")
    String findUsernameById(long Id);
}
//find by email
