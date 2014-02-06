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
	
	//Queries.
		
	/**
	 * Constructor.
	 */
	public TestModel() {
		super();
		name = "test";
		//table.setName(name);
	}
	
	public TestModel(int id,String first,String second){
		this();
		this.id=id;
		this.first=first;
		this.second=second;
	}
	
	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.Models#create()
	 */
	@Override
	public void create() {
		/*StringBuilder values = new StringBuilder();
		Map<String, Field> fields = table.getFields();
		Iterator<Map.Entry<String, Field>> iterator = fields.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String,Field> fieldEntry = iterator.next();
			if(fieldEntry.getValue()==table.getId()){
				fieldEntry = iterator.next();
			}
			values.append(fieldEntry.getValue().getValue());
			if(iterator.hasNext()){
				values.append(", ");
			}
		}
		values.append(");");*/
		db.executeUpdate(queries.get("insert")+" \'"+first+"\', \'"+second+"\');");
	}

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.Models#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.Models#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Models getModel(Object key) {
		Integer tempId;
		String tempFirst,tempSecond;
		TestModel temp=null;
		List<Map<String, Object>> listTemp= db.executeQuery(this,
				queries.get("select_single")+key+";");
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
	public List<Models> readAll() {
		List<Models> all = new ArrayList<Models>();
		Integer tempId;
		String tempFirst,tempSecond;
		TestModel temp;
		List<Map<String, Object>> listTemp= db.executeQuery(this,queries.get("select_all"));
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

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.AbstractModel#executeCreate()
	 */
	@Override
	public void executeCreate() {
		
	}
	
	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.AbstractModel#executeUpdate()
	 */
	@Override
	public void executeUpdate() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.AbstractModel#executeDelete()
	 */
	@Override
	public void executeDelete() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.AbstractModel#executeQuery()
	 */
	@Override
	public void executeQuery() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void createFields() {
		/*Field id = new Field("id");
		Field first = new Field("first");
		Field second = new Field("second");
		id.putProperty("type", "serial");
		first.putProperty("type", "text");
		second.putProperty("type", "text");
		table.putField(id);
		table.setId(id);
		table.putField(first);
		table.putField(second);*/
	}

	@Override
	public void createQueries() {
		queries.put("create_table", createQueryCreateTable());
		queries.put("insert", createQueryInsert());
		queries.put("select_all","SELECT * FROM "+name+";");
		queries.put("select_single", "SELECT * FROM "+name+" WHERE id=");
		queries.put("delete",createQueryDelete());
	}
	

	private String createQueryDelete() {
		return "DELETE FROM "+name+
				" WHERE "+id+" = ?;";
	}

	/**
	 * Create the insert query.
	 * 
	 * @return the insert query.
	 */
	private String createQueryInsert() {
		return "INSERT INTO " + name+ 
				"(first,second) VALUES(";
		/*StringBuilder queryInsert = new StringBuilder();
		queryInsert.append("INSERT INTO " + table.getName()+ "(");
		//StringBuilder values = new StringBuilder();
		Map<String, Field> fields = table.getFields();
		Iterator<Map.Entry<String, Field>> iterator = fields.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String,Field> fieldEntry = iterator.next();
			if(fieldEntry.getValue()==table.getId()){
				fieldEntry = iterator.next();
			}
			queryInsert.append(fieldEntry.getValue().getName());
			//values.append("?");
			if(iterator.hasNext()){
				queryInsert.append(", ");
				//values.append(", ");
			}
		}
		queryInsert.append(") VALUES (");
		//queryInsert.append(values);
		//queryInsert.append(");");
		return queryInsert.toString();*/
	}

	/**
	 * Create table query.
	 * 
	 * @return Create table query.
	 */
	private String createQueryCreateTable() {
		return "CREATE TABLE " + name+ 
				" (id serial, first text, second text);";
		/*StringBuilder queryCreateTable = new StringBuilder();
		queryCreateTable.append("CREATE TABLE " + table.getName()+ " (");
		Map<String, Field> fields = table.getFields();
		Iterator<Map.Entry<String, Field>> iterator = fields.entrySet().iterator();
		while (iterator.hasNext()) {
			queryCreateTable.append(iterator.next().getValue().getSQL());
			if(iterator.hasNext()){
				queryCreateTable.append(", ");
			}
		}
		queryCreateTable.append(");");
		return queryCreateTable.toString();*/
	}

	@Override
	public void createTableInDB() {
		createTableDefinition("name");
		db.createTable(queries.get("create_table"));
		
	}


	
	
	
	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * To string representation of the model. 
	 */
	public String toString(){
		return name +" ["+id + "," + first + "," + second+"]";
	}



}
