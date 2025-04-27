package com.sales.apirest.service;

import com.sales.apirest.exception.BadRequestException;
import com.sales.apirest.exception.NotFoundException;
import com.sales.apirest.mapper.ProductMapper;
import com.sales.apirest.model.dto.ProductRequest;
import com.sales.apirest.model.dto.ProductResponse;
import com.sales.apirest.model.entity.Product;
import com.sales.apirest.model.entity.Sale;
import com.sales.apirest.repository.ProductRepository;
import com.sales.apirest.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final SaleRepository saleRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    public ProductResponse getProductById(Long id){
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public List<ProductResponse> getAllProduct(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return productRepository.findById(id)
                .map(prod -> {
                    prod.setDescription(productRequest.getDescription());
                    prod.setUnitPrice(productRequest.getUnitPrice());
                    prod.setStock(productRequest.getStock());
                    productRepository.save(prod);

                    return productMapper.toProductResponse(prod);
                })
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public void deleteProductById(Long id){
        productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        List<Sale> productInSales = productRepository.findById(id)
                .map(saleRepository::findByProduct)
                 .stream()
                 .flatMap(List::stream)
                 .toList();

         if(!productInSales.isEmpty())
             throw new BadRequestException("the product is in use in a sale");

        productRepository.deleteById(id);
    }
}
