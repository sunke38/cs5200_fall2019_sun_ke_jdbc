package edu.northeastern.cs5200.model;

import java.util.ArrayList;
import java.util.List;

public class Priviledge {
	private String priviledge;
	private int targetId;
	private int developerId;
	
	public Priviledge(String priviledge, int targetId, int developerId) {
		this.priviledge = priviledge;
		this.targetId = targetId;
		this.developerId = developerId;
	}

	public String getPriviledge() {
		return priviledge;
	}

	public int getTargetId() {
		return targetId;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setPriviledge(String priviledge) {
		this.priviledge = priviledge;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	
	public static List<Priviledge> getPriviledgeByRole(Role role){
		int lv = Role.roleStringtoId(role.getRole());
		List<Priviledge> ret = new ArrayList<>();
		ret.add(new Priviledge("read",role.getTargetId(),role.getDeveloperId()));
		if(lv<=3)
			ret.add(new Priviledge("update",role.getTargetId(),role.getDeveloperId()));
		if(lv<=2)
			ret.add(new Priviledge("create",role.getTargetId(),role.getDeveloperId()));
		if(lv<=1)
			ret.add(new Priviledge("delete",role.getTargetId(),role.getDeveloperId()));
		return ret;
	}
	
}
