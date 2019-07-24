package com.sameer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	String username;
	String addressfrom;
	String addressto;
	float Bill;
	
	public Bookings() {
	}
	
	
	public Bookings(Long id, String username, String addressfrom, String addressto, float bill) {
		super();
		this.id = id;
		this.username = username;
		this.addressfrom = addressfrom;
		this.addressto = addressto;
		Bill = bill;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddressfrom() {
		return addressfrom;
	}
	public void setAddressfrom(String addressfrom) {
		this.addressfrom = addressfrom;
	}
	public String getAddressto() {
		return addressto;
	}
	public void setAddressto(String addressto) {
		this.addressto = addressto;
	}
	public float getBill() {
		return Bill;
	}
	public void setBill(float bill) {
		Bill = bill;
	}

}
