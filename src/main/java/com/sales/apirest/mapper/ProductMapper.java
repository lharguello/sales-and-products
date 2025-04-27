package com.sales.apirest.mapper;

import com.sales.apirest.model.dto.ProductRequest;
import com.sales.apirest.model.dto.ProductResponse;
import com.sales.apirest.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponse toProductResponse(Product product);
    Product toProduct(ProductRequest productRequest);
}
