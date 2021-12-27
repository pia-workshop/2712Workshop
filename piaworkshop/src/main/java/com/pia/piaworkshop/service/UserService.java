package com.pia.piaworkshop.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pia.piaworkshop.dto.UserDTO;
import com.pia.piaworkshop.model.User;
import com.pia.piaworkshop.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public UserDTO saveUser(UserDTO dto) {
		User existUser=userRepository.findByUsername(dto.getUsername());
		if(Objects.nonNull(existUser)) {
			throw new DataIntegrityViolationException("Bu kullanici isminde kayıt var!!!.");	
		}
		User user=mapUserDTO(dto);
		user.setId(UUID.randomUUID());		
		return mapUser(userRepository.save(user));
	}
	
	public List<UserDTO> findByName(String name){		
//		List<User> userList=userRepository.findByName(name);
//		List<UserDTO>dtos= new ArrayList<UserDTO>();
//		for(User user:userList) {
//			if(Objects.equals("Senihcan", user.getName())) {
//			dtos.add(mapUser(user));		
//			}
//		}				
		return userRepository.findByName(name).stream().map(f-> mapUser(f)).collect(Collectors.toList());
	}
	
	public boolean deleteByUsername(String username) {
		try {
			User existUser= userRepository.findByUsername(username);
			userRepository.delete(existUser);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}
	
	private User mapUserDTO(UserDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setSurname(dto.getSurname());
		user.setUsername(dto.getUsername());
		return user;
	}
	
	private UserDTO mapUser(User user) {
		UserDTO dto= new UserDTO();
		dto.setName(user.getName());
		dto.setSurname(user.getSurname());
		dto.setUsername(user.getUsername());
		return dto;
	}

}
