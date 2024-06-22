package com.gl.spring.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

	private int id;
	private final String fname;
	private final String lname;
	private final Long phone;
	private final String email;
	private final String address;
	private final String username;
	private final String password;
	private final String role;

}
