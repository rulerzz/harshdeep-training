package com.learnSQL.mayank.dto;

import java.util.Collection;
import java.util.List;

import com.learnSQL.mayank.domain.Address;
import com.learnSQL.mayank.domain.Role;

public class UserDto {
	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private boolean enabled;

	private boolean tokenExpired;

	private String createdDate;

	private String lastUpdated;

	private List<Address> address;

	private Collection<Role> roles;

	public UserDto(Long id, String firstName, String lastName, String email, List<Address> address,
			Collection<Role> roles, boolean tokenExpired, String createdDate, String lastUpdated) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.roles = roles;
		this.tokenExpired = tokenExpired;
		this.createdDate = createdDate;
		this.lastUpdated = lastUpdated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isTokenExpired() {
		return tokenExpired;
	}

	public void setTokenExpired(boolean tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", enabled=" + enabled + ", tokenExpired=" + tokenExpired
				+ ", createdDate=" + createdDate + ", lastUpdated=" + lastUpdated + ", address=" + address + ", roles="
				+ roles + ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", isEnabled()="
				+ isEnabled() + ", isTokenExpired()=" + isTokenExpired() + ", getCreatedDate()=" + getCreatedDate()
				+ ", getLastUpdated()=" + getLastUpdated() + ", getAddress()=" + getAddress() + ", getRoles()="
				+ getRoles() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
