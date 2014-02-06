package it.scompo.mydbtest;

import java.util.LinkedHashMap;
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
	protected DBInterface db;
	
	/**
	 * The table declaration.
	 */
	
	//public Table table;
	
	public String name;
	
	/**
	 * Queries of the table.
	 */
	public Map<String, String> queries;
	
	/**
	 * Constructor.
	 */
	public AbstractModel(){
		db=DBInterface.getInstance();
		queries=new LinkedHashMap<>();
		//table=new Table();
	}
	
	/**
	 * Creates the table.
	 */
	public void executeCreateTable(String name){
		//table.setName(name);
		createTableDefinition(name);
		createTableInDB();
	}

	/**
	 * Executes an insert query to the db.
	 */
	public abstract void executeCreate();
	
	/**
	 * Executes an update query to the db.
	 */
	public abstract void executeUpdate();
	
	/**
	 * Executes a delete query to the db.
	 */
	public abstract void executeDelete();
	
	/**
	 * Executes a query to the db.
	 */
	public abstract void executeQuery();
	
	/**
	 * Create a table.
	 */
	public abstract void createTable();
	
	/**
	 * Table definition must be implemented for each model.
	 * @param name the name of the table
	 */
	public void createTableDefinition(String name){
		createFields();
		createQueries();
	}
	
	/**
	 * Creates the table in the db.
	 */
	public abstract void createTableInDB();
	
	/**
	 * You must create fields.
	 */
	public abstract void createFields();
	
	/**
	 * You must add queries.
	 */
	public abstract void createQueries();
	
}
