package it.scompo.mydbtest;

/**
 * Interface for Controllers.
 * 
 * @author mscomparin
 * @version 1.0
 */
public interface Controllers {
	
	/**
	 * Creates a new element.
	 * 
	 * @param model The Model to create.
	 */
	public void newElement(Models model);
	
	/**
	 * Save form an existing Model.
	 * 
	 * @param model
	 */
	public void save(Models model);
	
	/**
	 * Delete from an existing Model.
	 * @param model
	 */
	public void delete(Models model);
	
	/**
	 * Reads a Model.
	 */
	public Models read();
}
