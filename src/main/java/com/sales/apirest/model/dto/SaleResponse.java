package com.sales.apirest.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {
    @Schema(description = "Sale identifier", example = "36")
    private Long id;

    @Schema(description = "Product identifier", example = "21")
    private Long productId;

    @Schema(description = "Date of sale")
    private LocalDateTime date;

    @Schema(description = "Sales quantity", example = "2")
    private Double quantity;

    @Schema(description = "Unit price of the product", example = "150.00")
    private Double unitPrice;

    @Schema(description = "Total sales", example = "300.00")
    private Double total;
}
