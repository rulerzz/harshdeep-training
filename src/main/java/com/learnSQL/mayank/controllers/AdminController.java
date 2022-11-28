package com.learnSQL.mayank.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;
import com.learnSQL.mayank.dto.UserDeletionDTO;
import com.learnSQL.mayank.dto.UserDto;
import com.learnSQL.mayank.service.MainService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private MainService mainService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> get() {
		List<UserDto> allUsers = mainService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<UserCreationDTO> create(@RequestBody UserCreationRequestDTO user)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		UserCreationDTO userCreatedResponse = mainService.createuser(user);
		return new ResponseEntity<UserCreationDTO>(userCreatedResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<UserDeletionDTO> delete(@RequestParam Long id) {
		UserDeletionDTO userDeletedResponse = mainService.deleteUser(id);
		return new ResponseEntity<UserDeletionDTO>(userDeletedResponse, HttpStatus.OK);
	}
}
