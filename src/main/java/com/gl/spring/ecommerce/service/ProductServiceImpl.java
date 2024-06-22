package com.gl.spring.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.spring.ecommerce.Dto.ProductDTO;
import com.gl.spring.ecommerce.entity.Product;
import com.gl.spring.ecommerce.mapper.ProductMapper;
import com.gl.spring.ecommerce.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::toDto) // Use toDTO method here
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = ProductMapper.toEntity(productDTO); // Use toEntity method here
        productRepository.save(product);
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toDto(product);
    }

	@Override
	public void saveProduct(ProductDTO existingProduct) {
		Product product = ProductMapper.toEntity(existingProduct);
		productRepository.save(product);
		
	}
	
	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
}
