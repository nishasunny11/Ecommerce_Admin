package com.gl.spring.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.spring.ecommerce.entity.User;
import com.gl.spring.ecommerce.mapper.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepository;

	public void addUser(User user) {
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public boolean validateUser(String username, String password, String role) {
		User user = userRepository.findByUsername(username);
		if ((user != null && user.getPassword().equalsIgnoreCase(password))
				&& (user.getUsername().equalsIgnoreCase(username) && (user.getRole().equalsIgnoreCase(role)))) {
			return true;
		}
		return false;
	}
}
