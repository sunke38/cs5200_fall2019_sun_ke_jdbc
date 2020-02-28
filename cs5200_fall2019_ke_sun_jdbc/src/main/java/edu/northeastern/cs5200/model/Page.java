package edu.northeastern.cs5200.model;

import java.util.Date;
import java.util.List;

public class Page {


	private int id;
	private String title;
	private String description;
	private Date created;
	private Date updated;
	private int  views;
	private Website website;
	private List<Widget> widgets;
	public Page(int id, String title, String description, Date created, Date updated, int views) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
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

	public int getViews() {
		return views;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setViews(int views) {
		this.views = views;
	}
	public Website getWebsite() {
		return website;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}
	public void addWidgets(Widget widget) {
		this.widgets.add(widget);
	}
	@Override
	public String toString() {
		return "Page [id=" + id + ", title=" + title + ", description=" + description + ", created=" + created
				+ ", updated=" + updated + ", views=" + views +  "]";
	}
	public void print() {
		System.out.println(this.toString());
	}
}

