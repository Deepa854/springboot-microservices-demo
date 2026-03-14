package com.deepa.product_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.deepa.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
