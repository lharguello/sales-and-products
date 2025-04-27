package com.sales.apirest.controller;

import com.sales.apirest.model.dto.SaleResponse;
import com.sales.apirest.model.dto.SalesByDateResponse;
import com.sales.apirest.model.dto.SalesPeriodResponse;
import com.sales.apirest.service.SaleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/sales")
@Tag(name = "Sales", description = "operations related to sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Operation(summary = "Register a Sale",
            description = "return a sale registered")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SaleResponse createSale(@RequestParam Long productId, @RequestParam Double totalProducts){
        return saleService.createSale(productId, totalProducts);
    }

    @Operation(summary = "Get all Sales",
            description = "returns a list of sales")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping
    public List<SaleResponse> getAll(){
        return saleService.getAll();
    }

    @Operation(summary = "Get a Sale",
            description = "Return sale by id")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("{id}")
    public SaleResponse getById(@Parameter(description = "Sale identifier", example = "1") @PathVariable("id") Long id){
        return saleService.getSaleById(id);
    }

    @Operation(summary = "Find sales by date",
            description = "Returns sales filtered by a date range")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("date-range")
    public SalesPeriodResponse filterSales(@Parameter(description = "Start date", example = "2025-04-10T02:20") @RequestParam LocalDateTime startDate, @Parameter(description = "End date", example = "2025-04-15T02:20") @RequestParam LocalDateTime endDate){
        return saleService.findByDateRange(startDate, endDate);
    }
}
