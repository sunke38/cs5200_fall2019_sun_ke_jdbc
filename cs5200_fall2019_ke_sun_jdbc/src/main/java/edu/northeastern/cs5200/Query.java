package edu.northeastern.cs5200;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.northeastern.cs5200.*;
import edu.northeastern.cs5200.dao.*;
import edu.northeastern.cs5200.model.*;
public class Query {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection db = MySQLConnection.getConnection();
		
		DevUserQueryExample(db);
		WebsiteExample(db);
		PageExample(db);
		WidgetExample(db);
		//(int id, String fristname, String lastname, String username, String password, String email,Date dob,String developerKey)
		
		
		
		
		
	}

	private static void DevUserQueryExample(Connection db)throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		DeveloperImpl devAll = new DeveloperImpl(db);
		
		List<Developer> rs =devAll.findAllDevelopers();
		
		for(Developer i : rs) {
			i.print();
		}
		DeveloperImpl devId = new DeveloperImpl(db);
		Developer dev = devId.findDeveloperById(23);
		System.out.print("\nBy Id\n");
		dev.print();
		
		DeveloperImpl devUsername = new DeveloperImpl(db);
		dev =devUsername.findDeveloperByUsername("bob");
		System.out.print("\nBy Username\n");
		dev.print();
		
		DeveloperImpl devCredentials = new DeveloperImpl(db);
		dev = devCredentials.findDeveloperByCredentials("charlie","charlie");
		System.out.print("\nBy Credentials\n");
		dev.print();
	}
	private static void WebsiteExample(Connection db)throws SQLException, ClassNotFoundException {
		WebsiteImpl w1 = new WebsiteImpl(db);
		List<Website> ret = w1.findAllWebsites();
		System.out.println("all website\n");
		for(Website i : ret)
			i.print();
		System.out.println("website By dev\n");
		WebsiteImpl w2 = new WebsiteImpl(db);
		ret = w2.findWebsitesForDeveloper(23);
		for(Website i : ret)
			i.print();
		System.out.println("website By id\n");
		WebsiteImpl w3 = new WebsiteImpl(db);
		Website web = w3.findWebsiteById(123);
		web.print();
	}
	private static void PageExample(Connection db)throws SQLException, ClassNotFoundException {
		PageImpl w1 = new PageImpl(db);
		List<Page> ret = w1.findAllPages();
		System.out.println("all website\n");
		for(Page i : ret)
			i.print();
		System.out.println("Page By web\n");
		PageImpl w2 = new PageImpl(db);
		ret = w2.findPagesForWebsite(567);
		for(Page i : ret)
			i.print();
		System.out.println("Page By id\n");
		PageImpl w3 = new PageImpl(db);
		Page web = w3.findPageById(456);
		web.print();
	}
	private static void WidgetExample(Connection db)throws SQLException, ClassNotFoundException {
		WidgetImpl w1 = new WidgetImpl(db);
		List<Widget> ret = w1.findAllWidgets();
		System.out.println("all widge\n");
		for(Widget i : ret)
			i.print();
		WidgetImpl w2 = new WidgetImpl(db);
		System.out.println("By page\n");
		ret = w2.findWidgetsForPage(345);
		for(Widget i : ret)
			i.print();
		WidgetImpl w3 = new WidgetImpl(db);
		System.out.println("By id\n");
		Widget w = w3.findWidgetById(2);
		w.print();
		
	}
	
}
