package com.learnSQL.mayank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;
import com.learnSQL.mayank.dto.UserDeletionDTO;
import com.learnSQL.mayank.dto.UserDto;

@Service
public interface MainService {

	List<UserDto> getAllUsers();

	UserCreationDTO createuser(UserCreationRequestDTO user);

	UserDeletionDTO deleteUser(Long id);

}
