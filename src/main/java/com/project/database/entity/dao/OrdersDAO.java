package com.project.database.entity.dao;

import com.project.database.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDAO extends JpaRepository<Orders, Long> {
    public Orders findById(Integer id);
}
