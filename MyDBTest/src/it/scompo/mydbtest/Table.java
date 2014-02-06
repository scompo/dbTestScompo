package it.scompo.mydbtest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implements a table in the DB.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class Table {

	/**
	 * Name of the table.
	 */
	private String name;
	
	/**
	 * Id of the table.
	 */
	private Field id;
	
	/**
	 * Table names and type for the model, must be defined.
	 */
	//private Map<String, Field> fields;

	/**
	 * Queries of the table.
	 */
	private Map<String, String> queries;
	
	
	/**
	 * @return the id
	 */
	public Field getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Field idField) {
		id = idField;
	}
	
	public Table(String tableName){
		this();
		name=tableName;
	}
	
	/**
	 * Constructor.
	 */
	public Table(){
		queries=new LinkedHashMap<String,String>();
		//fields = new LinkedHashMap<String, Field>();
	}
			
	/**
	 * @return The name of the table.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name The name of the table to set.
	 */
	public void setName(String tableName) {
		name = tableName;
	}
	
	/**
	 * Put a query
	 */
	public void putQuery(String name, String query){
		queries.put(name, query);
	}
	
	/**
	 * Get a query
	 */
	public String getQuery(String name) {
		return queries.get(name);
	}
	
	/**
	 * Insert a new field.
	 * 
	 * @param field the field to insert.
	 *
	public void putField(Field field) {
		fields.put(field.getName(),field);
	}*/
	
	/**
	 * Get a field.
	 * 
	 * @param name the name of the field.
	 * @return the field.
	 *
	public Field getField(String name) {
		return fields.get(name);
	}
	
	public Map<String, Field> getFields() {
		return fields;
	}*/
}
