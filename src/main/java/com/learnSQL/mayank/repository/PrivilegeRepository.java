package com.learnSQL.mayank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnSQL.mayank.domain.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{

	Optional<Privilege> findByName(String name);

}
