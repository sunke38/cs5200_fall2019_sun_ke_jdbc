package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import edu.northeastern.cs5200.dao.*;

import edu.northeastern.cs5200.model.*;
import edu.northeastern.cs5200.model.Widget.Type;

public class Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection db = MySQLConnection.getConnection();
		updateDeveloperConnection(db);
		updateWidget(db);
		//updatePage(db);
		updatewebsite(db);
		swapCNETHome(db);
	}
	private static void updateDeveloperConnection (Connection db)throws SQLException, ClassNotFoundException {
		DeveloperImpl d1  = new DeveloperImpl(db);
		Developer dev = d1.findDeveloperByUsername("charlie");
		dev.setPhone("333-444-5555");
		d1.updateDeveloper(dev.getId(), dev);
		dev = d1.findDeveloperByUsername("charlie");
		dev.print();
		//d2.deleteDeveloper(d1.findDeveloperByUsername("charlie").getId());
	}
	private static void updateWidget (Connection db)throws SQLException, ClassNotFoundException {
		
		WidgetImpl w1  = new WidgetImpl(db);
		
		Widget head345 = new Widget(3, "head345", 0, 0, "", "", "Hi", 3,Type.Heading,"",false,false);
		
		Widget image345= new Widget(5, "image345", 50, 100, "", "", "", 1,Type.Image,"/img/567.png",false,false);
		System.out.println("change head345 and image345 order \n");
		w1.updateWidget(head345.getId(),head345);
		w1.updateWidget(image345.getId(),image345);
	}
	private static void updatePage (Connection db)throws SQLException, ClassNotFoundException {
		PageImpl p1 = new PageImpl(db);
		List<Page> cnetl = p1.findPagesForWebsite(567);//CNET
		for(Page i : cnetl) {
			i.setTitle("CNET - "+i.getTitle());
			p1.updatePage(i.getId(), i);
		}
		cnetl = p1.findPagesForWebsite(567);
		System.out.println("add CNET - at end of description of pages for CNET \n");
		for(Page i : cnetl) {
			i.print();
		}
	}
	private static void updatewebsite (Connection db)throws SQLException, ClassNotFoundException {
		WebsiteImpl w1 = new WebsiteImpl(db);
		Website w = w1.findWebsiteById(456);
		w.setDescription(w.getDescription()+".");
		w1.updateWebsite(w.getId(), w);
		w = w1.findWebsiteById(w.getId());
		System.out.println("add . at end of description of cnn\n");
		w.print();
	}
	
	private static void swapCNETHome(Connection db)throws SQLException, ClassNotFoundException {
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com",new Date(0), "5432trew");
		Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com",new Date(0), "6543ytre");
		
		Page home=new Page(123,"Home","Landing page",new Date(),new Date(),123434);
	
		Role HomeReviewer= new Role(1, "reviewer",home.getId(),bob.getId());
		Role HomeWriter= new Role(2, "writer",home.getId(),charlie.getId());
		
		RoleImpl r = new RoleImpl(db);
		r.deletePageRole(HomeReviewer.getDeveloperId(), HomeReviewer.getTargetId(), Role.roleStringtoId(HomeReviewer.getRole()));
		r.deletePageRole(HomeWriter.getDeveloperId(), HomeWriter.getTargetId(), Role.roleStringtoId(HomeWriter.getRole()));
		
		HomeReviewer.setDeveloperId(charlie.getId());
		HomeWriter.setDeveloperId(bob.getId());
		
		r.assignPageRole(HomeReviewer.getDeveloperId(), HomeReviewer.getTargetId(),Role.roleStringtoId(HomeReviewer.getRole()));
		r.assignPageRole(HomeWriter.getDeveloperId(), HomeWriter.getTargetId(),Role.roleStringtoId(HomeWriter.getRole()));
		
	}
	
	

}
