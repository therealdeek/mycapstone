package com.project.database.entity.dao;


import com.project.database.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {


    public Users findByEmail(String email);

    public Users findById(Integer id);

}
