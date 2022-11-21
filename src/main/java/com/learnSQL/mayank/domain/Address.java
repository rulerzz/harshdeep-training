package com.learnSQL.mayank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address_locality")
	@NotNull
	@NotEmpty
	private String locality;
	
	@Column(name = "address_area")
	@NotNull
	@NotEmpty
	private String area;
	
	@Column(name = "address_landmark")
	@NotNull
	@NotEmpty
	private String landmark;
	
	@Column(name = "address_pincode")
	@NotNull
	@NotEmpty
	private String pinCode;
	
	@Column(name = "address_city")
	@NotNull
	@NotEmpty
	private String city;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
	public Address() {
		super();
	}
	
	public Address(@NotNull @NotEmpty String locality, @NotNull @NotEmpty String area,
			@NotNull @NotEmpty String landmark, @NotNull @NotEmpty String pinCode, @NotNull @NotEmpty String city,
			User user) {
		super();
		this.locality = locality;
		this.area = area;
		this.landmark = landmark;
		this.pinCode = pinCode;
		this.city = city;
		this.user = user;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
