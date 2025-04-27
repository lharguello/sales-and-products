package com.sales.apirest.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double quantity;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double unitPrice;

    @Column(columnDefinition = "DECIMAL(12,2)", nullable = false)
    private Double total;
}
