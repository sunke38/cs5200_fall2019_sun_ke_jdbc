package edu.northeastern.cs5200.dao;
import java.util.List;

import edu.northeastern.cs5200.model.*;
public interface WidgetDao {
	void createWidgetForPage(int pageId, Widget widget);
	List<Widget> findAllWidgets();
	Widget findWidgetById(int widgetId);
	List<Widget> findWidgetsForPage(int pageId);
	int updateWidget(int widgetId, Widget widget);
	int deleteWidget(int widgetId);

}
