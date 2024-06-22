package com.gl.spring.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.spring.ecommerce.Dto.CategoryDTO;
import com.gl.spring.ecommerce.entity.Category;
import com.gl.spring.ecommerce.mapper.CategoryMapper;
import com.gl.spring.ecommerce.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepository;
	
	public void setCategoryRepository(CategoryRepo categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDTO> findAllCategory() {
		 List<Category> category = categoryRepository.findAll();
	        return category.stream()
	                .map(CategoryMapper::toDto) // Use toDTO method here
	                .collect(Collectors.toList());
	}

	@Override
	public void addCategory(CategoryDTO categoryDTO) {
		Category category = CategoryMapper.toEntity(categoryDTO); // Use toEntity method here
        categoryRepository.save(category);

	}

	@Override
	public CategoryDTO getCategoryById(int id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return CategoryMapper.toDto(category);
	}

	@Override
	public void saveCategory(CategoryDTO existingProduct) {
		Category category = CategoryMapper.toEntity(existingProduct);
		categoryRepository.save(category);
		

	}

}
