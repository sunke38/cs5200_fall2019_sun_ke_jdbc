package edu.northeastern.cs5200.model;

import java.util.Date;

public class Person {
	private int id;
	private String fristname;
	private String lastname;
	private String username;
	private String password;
	private String email;


	private String stree1;
	private String stree2;
	private String city;
	private String state;

	private String zip;


	private String phone;
	private Date dob;
	
	public Person(int id, String fristname, String lastname, String username, String password, String email,
			String stree1,String stree2,String city,String state,String zip, String phone, Date dob) {
		super();
		this.id = id;
		this.fristname = fristname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		
		this.stree1=stree1;
		this.stree2=stree2;
		this.city=city;
		this.zip=zip;
		this.state=state;
		this.phone = phone;
		this.dob = dob;
	}
	public Person(int id, String fristname, String lastname, String username, String password, String email, Date dob) {
		super();
		this.id = id;
		this.fristname = fristname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
		
		this.stree1="123";
		this.stree2="BBQ street";
		this.city="Boston";
		this.state="MA";
		this.zip="02115";

		this.phone = "888-888-8888";
	}
	public Person() {
		
	}
	public int getId() {
		return id;
	}

	public String getFristname() {
		return fristname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getDob() {
		return dob;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStree1() {
		return stree1;
	}
	public String getStree2() {
		return stree2;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public void setStree1(String stree1) {
		this.stree1 = stree1;
	}
	public void setStree2(String stree2) {
		this.stree2 = stree2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


}
