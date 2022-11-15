package com.learnSQL.mayank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learnSQL.mayank.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByUserName(String userName);

}
