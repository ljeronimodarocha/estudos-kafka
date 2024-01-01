package org.shop.validator.repository;

import org.shop.validator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {
    Product findByIdentifier(String identifier);
}