package edu.northeastern.cs5200.model;

public class Widget {
	
	public static enum Type{Heading("Heading"),Html("Html"),YouTube("YouTube"),Image("Image");
		public final String type; 
		private Type(String type) {
			this.type = type; 
		}
		

	};
	public static Type getType(String type) {
		switch (type){
		case "Heading":
			return Type.Heading;
		case "Html":
			return Type.Html;
		case "YouTube":
			return Type.YouTube;
		case "Image":
			return Type.Image;
		}
		return Type.Html;
	}
	private int Id;
	private String name;
	private int width;
	private int heght;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int orders;
	private Type type;



	private String url;
	private boolean shareble;
	private boolean expandable;
	private Page page;
	
	public Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text,
			int orders) {
		super();
		Id = id;
		this.name = name;
		this.width = width;
		this.heght = heght;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.orders = orders;
		this.shareble = false;
		this.expandable = false;
	}

	
	public Widget(int id, String name, int width, int heght, String cssClass, String cssStyle, String text, int orders,
			Type type,  String url, boolean shareble, boolean expandable) {
		super();
		Id = id;
		this.name = name;
		this.width = width;
		this.heght = heght;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.orders = orders;
		this.type = type;



		this.url = url;
		this.shareble = shareble;
		this.expandable = expandable;
	}
	public int getId() {
		return Id;
	}
	public String getName() {
		return name;
	}
	public int getWidth() {
		return width;
	}
	public int getHeght() {
		return heght;
	}
	public String getCssClass() {
		return cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public String getText() {
		return text;
	}
	public int getOrders() {
		return orders;
	}
	public Type getType() {
		return type;
	}



	public String getUrl() {
		return url;
	}
	public boolean isShareble() {
		return shareble;
	}
	public boolean isExpandable() {
		return expandable;
	}
	public Page getPage() {
		return page;
	}
	public void setId(int id) {
		Id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeght(int heght) {
		this.heght = heght;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public void setType(Type type) {
		this.type = type;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	public void setShareble(boolean shareble) {
		this.shareble = shareble;
	}
	public void setExpandable(boolean expandable) {
		this.expandable = expandable;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	@Override
	public String toString() {
		return "Widget [Id=" + Id + ", name=" + name + ", width=" + width + ", heght=" + heght + ", cssClass="
				+ cssClass + ", cssStyle=" + cssStyle + ", text=" + text + ", orders=" + orders + ", type=" + type
			  +  ", url=" + url + ", shareble=" + shareble
				+ ", expandable=" + expandable +  "]";
	}


	public void print() {
		System.out.println(this.toString());
	}
}
/*	Id int,
name varchar(32),
width int,
height int,
cssClass varchar(64),
cssStyle varchar(64),
text varchar(2048),
orders int,
Id_page int,
type varchar(32),
size int,
html varchar(2048),
src varchar(2048),
url varchar(2048),
shareble Boolean,
expandable Boolean,*/