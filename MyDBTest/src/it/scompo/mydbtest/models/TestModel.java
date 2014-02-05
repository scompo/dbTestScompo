package it.scompo.mydbtest.models;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import it.scompo.mydbtest.AbstractModel;
import it.scompo.mydbtest.Field;
import it.scompo.mydbtest.Models;

/**
 * @author mscomparin
 *
 */
public class TestModel extends AbstractModel {
	
	//Fields
	Field id = new Field("id");
	Field first = new Field("first");
	Field second = new Field("second");
	
	//Queries.
	
	
	/**
	 * Constructor.
	 */
	public TestModel(String name) {
		super(name);
	}
	
	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.Models#create()
	 */
	@Override
	public void create() {
		// TODO Auto-generated method stub

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

	/* (non-Javadoc)
	 * @see it.scompo.mydbtest.Models#read()
	 */
	@Override
	public Models read() {
		// TODO Auto-generated method stub
		return null;
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
		Field id = new Field("id");
		Field first = new Field("first");
		Field second = new Field("second");
		id.putProperty("type", "serial primary key not null");
		first.putProperty("type", "text not null");
		second.putProperty("type", "text not null");
		table.putField(id);
		table.setId(id);
		table.putField(first);
		table.putField(second);
	}

	@Override
	public void createQueries() {
		table.putQuery("create_table", createQueryCreateTable());
		table.putQuery("insert", createQueryInsert());
		table.putQuery("select","SELECT * FROM "+table.getName()+";");
		table.putQuery("delete",createQueryDelete());
	}
	

	private String createQueryDelete() {
		return "DELETE FROM "+table.getName()+
				" WHERE "+table.getId().getName()+" = ?;";
	}

	/**
	 * Create the insert query.
	 * 
	 * @return the insert query.
	 */
	private String createQueryInsert() {
		StringBuilder queryInsert = new StringBuilder();
		queryInsert.append("INSERT INTO " + table.getName()+ "(");
		StringBuilder values = new StringBuilder();
		Map<String, Field> fields = table.getFields();
		Iterator<Map.Entry<String, Field>> iterator = fields.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String,Field> fieldEntry = iterator.next();
			if(fieldEntry.getValue()==table.getId()){
				fieldEntry = iterator.next();
			}
			queryInsert.append(fieldEntry.getValue().getName());
			values.append("?");
			if(iterator.hasNext()){
				queryInsert.append(", ");
				values.append(", ");
			}
		}
		queryInsert.append(") VALUES (");
		queryInsert.append(values);
		queryInsert.append(");");
		return queryInsert.toString();
	}

	/**
	 * Create table query.
	 * 
	 * @return Create table query.
	 */
	private String createQueryCreateTable() {
		StringBuilder queryCreateTable = new StringBuilder();
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
		return queryCreateTable.toString();
	}

	@Override
	public void executeCreateTable() {
		db.createTable(table.getQuery("create_table"));
	}



}
