package com.gl.spring.ecommerce.mapper;

import org.springframework.stereotype.Component;
import com.gl.spring.ecommerce.Dto.OrderDTO;
import com.gl.spring.ecommerce.entity.Order;

@Component
public class OrderMapper {

	public static OrderDTO mapToOrder(Order order) {
		OrderDTO orderdto = OrderDTO.builder().
				order_id(order.getOrder_id()).
				order_date(order.getOrder_date()).
				customer_name(order.getCustomer_name()).
				order_price(order.getOrder_price()).
				payment_status(order.getPayment_status())
				.order_stage(order.getOrder_stage())
				.build();
		
		return orderdto;
		
	}
	
	public static Order mapOrderDToToOrder(OrderDTO orderdto) {
		Order order = Order.builder().order_id(orderdto.getOrder_id()).
				order_date(orderdto.getOrder_date()).
				customer_name(orderdto.getCustomer_name()).
				order_price(orderdto.getOrder_price()).
				payment_status(orderdto.getPayment_status()).
				order_stage(orderdto.getOrder_stage())
				.build();
		
		return order;
		
	}
}
