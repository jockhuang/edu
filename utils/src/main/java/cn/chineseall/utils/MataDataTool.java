package cn.chineseall.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MataDataTool {

	private static Properties properties = new Properties();
	
	static {
		FileInputStream inputStream = null;
		try {
			URL url = MataDataTool.class.getClassLoader().getSystemResource("java-mysql-type-mapping.properties");
			inputStream = new FileInputStream(url.getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> loadTables(String url,String user,String password,String dbName){
		Connection con = null;
		Statement statement = null;
		ResultSet result = null;
		List<String> tableList = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(String.format(url,"information_schema"), user, password);
			statement = con.createStatement();
			result = statement.executeQuery("select TABLE_NAME from TABLES where TABLE_SCHEMA='"+dbName+"'");
			while(result.next()) {
				tableList.add(result.getString("TABLE_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tableList;
	}

	public static List<String[]> loadTableFields(String url,String user,String password,String dbName,String tableName) {
		Connection con = null;
		Statement statement = null;
		ResultSet result = null;
		List<String[]> matadataList = new ArrayList<String[]>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(String.format(url,"information_schema"), user, password);
			statement = con.createStatement();
			result = statement.executeQuery("select COLUMN_NAME,COLUMN_TYPE,COLUMN_KEY,IS_NULLABLE,COLUMN_DEFAULT,EXTRA,COLUMN_COMMENT from COLUMNS where TABLE_SCHEMA='"+dbName+"' and TABLE_NAME='"+tableName+"'");
			while (result.next()) {
				String[] fieldInfoArray = new String[7];
				fieldInfoArray[0]=result.getString("COLUMN_NAME");
				fieldInfoArray[1]=result.getString("COLUMN_TYPE");
				fieldInfoArray[2]=result.getString("COLUMN_KEY");
				fieldInfoArray[3]=result.getString("IS_NULLABLE");
                fieldInfoArray[4]=result.getString("COLUMN_DEFAULT");
                fieldInfoArray[5]=result.getString("EXTRA");
                fieldInfoArray[6]=result.getString("COLUMN_COMMENT");
				matadataList.add(fieldInfoArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return matadataList;
	}
	
	public static String getPropertyName(String s) {
        int i = s.indexOf("_");
        if (i < 0) {
                return s;
        }
        String t = s.substring(0, i);
        return getPropertyName(t + String.valueOf(s.charAt(i + 1)).toUpperCase() + s.substring(i + 2));
	}

    public static String getClassName(String s) {
        int i = s.indexOf("_");
        if (i < 0) {
                s = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
                return s;
        }
        String t = String.valueOf(s.charAt(0)).toUpperCase()
                        + s.substring(1, i);
        return getClassName(t + String.valueOf(s.charAt(i + 1)).toUpperCase() + s.substring(i + 2));
    }
}
