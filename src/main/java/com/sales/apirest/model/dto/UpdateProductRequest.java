package com.sales.apirest.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    @NotEmpty(message = "The field unitPrice is required")
    @Schema(description = "Unit price of the product", example = "150.00")
    private Double unitPrice;

    @NotEmpty(message = "The field stock is required")
    @Schema(description = "Quantity available in stock", example = "25")
    private Double stock;
}
