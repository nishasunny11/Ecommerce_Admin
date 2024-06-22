package com.gl.spring.ecommerce.service;

import java.util.List;
import com.gl.spring.ecommerce.Dto.CategoryDTO;


public interface CategoryService {

	List<CategoryDTO> findAllCategory();
    void addCategory(CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(int id);
	void saveCategory(CategoryDTO existingProduct);
	
}
