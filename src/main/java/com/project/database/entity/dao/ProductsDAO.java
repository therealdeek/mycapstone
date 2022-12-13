package com.project.database.entity.dao;

import com.project.database.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Blob;

@Repository
public interface ProductsDAO extends JpaRepository<Products, Long> {

    public Products findById(Integer id);

    public Products findByAvatar(Blob avatar);
}
