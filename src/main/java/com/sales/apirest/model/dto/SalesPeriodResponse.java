package com.sales.apirest.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesPeriodResponse {
    @Schema(description = "Sales list")
    private List<SalesByDateResponse> sales;

    @Schema(description = "Total sales period", example = "150")
    private Double totalSales;
}
