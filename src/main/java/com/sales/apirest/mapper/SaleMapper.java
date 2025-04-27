package com.sales.apirest.mapper;

import com.sales.apirest.model.dto.SaleResponse;
import com.sales.apirest.model.dto.SalesByDateResponse;
import com.sales.apirest.model.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    @Mapping(target = "productId", source = "product.id")
    SaleResponse toSaleResponse(Sale sale);

    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productDescription", source = "product.description")
    @Mapping(target = "totalSales", source = "total")
    SalesByDateResponse toSalesByDateResponse(Sale sale);
}
