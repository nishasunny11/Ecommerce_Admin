package com.gl.spring.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gl.spring.ecommerce.entity.Order;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
