package com.learnSQL.mayank.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.repository.UserRepository;
import com.learnSQL.mayank.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Boolean authenticate(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword()))
			return true;
		return false;
	}

}
