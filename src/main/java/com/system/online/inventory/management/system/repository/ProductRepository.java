package com.system.online.inventory.management.system.repository;

import com.system.online.inventory.management.system.model.Product;
import com.system.online.inventory.management.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
