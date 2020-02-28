package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.northeastern.cs5200.dao.*;

import edu.northeastern.cs5200.model.*;
import edu.northeastern.cs5200.model.Widget.Type;

public class Create {
	public static SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
	public static Developer alice;
	public static Developer bob;
	public static Developer charlie;
	
	public static Website facebook;
	public static Website twitter;
	public static Website wikipedia;
	public static Website cnn;
	public static Website cnet;
	public static Website gizmodo;
	
	public static Page home;
	public static Page about;
	public static Page contact;
	public static Page preferences;
	public static Page profile;
	
	public static Widget head123;
	public static Widget post234;
	public static Widget head345;
	public static Widget intro456;
	public static Widget image345;
	public static Widget video456;
	
	public static Role facebookEditor;
	public static Role facebookOwner;
	public static Role facebookAdmin;

	public static Role TwitterEditor;
	public static Role TwitterOwner;
	public static Role TwitterAdmin;
	
	public static Role WikipediaEditor;
	public static Role WikipediaOwner;
	public static Role WikipediaAdmin;

	public static Role CNNEditor;
	public static Role CNNOwner;
	public static Role CNNAdmin;
	
	public static Role CNETEditor;
	public static Role CNETOwner;
	public static Role CNETAdmin;
	
	public static Role GizmodoEditor;
	public static Role GizmodoOwner;
	public static Role GizmodoAdmin;
	//page
	public static Role HomeEditor;
	public static Role HomeReviewer;
	public static Role HomeWriter;
	
	public static Role AboutEditor;
	public static Role AboutReviewer;
	public static Role AboutWriter;
	
	public static Role ContactEditor;
	public static Role ContactReviewer;
	public static Role ContactWriter;
	
	public static Role PreferencesEditor;
	public static Role PreferencesReviewer;
	public static Role PreferencesWriter;
	
	public static Role ProfileEditor;
	public static Role ProfileReviewer;
	public static Role ProfileWriter;
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
		// TODO Auto-generated method stub
		Connection db = MySQLConnection.getConnection();
		
		alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com",new Date(0), "4321rewq");
		bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com",new Date(0), "5432trew");
		charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com",new Date(0), "6543ytre");
		createPersonExample(db);

		facebook = new Website(123,"Facebook","an online social media and social networking service",new Date(),formatter.parse("2020-02-27"),1234234);
		twitter = new Website(234,"Twitter","an online news and social networking service",new Date(),formatter.parse("2020-02-27"),4321543);
		wikipedia = new Website(345,"Wikipedia","a free online encyclopedia",new Date(),formatter.parse("2020-02-27"),3456654);
		cnn = new Website(456,"CNN","an American basic cable and satellite television news channel",new Date(),formatter.parse("2020-02-27"),6543345);
		cnet = new Website(567,"CNET","an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",new Date(),formatter.parse("2020-02-27"),5433455);
		gizmodo = new Website(678,"Gizmodo","a design, technology, science and science fiction website that also writes articles on politics",new Date(),formatter.parse("2020-02-27"),4322345);
		
		home=new Page(123,"Home","Landing page",new Date(),formatter.parse("2020-02-27"),123434);
		about=new Page(234,"About","Website description",new Date(),formatter.parse("2020-02-27"),234545);
		contact=new Page(345,"Contact","Addresses, phones, and contact info",new Date(),formatter.parse("2020-02-27"),345656);
		preferences=new Page(456,"Preferences","Where users can configure their preferences",new Date(),formatter.parse("2020-02-27"),456776);
		profile=new Page(567,"Profile","Users can configure their personal information",new Date(),formatter.parse("2020-02-27"),567878);
		
		createWebsite(db);
		createPage(db);
		
		//public Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text, int orders,
		//Type type,  String url, boolean shareble, boolean expandable)

		head123 = new Widget(1, "head123", 0, 0, "", "", "Welcome", 0,Type.Heading,"",false,false);
		post234 = new Widget(2, "post234", 0, 0, "", "", "<p>Lorem</p>", 0,Type.Html,"",false,false);
		head345 = new Widget(3, "head345", 0, 0, "", "", "Hi", 1,Type.Heading,"",false,false);
		intro456= new Widget(4, "intro456", 0, 0, "", "", "<h1>Hi</h1>", 2,Type.Html,"",false,false);
		image345= new Widget(5, "image345", 50, 100, "", "", "", 3,Type.Image,"/img/567.png",false,false);
		video456= new Widget(6, "video456", 400, 300, "", "", "", 0,Type.YouTube,"https://youtu.be/h67VX51QXiQ",false,false);
		createWidget(db);
		//role&privilege
		//public Role(int id, String role, int targetId, int developerId)
		facebookOwner = new Role(0, "owner", facebook.getId(), alice.getId());
		facebookEditor = new Role(0, "editor", facebook.getId(), bob.getId());
		facebookAdmin = new Role(0, "admin", facebook.getId(), charlie.getId());

		TwitterOwner = new Role(0, "owner", facebook.getId(), bob.getId());
		TwitterEditor = new Role(0, "editor", facebook.getId(), charlie.getId());
		TwitterAdmin = new Role(0, "admin", facebook.getId(), alice.getId());

		WikipediaOwner = new Role(0, "owner", wikipedia.getId(), charlie.getId());
		WikipediaEditor = new Role(0, "editor", wikipedia.getId(), alice.getId());
		WikipediaAdmin = new Role(0, "admin", wikipedia.getId(), bob.getId());
		
		CNNOwner = new Role(0, "owner", cnn.getId(), alice.getId());
		CNNEditor = new Role(0, "editor", cnn.getId(), bob.getId());
		CNNAdmin = new Role(0, "admin", cnn.getId(), charlie.getId());

		CNETOwner = new Role(0, "owner", cnet.getId(), bob.getId());
		CNETEditor = new Role(0, "editor", cnet.getId(), charlie.getId());
		CNETAdmin = new Role(0, "admin", cnet.getId(), alice.getId());
		
		GizmodoOwner = new Role(0, "owner", gizmodo.getId(), charlie.getId());
		GizmodoEditor = new Role(0, "editor", gizmodo.getId(), alice.getId());
		GizmodoAdmin = new Role(0, "admin", gizmodo.getId(), bob.getId());
		
		//page
		HomeEditor= new Role(0, "owner",home.getId(),alice.getId());
		HomeReviewer= new Role(1, "reviewer",home.getId(),bob.getId());
		HomeWriter= new Role(2, "writer",home.getId(),charlie.getId());

		AboutEditor= new Role(4, "owner",about.getId(),bob.getId());
		AboutReviewer= new Role(5, "reviewer",about.getId(),charlie.getId());
		AboutWriter= new Role(6, "writer",about.getId(),alice.getId());

		ContactEditor= new Role(8, "owner",contact.getId(),charlie.getId());
		ContactReviewer= new Role(9, "reviewer",contact.getId(),alice.getId());
		ContactWriter= new Role(10, "writer",contact.getId(),bob.getId());

		PreferencesEditor= new Role(12, "owner",preferences.getId(),alice.getId());
		PreferencesReviewer= new Role(13, "reviewer",preferences.getId(),bob.getId());
		PreferencesWriter= new Role(14, "writer",preferences.getId(),charlie.getId());

		ProfileEditor= new Role(16, "owner",profile.getId(),bob.getId());
		ProfileReviewer= new Role(17, "reviewer",profile.getId(),charlie.getId());
		ProfileWriter= new Role(18, "writer",profile.getId(),alice.getId());
		createRP(db);
	}
	private static void createPersonExample(Connection db) throws SQLException, ClassNotFoundException {
		DeveloperImpl d1  = new DeveloperImpl(db);
		DeveloperImpl d2 = new DeveloperImpl(db);
		DeveloperImpl d3 = new DeveloperImpl(db);
		
		d1.createDeveloper(alice);
		d2.createDeveloper(bob);
		d3.createDeveloper(charlie);
		
		UserImpl u1 = new UserImpl(db);
		UserImpl u2 = new UserImpl(db);
		User dan = new User(45,"Dan","Martin","dan","dan","dan@martin.com");
		User ed = new User(56,"Ed","Karaz","ed","ed","ed@kar.com");
		u1.createUser(dan);
		u2.createUser(ed);
		
	}
	private static void createWebsite(Connection db) throws SQLException, ClassNotFoundException{
		WebsiteImpl w1 = new WebsiteImpl(db);
		WebsiteImpl w2 = new WebsiteImpl(db);
		WebsiteImpl w3 = new WebsiteImpl(db);
		WebsiteImpl w4 = new WebsiteImpl(db);
		WebsiteImpl w5 = new WebsiteImpl(db);
		WebsiteImpl w6 = new WebsiteImpl(db);
		
		w1.createWebsiteForDeveloper(alice.getId(), facebook);
		w2.createWebsiteForDeveloper(alice.getId(), twitter);
		w3.createWebsiteForDeveloper(bob.getId(), wikipedia);
		w4.createWebsiteForDeveloper(bob.getId(), cnn);
		w5.createWebsiteForDeveloper(charlie.getId(), cnet);
		w6.createWebsiteForDeveloper(charlie.getId(), gizmodo);
		
	}
	
	private static void createPage(Connection db) throws SQLException, ClassNotFoundException{
		PageImpl p1 = new PageImpl(db);
		PageImpl p2 = new PageImpl(db);
		PageImpl p3 = new PageImpl(db);
		PageImpl p4 = new PageImpl(db);
		PageImpl p5 = new PageImpl(db);

		p1.createPageForWebsite(cnet.getId(), home);
		p2.createPageForWebsite(gizmodo.getId(), about);
		p3.createPageForWebsite(wikipedia.getId(), contact);
		p4.createPageForWebsite(cnn.getId(), preferences);
		p5.createPageForWebsite(cnet.getId(), profile);
		
		
	}
	private static void createWidget(Connection db) throws SQLException, ClassNotFoundException{
		WidgetImpl w1 = new WidgetImpl(db);
		WidgetImpl w2 = new WidgetImpl(db);
		WidgetImpl w3 = new WidgetImpl(db);
		WidgetImpl w4 = new WidgetImpl(db);
		WidgetImpl w5 = new WidgetImpl(db);
		
		w1.createWidgetForPage(home.getId(), head123);
		w2.createWidgetForPage(about.getId(), post234);
		w3.createWidgetForPage(contact.getId(), head345);
		w3.createWidgetForPage(contact.getId(), intro456);
		w4.createWidgetForPage(contact.getId(), image345);
		w5.createWidgetForPage(preferences.getId(), video456);
		
	}
	private static void createRP(Connection db) throws SQLException, ClassNotFoundException{
		RoleImpl r = new RoleImpl(db);
		
		r.assignPageRole(HomeEditor.getDeveloperId(), HomeEditor.getTargetId(),Role.roleStringtoId(HomeEditor.getRole()));
		r.assignPageRole(HomeReviewer.getDeveloperId(), HomeReviewer.getTargetId(),Role.roleStringtoId(HomeReviewer.getRole()));
		r.assignPageRole(HomeWriter.getDeveloperId(), HomeWriter.getTargetId(),Role.roleStringtoId(HomeWriter.getRole()));

		r.assignPageRole(AboutEditor.getDeveloperId(), AboutEditor.getTargetId(),Role.roleStringtoId(AboutEditor.getRole()));
		r.assignPageRole(AboutReviewer.getDeveloperId(), AboutReviewer.getTargetId(),Role.roleStringtoId(AboutReviewer.getRole()));
		r.assignPageRole(AboutWriter.getDeveloperId(), AboutWriter.getTargetId(),Role.roleStringtoId(AboutWriter.getRole()));

		r.assignPageRole(ContactEditor.getDeveloperId(), ContactEditor.getTargetId(),Role.roleStringtoId(ContactEditor.getRole()));
		r.assignPageRole(ContactReviewer.getDeveloperId(), ContactReviewer.getTargetId(),Role.roleStringtoId(ContactReviewer.getRole()));
		r.assignPageRole(ContactWriter.getDeveloperId(), ContactWriter.getTargetId(),Role.roleStringtoId(ContactWriter.getRole()));

		r.assignPageRole(PreferencesEditor.getDeveloperId(), PreferencesEditor.getTargetId(),Role.roleStringtoId(PreferencesEditor.getRole()));
		r.assignPageRole(PreferencesReviewer.getDeveloperId(), PreferencesReviewer.getTargetId(),Role.roleStringtoId(PreferencesReviewer.getRole()));
		r.assignPageRole(PreferencesWriter.getDeveloperId(), PreferencesWriter.getTargetId(),Role.roleStringtoId(PreferencesWriter.getRole()));

		r.assignPageRole(ProfileEditor.getDeveloperId(), ProfileEditor.getTargetId(),Role.roleStringtoId(ProfileEditor.getRole()));
		r.assignPageRole(ProfileReviewer.getDeveloperId(), ProfileReviewer.getTargetId(),Role.roleStringtoId(ProfileReviewer.getRole()));
		r.assignPageRole(ProfileWriter.getDeveloperId(), ProfileWriter.getTargetId(),Role.roleStringtoId(ProfileWriter.getRole()));
		
		r.assignWebsiteRole(facebookEditor.getDeveloperId(), facebookEditor.getTargetId(),Role.roleStringtoId(facebookEditor.getRole()));
		r.assignWebsiteRole(facebookOwner.getDeveloperId(), facebookOwner.getTargetId(),Role.roleStringtoId(facebookOwner.getRole()));
		r.assignWebsiteRole(facebookAdmin.getDeveloperId(), facebookAdmin.getTargetId(),Role.roleStringtoId(facebookAdmin.getRole()));

		r.assignWebsiteRole(TwitterEditor.getDeveloperId(), TwitterEditor.getTargetId(),Role.roleStringtoId(TwitterEditor.getRole()));
		r.assignWebsiteRole(TwitterOwner.getDeveloperId(), TwitterOwner.getTargetId(),Role.roleStringtoId(TwitterOwner.getRole()));
		r.assignWebsiteRole(TwitterAdmin.getDeveloperId(), TwitterAdmin.getTargetId(),Role.roleStringtoId(TwitterAdmin.getRole()));

		r.assignWebsiteRole(WikipediaEditor.getDeveloperId(), WikipediaEditor.getTargetId(),Role.roleStringtoId(WikipediaEditor.getRole()));
		r.assignWebsiteRole(WikipediaOwner.getDeveloperId(), WikipediaOwner.getTargetId(),Role.roleStringtoId(WikipediaOwner.getRole()));
		r.assignWebsiteRole(WikipediaAdmin.getDeveloperId(), WikipediaAdmin.getTargetId(),Role.roleStringtoId(WikipediaAdmin.getRole()));

		r.assignWebsiteRole(CNNEditor.getDeveloperId(), CNNEditor.getTargetId(),Role.roleStringtoId(CNNEditor.getRole()));
		r.assignWebsiteRole(CNNOwner.getDeveloperId(), CNNOwner.getTargetId(),Role.roleStringtoId(CNNOwner.getRole()));
		r.assignWebsiteRole(CNNAdmin.getDeveloperId(), CNNAdmin.getTargetId(),Role.roleStringtoId(CNNAdmin.getRole()));

		r.assignWebsiteRole(CNETEditor.getDeveloperId(), CNETEditor.getTargetId(),Role.roleStringtoId(CNETEditor.getRole()));
		r.assignWebsiteRole(CNETOwner.getDeveloperId(), CNETOwner.getTargetId(),Role.roleStringtoId(CNETOwner.getRole()));
		r.assignWebsiteRole(CNETAdmin.getDeveloperId(), CNETAdmin.getTargetId(),Role.roleStringtoId(CNETAdmin.getRole()));

		r.assignWebsiteRole(GizmodoEditor.getDeveloperId(), GizmodoEditor.getTargetId(),Role.roleStringtoId(GizmodoEditor.getRole()));
		r.assignWebsiteRole(GizmodoOwner.getDeveloperId(), GizmodoOwner.getTargetId(),Role.roleStringtoId(GizmodoOwner.getRole()));
		r.assignWebsiteRole(GizmodoAdmin.getDeveloperId(), GizmodoAdmin.getTargetId(),Role.roleStringtoId(GizmodoAdmin.getRole()));

		createWebPrivilege(db,facebookEditor);
		createWebPrivilege(db,facebookOwner);
		createWebPrivilege(db,facebookAdmin);

		createWebPrivilege(db,TwitterEditor);
		createWebPrivilege(db,TwitterOwner);
		createWebPrivilege(db,TwitterAdmin);

		createWebPrivilege(db,WikipediaEditor);
		createWebPrivilege(db,WikipediaOwner);
		createWebPrivilege(db,WikipediaAdmin);

		createWebPrivilege(db,CNNEditor);
		createWebPrivilege(db,CNNOwner);
		createWebPrivilege(db,CNNAdmin);

		createWebPrivilege(db,CNETEditor);
		createWebPrivilege(db,CNETOwner);
		createWebPrivilege(db,CNETAdmin);

		createWebPrivilege(db,GizmodoEditor);
		createWebPrivilege(db,GizmodoOwner);
		createWebPrivilege(db,GizmodoAdmin);
		
		createPagePrivilege(db,HomeEditor);
		createPagePrivilege(db,HomeReviewer);
		createPagePrivilege(db,HomeWriter);

		createPagePrivilege(db,AboutEditor);
		createPagePrivilege(db,AboutReviewer);
		createPagePrivilege(db,AboutWriter);

		createPagePrivilege(db,ContactEditor);
		createPagePrivilege(db,ContactReviewer);
		createPagePrivilege(db,ContactWriter);

		createPagePrivilege(db,PreferencesEditor);
		createPagePrivilege(db,PreferencesReviewer);
		createPagePrivilege(db,PreferencesWriter);

		createPagePrivilege(db,ProfileEditor);
		createPagePrivilege(db,ProfileReviewer);
		createPagePrivilege(db,ProfileWriter);

	}
	private static void createWebPrivilege(Connection db,Role role) throws SQLException, ClassNotFoundException{
		List<Priviledge> pl = Priviledge.getPriviledgeByRole(role);
		PriviledgeImpl p = new PriviledgeImpl(db);
		for(Priviledge i:pl)
			p.assignWebsitePrivilege(i.getDeveloperId(), i.getTargetId(), i.getPriviledge());
	}
	private static void createPagePrivilege(Connection db,Role role) throws SQLException, ClassNotFoundException{
		List<Priviledge> pl = Priviledge.getPriviledgeByRole(role);
		PriviledgeImpl p = new PriviledgeImpl(db);
		for(Priviledge i:pl)
			p.assignPagePriviledge(i.getDeveloperId(), i.getTargetId(), i.getPriviledge());
	}
}
