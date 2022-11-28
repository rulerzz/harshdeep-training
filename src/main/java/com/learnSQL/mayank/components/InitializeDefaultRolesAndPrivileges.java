package com.learnSQL.mayank.components;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.learnSQL.mayank.domain.Privilege;
import com.learnSQL.mayank.domain.Role;
import com.learnSQL.mayank.domain.User;
import com.learnSQL.mayank.repository.PrivilegeRepository;
import com.learnSQL.mayank.repository.RoleRepository;
import com.learnSQL.mayank.repository.UserRepository;

@Component
public class InitializeDefaultRolesAndPrivileges implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;	

	@Transactional
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (alreadySetup)
			return;
		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

		Optional<Role> adminRole = roleRepository.findByName("ROLE_ADMIN");
		Optional<User> userCheck = userRepository.findByEmail("admin@admin.com");
		if (userCheck.isEmpty()) {
			User user = new User();

			user.setFirstName("Test");
			user.setLastName("Admin");
			user.setPassword("$2a$10$BTFPUPIJnXhzDkL9VMiBx.JMxc0Fo9qa8WBp1GX3BSU.r01Xu9RqG");
			user.setEmail("admin@admin.com");
			user.setRoles(Arrays.asList(adminRole.get()));
			user.setEnabled(true);
			user.setCreatedDate(new Date().toString());

			userRepository.save(user);

			alreadySetup = true;
		}
	}

	@Transactional
	Privilege createPrivilegeIfNotFound(String name) {

		Optional<Privilege> privilege = privilegeRepository.findByName(name);
		if (privilege.isEmpty()) {
			Privilege newPrivilege = new Privilege(name);
			privilegeRepository.save(newPrivilege);
			return newPrivilege;
		}
		return privilege.get();
	}

	@Transactional
	Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

		Optional<Role> role = roleRepository.findByName(name);
		if (role.isEmpty()) {
			Role newRole = new Role(name);
			newRole.setPrivileges(privileges);
			roleRepository.save(newRole);
			return newRole;
		}
		return role.get();
	}
}
