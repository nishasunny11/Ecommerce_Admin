package com.gl.spring.ecommerce.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.gl.spring.ecommerce.Dto.ProductDTO;
import com.gl.spring.ecommerce.service.CategoryServiceImpl;
import com.gl.spring.ecommerce.service.ProductService;
import com.gl.spring.ecommerce.service.ProductServiceImpl;

@Controller
public class ProductController {

	private final ProductService productService;
	private CategoryServiceImpl categoryService;

	@Autowired
	public ProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<ProductDTO> products = productService.findAllProducts();
		model.addAttribute("productlist", products);
		return "productList";
	}

	@GetMapping("/createProduct")
	public String showCreateProductForm(Model model) {
		model.addAttribute("productsadd", new ProductDTO());
		model.addAttribute("categories", categoryService.findAllCategory());
		return "createProduct";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("productsadd") ProductDTO productDTO,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				if (!file.getContentType().startsWith("image")) {
					return "redirect:/error";
				}
				String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
				productDTO.setImage(base64Image);
				productDTO.setImageType(file.getContentType());
			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/error";
			}
		}
		productService.addProduct(productDTO);
		return "redirect:/products";
	}

	@GetMapping("/product/edit/{id}")
	public String editProductForm(@PathVariable int id, Model model) {
		model.addAttribute("productAttribute", productService.getProductById(id));
		return "updateProduct";
	}

	// mapping for delete functionality
	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "redirect:/products";
	}

	@PostMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable int id, @ModelAttribute("productAttribute") ProductDTO productDTO,
			@RequestParam("file") MultipartFile file) {
		ProductDTO existingProduct = productService.getProductById(id);

		if (!file.isEmpty()) {
			try {
				if (!file.getContentType().startsWith("image")) {
					return "redirect:/error";
				}
				String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
				existingProduct.setImage(base64Image);
				existingProduct.setImageType(file.getContentType());
			} catch (IOException e) {
				e.printStackTrace();
				return "redirect:/error";
			}
		}

		existingProduct.setProduct_name(productDTO.getProduct_name());
		existingProduct.setProduct_category(productDTO.getProduct_category());
		existingProduct.setProduct_description(productDTO.getProduct_description());
		existingProduct.setProduct_price(productDTO.getProduct_price());
		existingProduct.setAvailable(productDTO.isAvailable());

		productService.saveProduct(existingProduct);
		return "redirect:/products";
	}
}
