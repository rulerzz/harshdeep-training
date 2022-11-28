package com.learnSQL.mayank.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learnSQL.mayank.domain.Address;
import com.learnSQL.mayank.domain.Role;
import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.UserCreationDTO;
import com.learnSQL.mayank.dto.UserCreationRequestDTO;
import com.learnSQL.mayank.dto.UserDeletionDTO;
import com.learnSQL.mayank.dto.UserDto;
import com.learnSQL.mayank.mappers.AddressDTOsToAddress;
import com.learnSQL.mayank.mappers.UserToUserDto;
import com.learnSQL.mayank.repository.AddressRepository;
import com.learnSQL.mayank.repository.RoleRepository;
import com.learnSQL.mayank.repository.UserRepository;
import com.learnSQL.mayank.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> allUsers = new ArrayList<UserDto>();
		try {
			Iterable<User> iterable = userRepository.findAll();
			allUsers = UserToUserDto.Map(iterable);
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
			Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
			user.setFirstName(userdto.getFirstName());
			user.setEmail(userdto.getEmail());
			user.setLastName(userdto.getLastName());
			user.setEnabled(true);
			user.setTokenExpired(false);
			user.setRoles(Arrays.asList(userRole.get()));
			user.setPassword(passwordEncoder.encode("12345678"));
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

	@Override
	@Transactional
	public UserDeletionDTO deleteUser(Long id) {
		UserDeletionDTO response = new UserDeletionDTO();
		try {
			addressRepository.deleteByUserId(id);
			userRepository.deleteById(id);
		} catch (Exception e) {
			response.setStatus("Failed");
			response.setMessage(e.getLocalizedMessage());
			return response;
		}
		response.setStatus("Success");
		response.setMessage("Deleted Successfully");
		return response;
	}

}
