package com.satso.nhl.SatsoAssess;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	private String title;
	private String name;
	private String surname;
	private String date_of_birth;
	private String cellnumber;
	private String email;
	private String product;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getCellnumber() {
		return cellnumber;
	}
	public void setCellnumber(String cellnumber) {
		this.cellnumber = cellnumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Customer [Title=" + title + ", Name=" + name + ", Surname=" + surname + ", Date of birth="
				+ date_of_birth + ", Cellnumber=" + cellnumber + ", Email=" + email + ", Product=" + product + "]";
	}
	
	
	
	
	

}
