package com.sales.apirest.repository;

import com.sales.apirest.model.entity.Product;
import com.sales.apirest.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Sale> findByProduct(Product product);
}
