package com.youtube.clean.code.builder;

public class Address {

	private final int houseNumber;
	private final String zipCode;
	private final String street;
	private final String city;
	
	private Address(Builder builder) {
		this.houseNumber = builder.houseNumber;
		this.zipCode = builder.zipCode;
		this.street = builder.street;
		this.city = builder.city;
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	
	public static class Builder{
		private int houseNumber;
		private String zipCode;
		private String street;
		private String city;
		
		public Builder setHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}
		public Builder setZipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Address build() {
			return new Address(this);
		}
	}
}
