/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ics.respository;

import com.example.ics.entity.Product;
import com.example.ics.entity.SubCategory;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author razamd
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public Page<Product> findBySubCategory(SubCategory subCategory, Pageable pageable);
    
    public Product findByName(String name);
}