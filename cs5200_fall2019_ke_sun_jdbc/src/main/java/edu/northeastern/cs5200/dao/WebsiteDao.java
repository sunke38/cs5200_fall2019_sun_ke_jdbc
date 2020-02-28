package edu.northeastern.cs5200.dao;

import java.util.List;

import edu.northeastern.cs5200.model.*;

public interface WebsiteDao {
	void createWebsiteForDeveloper(int developerId, Website website);
	
	List<Website> findAllWebsites();

	List<Website> findWebsitesForDeveloper(int developerId);

	Website findWebsiteById(int websiteId);

	int updateWebsite(int websiteId, Website website);

	int deleteWebsite(int websiteId);

}
