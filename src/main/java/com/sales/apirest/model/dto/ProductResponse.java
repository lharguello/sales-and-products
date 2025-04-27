package com.sales.apirest.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    @Schema(description = "Product identifier", example = "222")
    private Long id;

    @Schema(description = "Product description", example = "Coffee")
    private String description;

    @Schema(description = "Unit price of the product", example = "150.00")
    private Double unitPrice;

    @Schema(description = "Quantity available in stock", example = "25")
    private Double stock;
}
