package com.project.mycapstone.springboot.database.dao;

import java.util.List;

import com.project.mycapstone.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    public List<UserRole> findByUserId(Integer userId);
}
