package br.com.chapecosolucoes.trafegusweb.server.sqlutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SqlUtil {

	public static Integer getNumRows(ResultSet rs) throws SQLException {
		rs.last();
		Integer numRows = rs.getRow();
		rs.beforeFirst();
		return numRows;
	}
	
	public static Integer getLastInsert(RecordSet rs) throws SQLException {
		Integer idLastInsert = Integer.parseInt(rs.get(0,"id").toString());		
		return idLastInsert;
	}
	
	public static String formatDateDB(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	public static String formatTimeDB(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
		return df.format(date);
	}
	public static String findInSetFormat(RecordSet recordSet, String fieldName){
		String result = "";
		for (int a = 0; a < recordSet.size(); a++) {
			if (result !="") result += ",";
			result += recordSet.get(a, fieldName).toString();
		}	
		return result;		
	}
	
}
