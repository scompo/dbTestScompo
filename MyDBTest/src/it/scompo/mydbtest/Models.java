package it.scompo.mydbtest;

/**
 * Implements the interface of the various models.
 * 
 * @author mscomparin
 * @version 1.0
 */
public interface Models {
	
	/**
	 * Creates a new db entry from model.
	 */
	void create();
	
	/**
	 * Delete a db entry from model.
	 */
	void delete();
	
	/**
	 * Update an existing db entry from model.
	 */
	void update();
	
	/**
	 * Reads the data from the db.
	 * @return 
	 */
	Models getModel(Object key);
	
}
