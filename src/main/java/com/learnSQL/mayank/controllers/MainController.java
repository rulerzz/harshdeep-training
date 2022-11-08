package com.learnSQL.mayank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;
import com.learnSQL.mayank.service.MainService;

@RestController
@RequestMapping("main")
public class MainController {

	@Autowired
	private MainService mainService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = mainService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserCreationDTO> create(@RequestBody UserCreationRequestDTO user) {
		UserCreationDTO userCreatedResponse = mainService.createuser(user);
		return new ResponseEntity<UserCreationDTO>(userCreatedResponse, HttpStatus.OK);
	}
}
