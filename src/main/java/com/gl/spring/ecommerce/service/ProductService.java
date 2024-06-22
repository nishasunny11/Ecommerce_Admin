package com.gl.spring.ecommerce.service;

import com.gl.spring.ecommerce.Dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();
    void addProduct(ProductDTO productDTO);
    ProductDTO getProductById(int id);
	void saveProduct(ProductDTO existingProduct);
	void deleteProduct(int id);
}
