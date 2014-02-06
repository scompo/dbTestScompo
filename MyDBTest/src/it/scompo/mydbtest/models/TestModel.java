package it.scompo.mydbtest.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.scompo.mydbtest.AbstractModel;
import it.scompo.mydbtest.Models;

/**
 * @author mscomparin
 *
 */
public class TestModel extends AbstractModel {
	
	//Fields
	public Integer id;
	public String first;
	public String second;

	/**
	 * Constructor.
	 */
	public TestModel() {
		super();
		name = "test";
	}
	
	public TestModel(int id,String first,String second){
		this();
		this.id=id;
		this.first=first;
		this.second=second;
	}
	
	/**
	 * Create a new model.
	 */
	@Override
	public synchronized void create() {
		db.executeUpdate(queries.get("insert")+" \'"+first+"\', \'"+second+"\');");
	}
	
	/**
	* delete this model
	*/
	@Override
	public synchronized void delete() {
		db.executeUpdate(queries.get("delete")+id+";");
	}

	/**
	 * update the model
	 */
	@Override
	public synchronized void update() {
		db.executeUpdate(queries.get("update")+"first=\'"+first+"\' WHERE id="+id+";");
		db.executeUpdate(queries.get("update")+"second=\'"+second+"\' WHERE id="+id+";");
	}
	
	/**
	 * Get a model.
	 */
	public static synchronized Models getModel(Object key) {
		Integer tempId;
		String tempFirst,tempSecond;
		TestModel temp=null;
		List<Map<String, Object>> listTemp= db.executeQuery(queries.get("select_single")+key+";");
		for(Map<String, Object> data : listTemp){
			tempId = (Integer)data.get("id");
			tempFirst = (String)data.get("first");
			tempSecond = (String)data.get("second");
			temp= new TestModel(tempId,tempFirst,tempSecond);
		}
		return temp;
	}

	/**
	 * Read all the data.
	 * 
	 * @return a list of all the models.
	 */
	public static synchronized List<Models> readAll() {
		List<Models> all = new ArrayList<Models>();
		Integer tempId;
		String tempFirst,tempSecond;
		TestModel temp;
		List<Map<String, Object>> listTemp= db.executeQuery(queries.get("select_all"));
			for(Map<String, Object> data : listTemp){
				tempId = (Integer)data.get("id");
				tempFirst = (String)data.get("first");
				tempSecond = (String)data.get("second");
				temp= new TestModel(tempId,tempFirst,tempSecond);
				all.add(temp);
		}
		System.out.println(all);
		return all;
	}

	@Override
	public void createQueries() {
		queries.put("create_table", createQueryCreateTable());
		queries.put("insert", createQueryInsert());
		queries.put("select_all","SELECT * FROM "+name+";");
		queries.put("select_single", "SELECT * FROM "+name+" WHERE id=");
		queries.put("update", "UPDATE "+name+" SET ");
		queries.put("delete",createQueryDelete());
	}
	

	private String createQueryDelete() {
		return "DELETE FROM "+name+" WHERE id=";
	}

	/**
	 * Create the insert query.
	 * 
	 * @return the insert query.
	 */
	private String createQueryInsert() {
		return "INSERT INTO " + name+ 
				"(first,second) VALUES(";
	}

	/**
	 * Create table query.
	 * 
	 * @return Create table query.
	 */
	private String createQueryCreateTable() {
		return "CREATE TABLE " + name+ 
				" (id serial, first text, second text);";
	}

	@Override
	public void createTableInDB() {
		//createTableDefinition();
		db.createTable(queries.get("create_table"));
	}

	/**
	 * To string representation of the model. 
	 */
	public String toString(){
		return name +" ["+id + "," + first + "," + second+"]";
	}
}
