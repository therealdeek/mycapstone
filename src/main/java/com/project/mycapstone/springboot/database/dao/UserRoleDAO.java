package com.project.mycapstone.springboot.database.dao;

import java.util.List;
import java.util.Map;

import com.project.mycapstone.springboot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

}
