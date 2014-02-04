package it.scompo.mydbtest;

import java.util.HashMap;

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
	DBInterface db;
	
	/**
	 * Queries for the model.
	 */
	static HashMap<String, String> queries;
	
	/**
	 * Executes an insert query to the db.
	 */
	abstract void executeCreate();
	
	/**
	 * Executes an update query to the db.
	 */
	abstract void executeUpdate();
	
	/**
	 * Executes a delete query to the db.
	 */
	abstract void executeDelete();
	
	/**
	 * Executes a query to the db.
	 */
	abstract void executeQuery();
	
		
}
