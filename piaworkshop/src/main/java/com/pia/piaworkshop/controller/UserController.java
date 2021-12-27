package com.pia.piaworkshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pia.piaworkshop.dto.UserDTO;
import com.pia.piaworkshop.service.UserService;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired 
	UserService userService;
	
	@PostMapping("/save-user")
	public UserDTO saveUser(@Valid@RequestBody UserDTO userDTO) {	
		return userService.saveUser(userDTO);
	}
	
	@GetMapping("/get-user/{name}")
	public List<UserDTO> findByName(@PathVariable("name")String name){
		
		return userService.findByName(name);
	}
		
}
