package it.scompo.mydbtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.*;

/**
 * Used to access the database.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class DBInterface {
	
	private static final String DB_PROPERTIES_NAME = "DBInfo.properties";
	
	private static DBInterface instance = null;
	private static Properties props;
	
	/**
	 * Returns the only instance available.
	 * 
	 * @return the instance of the class.
	 */
	public static DBInterface getInstance(){
		if (instance == null){
			instance = new DBInterface();
			return instance;
		}else{
			return instance;
		}
	}
	
	/**
	 * private constructor
	 */
	private DBInterface(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void getProperties(){
		try {
			props=loadDBProperties(DB_PROPERTIES_NAME);
			System.err.println(props);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the data from the DB.
	 * 
	 * @param model the type of model to get data from.
	 * @return The data.
	 */
	public Models getDataFromDB(Models model){
		return model.read();
	}
	
	/**
	 * Save model to DB.
	 * 
	 * @param model the data to save.
	 */
	public void saveDataInDB(Models model){
		model.update();
	}
	
	/**
	 * Create a model into the DB.
	 * 
	 * @param model the model to create.
	 */
	public void createDataInDB(Models model){
		model.create();
	}
	
	/**
	 * Delete a model form DB.
	 * 
	 * @param model the model to delete.
	 */
	public void deleteDataFromDB(Models model){
		model.delete();
	}
	
	/**
	 * Load the properties file into the properties
	 * @param dbPropertiesName
	 * @throws IOException if file not found.
	 */
	private Properties loadDBProperties(String dbPropertiesName) throws IOException {
		Properties temp= new Properties();
		InputStream is= getClass().getClassLoader().getResourceAsStream(dbPropertiesName);
		temp.load(is);
		return temp;
	}
}
