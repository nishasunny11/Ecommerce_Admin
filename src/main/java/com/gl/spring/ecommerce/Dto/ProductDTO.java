package com.gl.spring.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
	private int product_id;
    private String product_name;
    private String product_description;
    private int product_price;
    private String product_category;
    private boolean available;
    private String image; // Base64 encoded image data
    private String imageType; // MIME type of the image

}

