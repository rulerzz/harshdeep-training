package com.learnSQL.mayank.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.learnSQL.mayank.domain.Address;
import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.dto.AddressDto;

public class AddressDTOsToAddress {
	public static List<Address> Map(List<AddressDto> dtos, User user) {
		return dtos.stream().map(element -> new Address(element.getLocality(), element.getArea(), element.getLandmark(),
				element.getPinCode(), element.getCity(), user)).collect(Collectors.toList());
	}
}
