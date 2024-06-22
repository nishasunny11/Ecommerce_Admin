package com.gl.spring.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.spring.ecommerce.Dto.CategoryDTO;
import com.gl.spring.ecommerce.service.CategoryService;

@Controller
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<CategoryDTO> categories = categoryService.findAllCategory();
		model.addAttribute("categorylist", categories);
		return "categoryList";
	}

	@GetMapping("/createCategory")
	public String showCreateCategoryForm(Model model) {
		model.addAttribute("categoryadd", new CategoryDTO());
		return "createCategory";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("categoryadd") CategoryDTO categoryDTO) {
		categoryService.addCategory(categoryDTO);
		return "redirect:/categories";
	}

	@GetMapping("/category/edit/{id}")
	public String editCategoryForm(@PathVariable int id, Model model) {
		model.addAttribute("categoryAttribute", categoryService.getCategoryById(id));
		return "updateCategory";
	}


	@PostMapping("/updateCategory/{id}")
	public String updateCategory(@PathVariable int id, @ModelAttribute("categoryAttribute") CategoryDTO categoryDTO) {
		CategoryDTO existingCategory = categoryService.getCategoryById(id);
		existingCategory.setCategory_name(categoryDTO.getCategory_name());
		existingCategory.setCategory_description(categoryDTO.getCategory_description());
		existingCategory.setActive(categoryDTO.isActive());
		categoryService.saveCategory(existingCategory);
		return "redirect:/categories";
	}
}
