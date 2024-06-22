package com.gl.spring.ecommerce.mapper;

import org.springframework.stereotype.Component;
import com.gl.spring.ecommerce.Dto.CategoryDTO;
import com.gl.spring.ecommerce.entity.Category;



@Component
public class CategoryMapper {

	public static CategoryDTO toDto(Category entity) {
		CategoryDTO dto = new CategoryDTO();
        dto.setCategory_id(entity.getCategory_id());
        dto.setCategory_name(entity.getCategory_name());
        dto.setCategory_description(entity.getCategory_description());
        dto.setActive(entity.isActive());
       
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
    	Category entity = new Category();
        entity.setCategory_id(dto.getCategory_id());
        entity.setCategory_name(dto.getCategory_name());
        entity.setCategory_description(dto.getCategory_description());
        entity.setActive(dto.isActive());
        
        return entity;
    }
	
}
