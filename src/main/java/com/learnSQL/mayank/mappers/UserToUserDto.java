package com.learnSQL.mayank.mappers;

import java.util.ArrayList;
import java.util.List;

import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.UserDto;

public class UserToUserDto {
	public static List<UserDto> Map(Iterable<User> iterables) {
		List<UserDto> dtos = new ArrayList<UserDto>();
		iterables.forEach(element -> {
			dtos.add(new UserDto(element.getId(), element.getFirstName(), element.getLastName(), element.getEmail(),
					element.getAddress(), element.getRoles(), element.isTokenExpired(), element.getCreatedDate(), element.getLastUpdated()));
		});
		return dtos;
	}
}
