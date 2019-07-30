package com.freenow.api.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "drive_license")
	private String driveLicense;

	@Column(name = "rating")
	private int rating;

	@Column(name = "member_since")
	private LocalDate memberSince;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDriveLicense() {
		return driveLicense;
	}
	public void setDriveLicense(String driveLicense) {
		this.driveLicense = driveLicense;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public LocalDate getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(LocalDate memberSince) {
		this.memberSince = memberSince;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
