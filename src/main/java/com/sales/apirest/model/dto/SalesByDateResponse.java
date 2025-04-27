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
public class SalesByDateResponse {
    @Schema(description = "Product identifier", example = "21")
    private Long productId;

    @Schema(description = "Product description", example = "Coffee")
    private String productDescription;

    @Schema(description = "Total sales", example = "150")
    private Double totalSales;
}
