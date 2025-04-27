package com.sales.apirest.controller;

import com.sales.apirest.model.dto.ProductRequest;
import com.sales.apirest.model.dto.ProductResponse;
import com.sales.apirest.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@Tag(name = "Products", description = "operations related to products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Operation(summary = "Register a product",
            description = "return a product registered")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return productService.createProduct(request);
    }

    @Operation(summary = "Get all products",
            description = "returns a list of products")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @Operation(summary = "Get a product",
            description = "Return product by id")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("{id}")
    public ProductResponse getById(@Parameter(description = "Product identifier", example = "1")  @PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @Operation(summary = "Update a product",
            description = "Return product updated")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @PutMapping("{id}")
    public ProductResponse getById(@Parameter(description = "Product identifier", example = "1") @PathVariable("id") Long id, @RequestBody ProductRequest product){
        return productService.updateProduct(id, product);
    }

    @Operation(summary = "Delete a product",
            description = "Return NoContent")
    @ApiResponse(responseCode = "204", description = "Successful operation")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Product identifier", example = "1") @PathVariable("id") Long id){
        productService.deleteProductById(id);
    }
}
