package com.learnSQL.mayank.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	Boolean authenticate(String username, String password);

}
