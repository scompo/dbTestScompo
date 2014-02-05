package it.scompo.mydbtest;


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
	
	protected static Table table;
	
	
	/**
	 * Constructor.
	 */
	public AbstractModel(String name){
		db=DBInterface.getInstance();
		table=new Table(name);
		createTableDefinition(name);
		executeCreateTable();
	}
	
	/**
	 * Creates the table.
	 */
	public abstract void executeCreateTable();

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
	//public abstract void createTable();
	
	/**
	 * Table definition must be implemented for each model.
	 * @param name the name of the table
	 */
	public void createTableDefinition(String name){
		createFields();
		createQueries();
	}
	
	/**
	 * You must create fields.
	 */
	public abstract void createFields();
	
	/**
	 * You must add queries.
	 */
	public abstract void createQueries();
	
}
