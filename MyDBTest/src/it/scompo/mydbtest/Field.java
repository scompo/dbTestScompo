package it.scompo.mydbtest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Implements a Field in a table.
 * 
 * @author mscomparin
 * @version 1.0
 */
public class Field {
	
	/**
	 * The class name.
	 */
	private String name;
	
	/**
	 * The value of the object.
	 */
	private Object value;
	
	/**
	 * The properties.
	 */
	private static Map<String, String> properties;

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Constructor with name.
	 * 
	 * @param name the name.
	 */
	public Field(String name){
		this();
		setName(name);
	}
	
	/**
	 * Empty constructor.
	 */
	public Field() {
		name ="";
		properties= new HashMap<String, String>();
	}
		
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Create a new property for the value.
	 * 
	 * @param name the name of the property.
	 * @param value the value.
	 */
	public void putProperty(String name, String value) {
		properties.put(name, value);
	}
	
	/**
	 * Get a property value.
	 * 
	 * @param propertyName the name of the property.
	 * @return the value.
	 */
	public String getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	/**
	 * Get the sql string from the field.
	 * TODO: Broken probably.
	 * 
	 * @return an sql string from the field.
	 */
	public String getSQL() {
		StringBuilder sqlString= new StringBuilder();
		sqlString.append(this.name+" ");
		for (Entry<String, String> entry : properties.entrySet())
		{
		    sqlString.append(entry.getValue()+" ");
		}
		return sqlString.toString();
	}
	
}
