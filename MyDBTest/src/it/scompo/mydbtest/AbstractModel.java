package it.scompo.mydbtest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * A base implementation of models interface.
 * 
 * @author mscomparin
 * @version 1.0
 */
public abstract class AbstractModel implements Models {
	
	/**
	 * The database associated.
	 */
	protected static DBInterface db;
	
	/**
	 * The database name.
	 */
	public static String name;
	
	/**
	 * Queries of the table.
	 */
	public static Map<String, String> queries;
	
	public static List<Map<String, Object>> fields;
	
	/**
	 * Constructor.
	 */
	public AbstractModel(){
		db=DBInterface.getInstance();
		queries=new LinkedHashMap<>();
		fields = new ArrayList<Map<String,Object>>();
		createTableDefinition();
	}
	
	/**
	 * Creates the table.
	 */
	public void executeCreateTable(String name){
		createTableInDB();
	}

	/**
	 * Table definition must be implemented for each model.
	 * @param name the name of the table
	 */
	public void createTableDefinition(){
		createQueries();
	}
	
	/**
	 * Creates the table in the db.
	 */
	public abstract void createTableInDB();
	
	/**
	 * You must add queries.
	 */
	public abstract void createQueries();
	
}
