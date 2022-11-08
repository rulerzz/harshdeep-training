package com.learnSQL.mayank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;

@Service
public interface MainService {

	List<User> getAllUsers();

	UserCreationDTO createuser(UserCreationRequestDTO user);

}
