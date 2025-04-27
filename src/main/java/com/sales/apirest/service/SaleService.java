package com.sales.apirest.service;

import com.sales.apirest.exception.BadRequestException;
import com.sales.apirest.exception.NotFoundException;
import com.sales.apirest.mapper.SaleMapper;
import com.sales.apirest.model.dto.SaleResponse;
import com.sales.apirest.model.dto.SalesByDateResponse;
import com.sales.apirest.model.dto.SalesPeriodResponse;
import com.sales.apirest.model.entity.Product;
import com.sales.apirest.model.entity.Sale;
import com.sales.apirest.repository.ProductRepository;
import com.sales.apirest.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public List<SaleResponse> getAll(){
        return saleRepository.findAll()
                .stream()
                .map(saleMapper::toSaleResponse)
                .toList();
    }

    public SaleResponse getSaleById(Long id){
        return saleRepository.findById(id)
                .map(saleMapper::toSaleResponse)
                .orElseThrow(()-> new NotFoundException("Sale not found"));
    }

    public SaleResponse createSale(Long productId, Double totalProducts){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new NotFoundException("Product not found"));

        if(totalProducts > product.getStock()){
            throw new BadRequestException("The quantity of products requested cannot be greater than the available stock");
        }

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantity(totalProducts);
        sale.setUnitPrice(product.getUnitPrice());
        sale.setTotal(totalProducts * product.getUnitPrice());
        sale.setDate(LocalDateTime.now());

        Sale saleSaved = saleRepository.save(sale);
        product.setStock(product.getStock()-totalProducts);
        productRepository.save(product);

        return saleMapper.toSaleResponse(saleSaved);
    }

    public SalesPeriodResponse findByDateRange(LocalDateTime startDate, LocalDateTime endDate){
         List<SalesByDateResponse> salesByDate = saleRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(saleMapper::toSalesByDateResponse)
                .toList();

        double totalSales = salesByDate.stream()
                .mapToDouble(SalesByDateResponse::getTotal)
                .sum();

        return new SalesPeriodResponse(salesByDate, totalSales);
    }
}
