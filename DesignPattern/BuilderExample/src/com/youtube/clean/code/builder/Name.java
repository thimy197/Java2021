package com.youtube.clean.code.builder;

import java.util.List;

public class Name {

	private final String firstName;
	private final List<String> middleNames;
	private final String surName;
	
	private Name(Builder builder) {
		this.firstName = builder.firstName;
		this.middleNames = builder.middleNames;
		this.surName = builder.surName;
	}

	public String getFirstName() {
		return firstName;
	}

	public List<String> getMiddleNames() {
		return middleNames;
	}

	public String getSurName() {
		return surName;
	}
	
	public static class Builder{
		
		private String firstName;
		private List<String> middleNames;
		private String surName;
		
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public Builder setMiddleNames(List<String> middleNames) {
			this.middleNames = middleNames;
			return this;
		}
		public Builder setSurName(String surName) {
			this.surName = surName;
			return this;
		}
		
		public Name build() {
			return new Name(this);
		}
	}
}
