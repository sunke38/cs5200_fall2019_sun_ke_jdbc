package edu.northeastern.cs5200.dao;
import java.util.List;

import edu.northeastern.cs5200.model.*;

public interface PageDao {
	void createPageForWebsite(int websiteId, Page page);

	List<Page> findAllPages();

	Page findPageById(int pageId);

	List<Page> findPagesForWebsite(int websiteId);

	int updatePage(int pageId, Page page);

	int deletePage(int pageId);


}
