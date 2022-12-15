package com.project.database.entity.dao;


import com.project.database.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {

    public List<Users> findByFirstName(String firstName);

    public Users findById(Integer id);

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    public Users findByEmail(String email);

    @Query(value = "SELECT * FROM users where id > 3", nativeQuery = true)
    public List<Map<String, Object>> usersCount();






}
