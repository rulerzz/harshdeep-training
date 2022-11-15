package com.learnSQL.mayank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnSQL.mayank.dto.GenerateTokenRequestDTO;
import com.learnSQL.mayank.dto.GenerateTokenResponseDTO;
import com.learnSQL.mayank.service.UserService;
import com.learnSQL.mayank.util.JwtTokenUtil;

@RestController
@RequestMapping("/authorize")
@CrossOrigin
public class SecurityController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<GenerateTokenResponseDTO> createAuthenticationToken(
			@RequestBody GenerateTokenRequestDTO authenticationRequest) throws Exception {

		Boolean check = userService.authenticate(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());

		if (!check)
			return ResponseEntity.status(401).body(new GenerateTokenResponseDTO("null", "Invalid Credentials"));

		final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());

		return ResponseEntity.ok(new GenerateTokenResponseDTO(token, "Success"));
	}
}
