package com.project.mycapstone.springboot.database.dao;


import java.util.List;
import java.util.Map;

import com.project.mycapstone.springboot.database.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {


    public Users findByEmail(String email);

    public Users findById(Integer id);

}
