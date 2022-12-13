package com.project.database.entity.dao;

import com.project.database.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Long> {

    public OrderDetails findById(Integer id);
}
