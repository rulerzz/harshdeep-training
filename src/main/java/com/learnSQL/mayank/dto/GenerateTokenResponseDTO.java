package com.learnSQL.mayank.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GenerateTokenResponseDTO {
	public String token;
	public String message;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GenerateTokenResponseDTO(String token, String message) {
		super();
		this.token = token;
		this.message = message;
	}
	
}
