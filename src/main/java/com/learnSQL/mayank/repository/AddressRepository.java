package com.learnSQL.mayank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learnSQL.mayank.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	@Modifying
	@Query("delete from Address a where a.user.id=:id")
	void deleteByUserId(@Param("id") Long id);

}
