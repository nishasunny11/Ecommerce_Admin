package com.gl.spring.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

	private int category_id;
	private String category_name;
	private String category_description;
	private boolean active;
}
