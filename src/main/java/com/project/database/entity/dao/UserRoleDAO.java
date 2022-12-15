package com.project.database.entity.dao;

import java.util.List;

import com.project.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    public List<UserRole> findByUserId(Integer userId);

    @Query(value = "SELECT email from user_roles where role_name = 'ADMIN'", nativeQuery = true)
    public List<UserRole> findByEmailAndId(String email, Integer id);
}
