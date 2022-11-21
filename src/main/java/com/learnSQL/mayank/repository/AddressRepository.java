package com.learnSQL.mayank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnSQL.mayank.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
