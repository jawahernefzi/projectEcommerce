package com.example.ecommerce.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.SignupDTO;
import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.entities.User;
import com.example.ecommerce.enums.UserRole;
import com.example.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDTO createUser(SignupDTO signupDTO) {
		User user = new User();
		user.setName(signupDTO.getName());
		user.setEmail(signupDTO.getEmail());
		user.setUserRole(UserRole.USER);
		user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
		User createdUser = userRepository.save(user); 
		UserDTO userDTO = new UserDTO();
		userDTO.setId(createdUser.getId());
		userDTO.setName(createdUser.getName());
		userDTO.setEmail(createdUser.getEmail());
		userDTO.setUserRole(createdUser.getUserRole());
		return userDTO;
	}

	public boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByEmail(email) != null;
		
	}
	
	
}
