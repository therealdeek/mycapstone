package com.project.database.entity.dao;


import com.project.database.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {



    public List<Users> findByZip(String zip);

    public Users findById(Integer id);

    public Users findByEmail(String email);



}
