package com.project.database.entity.dao;

import com.project.database.entity.Products;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;



@Repository
public interface ProductsDAO extends JpaRepository<Products, Long> {

    public Products findById(Integer id);

    @Query(value = "SELECT price FROM products where id= 9", nativeQuery = true)
    List<Products> findByPrice(Integer price);




}
