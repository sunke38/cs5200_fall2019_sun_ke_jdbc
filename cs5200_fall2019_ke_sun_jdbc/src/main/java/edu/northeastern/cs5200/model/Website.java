package edu.northeastern.cs5200.model;

import java.util.Date;
import java.util.List;

public class Website {
	private int id;
	private String name;
	private String description;
	private Date created;
	private Date updated;
	private int  visits;
	private List<Page> pages;
	


	public Website(int id, String name, String description, Date created, Date updated, int visits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}

	public int getVisits() {
		return visits;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}
	
	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	public void addPages(Page page) {
		this.pages.add(page);
	}

	@Override
	public String toString() {
		return "Website [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created
				+ ", updated=" + updated + ", visits=" + visits + "]";
	}
	
	public void print() {
		System.out.println(this.toString());
	}
	
	
}

/*
 * CREATE TABLE website
(
Id Int,
Id_developer int,
name varchar(32),
description varchar(2048),
created Date,
updated Date,
visits Int,
PRIMARY KEY (Id),
FOREIGN KEY (Id_developer) REFERENCES developer(Id) ON DELETE CASCADE
);*/
