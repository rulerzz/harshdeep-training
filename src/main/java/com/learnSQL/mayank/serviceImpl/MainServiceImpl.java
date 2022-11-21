package com.learnSQL.mayank.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.Address;
import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;
import com.learnSQL.mayank.mappers.AddressDTOsToAddress;
import com.learnSQL.mayank.repository.AddressRepository;
import com.learnSQL.mayank.repository.UserRepository;
import com.learnSQL.mayank.service.MainService;
import com.learnSQL.mayank.util.PasswordUtil;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		try {
			Iterable<User> iterable = userRepository.findAll();
			iterable.forEach(allUsers::add);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allUsers;
	}

	@Override
	public UserCreationDTO createuser(UserCreationRequestDTO userdto) {
		UserCreationDTO dto = new UserCreationDTO();
		User user = new User();
		try {
			user.setUserName(userdto.getUserName());
			String generatedSecuredPasswordHash = PasswordUtil.generateStorngPasswordHash("12345678");
			user.setPassword(generatedSecuredPasswordHash);
			userRepository.save(user);
			List<Address> addresses = AddressDTOsToAddress.Map(userdto.getAddresses(), user);
			addresses.forEach(address -> {
				addressRepository.save(address);
			});
			dto.setStatus("created");
			dto.setMessage("successful");
		} catch (Exception e) {
			dto.setStatus("failed to create");
			dto.setMessage(e.getMessage());
		}
		return dto;
	}

}
