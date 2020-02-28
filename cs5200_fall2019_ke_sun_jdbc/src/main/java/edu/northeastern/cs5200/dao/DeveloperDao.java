package edu.northeastern.cs5200.dao;

import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.model.Developer;

public interface DeveloperDao {
	void createDeveloper(Developer developer);
	//inserts properties in developer instance parameter in tables Developer and Person
	List<Developer> findAllDevelopers();
	//returns all joined records from Developer and Person tables as a Collection of Developer instances.
	Developer findDeveloperById(int developerId);
	//returns a joined record from Developer and Person tables whose id field is equal to the developerId parameter
	Developer findDeveloperByUsername(String username);
	//returns a joined record from Developer and Person tables whose username field matches the parameter. 
	Developer findDeveloperByCredentials(String username, String password);
	//returns a joined record from Developer and Person tables whose username and password fields match the parameters
	int updateDeveloper(int developerId, Developer developer);
	//updates records in Developer and Person tables whose id field is equal to developerId parameter. New record field values are set to the values in the developer instance parameter. 
	int deleteDeveloper(int developerId);
	//deletes records from Developer and Person tables whose id field is equal to developerId parameter. 
}
