package com.youtube.clean.code;

import java.util.List;

import com.youtube.clean.code.builder.Account;
import com.youtube.clean.code.builder.Address;
import com.youtube.clean.code.builder.Name;

/**
 * Builder pattern is an object creation software design pattern. 
 * 
 * It solves many problems and challenges such as the "never-ending constructor parameter" anti-pattern. 
 * 
 * Benefits of the java builder pattern:
 * - No need to pass Null objects into the constructor.
 * - You don’t need to guess or try to work out which constructor parameter "maps" to a certain object’s field. Error prone!
 * - Easily made into an Immutable class. 
 * 		You can now share the object safely between threads or in a multi-threaded environment 
 * 		as you don’t need to worry about mutation(biến đổi) of variable state. 
 * - Provides control over(kiểm soát) object construction steps and provides meaningful semantic(ngữ nghĩa) method names.
 * (Cung cấp khả năng kiểm soát các bước xây dựng đối tượng và cung cấp các tên phương thức ngữ nghĩa có ý nghĩa.)
 * - Increases the use-ability, maintainability and readability of code when creating objects.
 * 
 * Disadvantages
 * - Immutable
 * - Inner static class
 * - Designed first
 * - Complex(phức tạp)
 * 
 * @author daoth
 *
 */
public class ProblemDesign {

	public static void main(String[] args) {
		Account1 acc1 = new Account1(1, "daomy123@gmail.com", "My", List.of("Thi"), "Dao", 117, "70000", "222222,ssss, oooo", "HCM");
		System.out.println(acc1.toString());
		// Problem: 
		// Có khá nhiều param truyền vào để init Object nhưng chúng ta chả biết những giá trị đó là gì
		// ==> khó đọc
		// Một số giá trị là null, không cần truyền vào
		// ==> constructor dài
		
		// Resolve
		// use the Builder Design
		
		Name name = new Name.Builder()
							.setFirstName("My")
							.setMiddleNames(List.of("Thi"))
							.setSurName("Dao")
							.build();
		
		Address address = new Address.Builder()
									.setZipCode("70000")
									.setCity("HCM")
									.setHouseNumber(117)
									.setStreet("2222.ssss,oooo")
									.build();
		Account account = new Account.Builder()
							.setId(1)
							.setEmail("daomy123@gmail.com")
							.setName(name)
							.setAddress(address)
							.build();
		System.out.println(account.toString());
	}
}

class Account1{
	private int id;
	private String email;
	private String firstName;
	private List<String> middleNames;
	private String surName;
	private int houseNumber;
	private String zipCode;
	private String Street;
	private String city;


	public Account1(int id, String email, String firstName, List<String> middleNames, String surName, int houseNumber, String zipCode,
			String street, String city) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.middleNames = middleNames;
		this.surName = surName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		Street = street;
		this.city = city;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<String> getMiddleNames() {
		return middleNames;
	}
	public void setMiddleNames(List<String> middleNames) {
		this.middleNames = middleNames;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Account1 [id=" + id + ", email=" + email + ", firstName=" + firstName + ", middleNames=" + middleNames
				+ ", surName=" + surName + ", houseNumber=" + houseNumber + ", zipCode=" + zipCode + ", Street="
				+ Street + ", city=" + city + "]";
	}

}
