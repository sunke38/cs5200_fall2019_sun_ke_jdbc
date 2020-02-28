package edu.northeastern.cs5200.model;

public class Role {

	private String role;
	private int targetId;
	private int developerId;
	
	
	
	public Role(int id, String role, int targetId, int developerId) {

		this.role = role;
		this.targetId = targetId;
		this.developerId = developerId;
	}
	

	public String getRole() {
		return role;
	}
	public int getTargetId() {
		return targetId;
	}
	public int getDeveloperId() {
		return developerId;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	
	public static int roleStringtoId(String role) {
		switch (role) {
			case "owner":
				return 0;
			case "admin":
				return 1;
			case "writer":
				return 2;
			case "editor":
				return 3;
			case "reviewer":
				return 4;
		}
		return -1;
	}
	public static String roleIdtoString(int role) {
		switch (role) {
			case 0:
				return "owner";
			case 1:
				return "admin";
			case 2:
				return "writer";
			case 3:
				return "editor";
			case 4:
				return "reviewer";
		}
		return null;
	}
	
}
