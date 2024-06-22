package com.gl.spring.ecommerce.service;

import java.util.List;
import com.gl.spring.ecommerce.Dto.OrderDTO;


public interface OrderService {

	List<OrderDTO> findallOrders();
	void addOrder(OrderDTO orderDto);
	OrderDTO getOrderById(int id);

}
