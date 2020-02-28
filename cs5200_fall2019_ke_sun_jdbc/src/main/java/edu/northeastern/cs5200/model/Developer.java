package edu.northeastern.cs5200.model;

import java.util.Date;

public class Developer extends Person{
	private String developerKey;
	private int id;

	public Developer(int id, String fristname, String lastname, String username, String password, String email,
			Date dob,String developerKey) {
		super(id, fristname, lastname, username, password, email, dob);
		this.id = id;
		this.developerKey = developerKey;
		// TODO Auto-generated constructor stub
	}


	public Developer(int id, String fristname, String lastname) {
		super(id, fristname, lastname, "test", "123","dev@gmail.com", new Date(0));
		this.id = id;
		this.developerKey = developerKey;
		// TODO Auto-generated constructor stub
	}
	public Developer(int id, String fristname, String lastname, String username, String password, String email,
			String stree1,String stree2,String city,String state,String zip, String phone, Date dob,String developerKey) {
		super(id, fristname, lastname, username, password, email, stree1, stree2, city,state,zip, phone, dob);
		this.id = id;
		this.developerKey = developerKey;
		// TODO Auto-generated constructor stub
	}



	public Developer() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}
	public void print() {
		System.out.print(this.getId()+" "+this.getFristname()+" "+this.getLastname()+" "+this.getDob().toString()+" "+this.getPhone()+" "+this.getStree1()+this.getCity()+" "+this.getState()+"\n");
	}
	
	
}
