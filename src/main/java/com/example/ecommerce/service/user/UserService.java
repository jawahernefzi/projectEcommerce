package com.example.ecommerce.service.user;

import com.example.ecommerce.dto.SignupDTO;
import com.example.ecommerce.dto.UserDTO;

public interface UserService {

	UserDTO createUser(SignupDTO signupDTO);


	boolean hasUserWithEmail(String email);

}
