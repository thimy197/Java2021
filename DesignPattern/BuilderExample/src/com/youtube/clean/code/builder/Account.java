package com.youtube.clean.code.builder;

/**
 * Steps build "Builder"
 * 1. Ngăn việc khởi tạo hay set giá trị trong POJO class
 * 		- Chỉ sử dụng getter()
 * 		- Constructor() là private và nhận các giá trị từ Builder
 * 2. Tạo static class Builder:
 * 		- Chứa các fields tương tự
 * 		- Sử dụng hàm setter() trả về chính BuilderClass
 * 		- build() để khởi tạo và return POJO class
 * 
 * @author daoth
 *
 */
public class Account {

	/* only getter values so the final key add here */
	private final int id;
	private final String email;
	private final Name name;
	private final Address address;
	
	/**
	 * private constructor
	 * 		to only create AccountObject from Builder
	 * 
	 * @param builder chứa giá trị để khởi tạo
	 */
	private Account(Builder builder) {
		this.id = builder.id;
		this.email = builder.email;
		this.name = builder.name;
		this.address = builder.address;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Name getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}
	
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", name=" + name + ", address=" + address + "]";
	}


	/**
	 * Builder class
	 * - setter():Builder setter được nối liên tiếp
	 * - buil():Account để thực hiện khởi tạo đối tượng được hướng tới
	 * 
	 * @author daoth
	 */
	public static class Builder{
		private int id;
		private String email;
		private Name name;
		private Address address;
		
		public Builder setId(final int id) {
			this.id = id;
			return this;
		}
		
		public Builder setEmail(final String email) {
			this.email = email;
			return this;
		}
		
		public Builder setName(final Name name) {
			this.name = name;
			return this;
		}
		
		public Builder setAddress(final Address address) {
			this.address = address;
			return this;
		}
		
		public Account build() {
			return new Account(this);
		}
	}
}
