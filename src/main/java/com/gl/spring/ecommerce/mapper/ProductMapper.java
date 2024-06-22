package com.gl.spring.ecommerce.mapper;

import org.springframework.stereotype.Component;
import com.gl.spring.ecommerce.Dto.ProductDTO;
import com.gl.spring.ecommerce.entity.Product;

@Component
public class ProductMapper {

    public static ProductDTO toDto(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setProduct_id(entity.getProduct_id());
        dto.setProduct_name(entity.getProduct_name());
        dto.setProduct_description(entity.getProduct_description());
        dto.setProduct_price(entity.getProduct_price());
        dto.setProduct_category(entity.getProduct_category());
        dto.setAvailable(entity.isAvailable());
        dto.setImage(entity.getImage());
        dto.setImageType(entity.getImageType());
        
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setProduct_id(dto.getProduct_id());
        entity.setProduct_name(dto.getProduct_name());
        entity.setProduct_description(dto.getProduct_description());
        entity.setProduct_price(dto.getProduct_price());
        entity.setProduct_category(dto.getProduct_category());
        entity.setAvailable(dto.isAvailable());
        entity.setImage(dto.getImage());
        entity.setImageType(dto.getImageType());
        
        return entity;
    }
}
