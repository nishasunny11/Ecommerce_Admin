package com.gl.spring.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.spring.ecommerce.Dto.OrderDTO;
import com.gl.spring.ecommerce.entity.Order;
import com.gl.spring.ecommerce.mapper.OrderMapper;
import com.gl.spring.ecommerce.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	private final OrderRepo orderRepo;

	@Autowired
	public OrderServiceImpl(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;

	}

	@Override
	public List<OrderDTO> findallOrders() {
		List<Order> order = orderRepo.findAll();
		// TODO Auto-generated method stub
		return order.stream().map(OrderMapper::mapToOrder).collect(Collectors.toList());
	}

	@Override
	public void addOrder(OrderDTO orderDto) {
		Order order = OrderMapper.mapOrderDToToOrder(orderDto);

		orderRepo.save(order);
		// TODO Auto-generated method stub

	}

	@Override
	public OrderDTO getOrderById(int id) {
		Order order = orderRepo.findById(id).get();
		// TODO Auto-generated method stub
		return OrderMapper.mapToOrder(order);
	}
}
