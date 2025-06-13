package com.bank.model;

public class NewCustomerBean {

	private int id;
	private String first_name;
	private String last_name;
	private String dob;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private String account_type;
	private double initial_deposit;


	public NewCustomerBean(String first_name, String last_name, String dob, String gender, String email, String phone,
			String address, String account_type, double initial_deposit) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.account_type = account_type;
		this.initial_deposit = initial_deposit;
	}



	public NewCustomerBean(int id, String first_name, String last_name, String dob, String gender, String email,
			String phone, String address, String account_type, double initial_deposit) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.account_type = account_type;
		this.initial_deposit = initial_deposit;
	}

    

	public NewCustomerBean() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getAccount_type() {
		return account_type;
	}



	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}



	public double getInitial_deposit() {
		return initial_deposit;
	}



	public void setInitial_deposit(double initial_deposit) {
		this.initial_deposit = initial_deposit;
	}





}
