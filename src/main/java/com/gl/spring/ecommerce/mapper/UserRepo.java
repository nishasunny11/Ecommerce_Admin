package com.gl.spring.ecommerce.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.spring.ecommerce.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
}
