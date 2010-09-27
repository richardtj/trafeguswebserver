package br.com.chapecosolucoes.trafegusweb.server.sqlutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings({ "unchecked" })
public class RecordSet extends ArrayList {

	private static final long serialVersionUID = 1L;
	
	public RecordSet() {
		super();
	}

	public boolean add(String FieldName, Object FieldValue) {
		HashMap hm = new HashMap();
		hm.put(FieldName, FieldValue);
		return add(hm);
	}
	
	public void add(Integer row,String FieldName, Object FieldValue) {
		HashMap hm = null;
		if ((size() == 0) || (row < 0) || (row >= size()))
			hm = getRow();
		else
			hm = getRow(row);
		
		hm.put(FieldName, FieldValue);
		if ((row >= 0)&&(row < size()))
			remove(row.intValue());
		add(row, hm);
	}
	
	public boolean addRow(ResultSet resultSet) throws SQLException {
	    ResultSetMetaData metaData = resultSet.getMetaData();
	    int cols = metaData.getColumnCount();
	     
		HashMap row = new HashMap(cols,1);
	    for (int i=1; i<=cols; i++) {
	    	row.put(metaData.getColumnLabel(i),
	    	resultSet.getObject(i));
	    }
	    return add(row);
	}

	public void addMultiple(ResultSet resultSet) throws SQLException {
	     ResultSetMetaData metaData = resultSet.getMetaData();
	     int cols = metaData.getColumnCount();
	     while (resultSet.next()) {
	         HashMap row = new HashMap(cols,1);
	         for (int i=1; i<=cols ; i++) {
	             row.put(metaData.getColumnLabel(i),
	                 resultSet.getObject(i));
	         }
	         add(row);
	     }
	}

	public Object get(int index, String FieldName) {
		Object obj = super.get(index);
		if (obj instanceof HashMap) {
			return ((HashMap)obj).get(FieldName);
		}
		return get(index);
	}
	
	public HashMap getRow(Integer row){
		HashMap result = new HashMap();
		if (get(row) instanceof HashMap) {
			result =(HashMap) get(row);
		}
		return result;
	}

	public HashMap getRow(ResultSet resultSet) throws SQLException {
	    ResultSetMetaData metaData = resultSet.getMetaData();
	    int cols = metaData.getColumnCount();
		HashMap row = new HashMap(cols,1);
	    for (int i=1; i<=cols; i++) {
	    	row.put(metaData.getColumnLabel(i),
	    	resultSet.getObject(i));
	    }
	    return row;
	}	

	public HashMap getRow() {
		HashMap<String,Object> row = new HashMap();
		return row;
	}
	
}
