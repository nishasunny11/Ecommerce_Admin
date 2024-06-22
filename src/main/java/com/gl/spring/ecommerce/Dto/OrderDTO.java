package com.gl.spring.ecommerce.Dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

	private int order_id;
	private LocalDate order_date;
	private String customer_name;
	private double order_price;
	private String payment_status;
	private String order_stage;
}
