package edu.northeastern.cs5200;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import edu.northeastern.cs5200.dao.DeveloperImpl;
import edu.northeastern.cs5200.dao.PageImpl;
import edu.northeastern.cs5200.dao.UserImpl;
import edu.northeastern.cs5200.dao.WebsiteImpl;
import edu.northeastern.cs5200.dao.WidgetImpl;
import edu.northeastern.cs5200.model.Developer;
import edu.northeastern.cs5200.model.Page;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.model.Website;

public class Delete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection db = MySQLConnection.getConnection();
		removeDeveloperConnection(db);
		removeWidget(db);
		removeLastUpdatePage(db);
		removeCNET(db);
	}
	private static void removeDeveloperConnection (Connection db)throws SQLException, ClassNotFoundException {
		DeveloperImpl d1  = new DeveloperImpl(db);
		DeveloperImpl d2 = new DeveloperImpl(db);
		
		d1.deleteDeveloperPrimaryAddress(d1.findDeveloperByUsername("alice").getId());
		d1.findDeveloperByUsername("alice").print();
		//d2.deleteDeveloper(d1.findDeveloperByUsername("alice").getId());
	}
	private static void removeWidget (Connection db)throws SQLException, ClassNotFoundException {
		WidgetImpl d1  = new WidgetImpl(db);
		d1.deleteWidget(6);

	}
	private static void removeLastUpdatePage (Connection db)throws SQLException, ClassNotFoundException {
		PageImpl p1  = new PageImpl(db);
		Website wikipedia = new Website(345,"Wikipedia","a free online encyclopedia",new Date(),new Date(),3456654);
		List<Page> wki = p1.findPagesForWebsite(wikipedia.getId());
		Page lastUpdate = new Page(0, "", "", new Date(0), new Date(0), 0);
		for(Page i:wki) {
			if(i==null)
				return;
			if(i.getUpdated().before(lastUpdate.getUpdated()))
				lastUpdate = i;
		}
		p1.deletePage(lastUpdate.getId());
		return;
	}
	private static void removeCNET(Connection db)throws SQLException, ClassNotFoundException {
		WebsiteImpl w = new WebsiteImpl(db);
		Website cnet = new Website(567,"CNET","an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",new Date(),new Date(),5433455);
		w.deleteWebsite(cnet.getId());
	}
}
