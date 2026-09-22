package com.revature.demoapp.repository;

import com.revature.demoapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceGreaterThanEqual(double price);

    List<Product> findByNameLike(String name);

    List<Product> findByPriceOrName(double price, String name);
    List<Product> findByNameAndPriceGreaterThan(String name, double price);

    List<Product> findByNameOrderByPriceDesc(String name);

    boolean existsByName(String name);

    void deleteByName(String name);


}
