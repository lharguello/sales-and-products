package com.sales.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String description;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double unitPrice;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double stock;
}
