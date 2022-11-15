package com.learnSQL.mayank.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.repository.UserRepository;
import com.learnSQL.mayank.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean authenticate(String username, String password) {
		Optional<User> user = userRepository.findByUserName(username);
		if (user.isPresent() && user.get().getPassword().equals(password))
			return true;
		return false;
	}

}
