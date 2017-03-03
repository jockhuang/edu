package cn.chineseall.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class ModelUtils {
    public static void main(String[] arg) {

        String classPath = "com.shop.manage.model";// xml中clas的路径
        String path = "/home/huqilong/Desktop/model/";// 存放XML文件的路径
        Connection con;
        try {
            con = getConnection("db.chineseall.cn", "3306", "bookchina3_develop", "bcbuser_book", "B{^%DFkiw22");
            /**
             * 所有表
             */
            String table = getTables(con);
            String[] temp = null;
            temp = table.split(",");
            for (int i = 0; i < temp.length; i++) {
                HashMap fieldMap = getField(temp[i], con);
                genModel(fieldMap, temp[i], classPath, path);
                genXML(fieldMap, temp[i], classPath, path);
            }
            /**
             * 单表
             */
            // String tableName = "search_stuff";
            // HashMap fieldMap = getField(tableName,con);
            // genModel(fieldMap, tableName, classPath, path);
            // genXML(fieldMap, tableName, classPath, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // moveData2();
    }

    private static void genModel(HashMap fieldMap, String tableName, String classPath, String path) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.musketeer.fur.model;\r\n");
        sb.append("public class ").append(getClassName(tableName)).append(" extends BaseEntity{\r\n");
        Iterator keys = fieldMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            sb.append("private ").append(fieldMap.get(key)).append(" ").append(getBeanName(key.toLowerCase()))
                    .append(";\r\n");
        }
        sb.append("}");
        System.out.println(sb.toString());
        File distFile = new File(path, getClassName(tableName) + ".java");
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
            distFile.createNewFile();
        }
        FileUtil.copy(sb.toString(), new FileOutputStream(distFile));
    }

    private static void genXML(HashMap fieldMap, String tableName, String classPath, String path) throws Exception {
        String beanName = getClassName(tableName);
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8' ?>\r\n")
                .append("<!DOCTYPE sqlMap PUBLIC '-//iBATIS.com//DTD SQL Map 2.0//EN' 'http://ibatis.apache.org/dtd/sql-map-2.dtd'>\r\n")
                .append(String.format("<sqlMap namespace=\"%s\">\r\n", beanName))
                .append(String.format("\t<typeAlias alias=\"%s\" type=\"%s\" />\r\n", beanName, classPath + "."
                        + beanName)).append(String.format("\t<resultMap id=\"result\" class=\"%s\">\r\n", beanName));

        Iterator keys = fieldMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            sb.append(String.format("\t<result property=\"%s\" column=\"%s\" />\r\n", getBeanName(key.toLowerCase()),
                    key));
        }

        sb.append("\t</resultMap>\r\n");

        // inser语句
        sb.append(String.format("\t<insert id=\"add%s\" parameterClass=\"%s\">\r\n", beanName, beanName)).append(
                String.format("\tINSERT INTO %s(\r\n\t", tableName));
        keys = fieldMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            sb.append(key).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\r\n\t)values(\r\n\t");
        keys = fieldMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            sb.append("#").append(getBeanName(key.toLowerCase())).append("#,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\r\n\t)\r\n");
        keys = fieldMap.keySet().iterator();
        String key = keys.next().toString();
        sb.append(String.format("\t<selectKey resultClass=\"int\" keyProperty=\"%s\">\r\n",
                getBeanName(key.toLowerCase())));
        sb.append(String.format("\t<![CDATA[SELECT LAST_INSERT_ID() AS %s ]]>\r\n", key));
        sb.append("\t</selectKey>\r\n");
        sb.append("\t</insert>\r\n");

        // update语句
        sb.append(String.format("\t<update id=\"update%s\" parameterClass=\"%s\">\r\n", beanName, beanName))
                .append(String.format("\tupdate %s\r\n", tableName)).append("\t<dynamic prepend=\"set\">\r\n");
        keys = fieldMap.keySet().iterator();
        while (keys.hasNext()) {
            key = keys.next().toString();
            sb.append(String.format("\t<isNotNull prepend=\",\" property=\"%s\">%s=#%s#</isNotNull>\r\n",
                    getBeanName(key.toLowerCase()), key, getBeanName(key.toLowerCase())));
        }
        sb.append("\t</dynamic>\r\n");
        keys = fieldMap.keySet().iterator();
        key = keys.next().toString();
        sb.append(String.format("\twhere %s=#%s#\r\n", key, getBeanName(key.toLowerCase())));
        sb.append("\t</update>\r\n");

        sb.append("</sqlMap>\r\n");
        System.out.println(sb.toString());
        File distFile = new File(path, getClassName(tableName) + ".xml");
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
            distFile.createNewFile();
        }
        FileUtil.copy(sb.toString(), new FileOutputStream(distFile));
    }

    /*
     * 字段名称去下划线并大写下划线后的第一个字母
     */
    private static String getBeanName(String s) {
        int i = s.indexOf("_");
        if (i < 0) {
            return s;
        }
        String t = s.substring(0, i);
        return getBeanName(t + String.valueOf(s.charAt(i + 1)).toUpperCase() + s.substring(i + 2));
    }

    /*
     * 表名，第一个字母大写，去下划线并大写下划线后的第一个字母
     */
    private static String getClassName(String s) {
        int i = s.indexOf("_");
        if (i < 0) {
            s = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
            return s;
        }
        String t = String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1, i);
        return getClassName(t + String.valueOf(s.charAt(i + 1)).toUpperCase() + s.substring(i + 2));
    }

    /*
     * 获得所有表名
     */
    private static String getTables(Connection con) {
        ResultSet result;
        String str = "";
        try {
            Statement sql = con.createStatement();
            result = sql.executeQuery("show   tables; ");
            while (result.next()) {
                str += result.getString(1) + ",";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }

    /*
     * 获得所有字段名和类型
     */
    private static HashMap getField(String tableName, Connection con) {
        LinkedHashMap fieldsMap = new LinkedHashMap();
        ResultSet result;
        try {
            Statement sql = con.createStatement();
            String query = "desc " + tableName;
            result = sql.executeQuery(query);
            while (result.next()) {
                fieldsMap.put(result.getString("Field"), getFieldType(result.getString("Type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fieldsMap;
    }

    private static String getFieldType(String typeInfo) {
        if (typeInfo.toLowerCase().startsWith("int")) {
            return "Integer";
        }
        if (typeInfo.toLowerCase().startsWith("varchar")) {
            return "String";
        }
        if (typeInfo.toLowerCase().startsWith("datetime")) {
            return "Date";
        }
        if (typeInfo.toLowerCase().startsWith("text")) {
            return "String";
        }
        if (typeInfo.toLowerCase().startsWith("mediumtext")) {
            return "String";
        }
        return "String";
    }

    /*
     * 连接数据库
     */
    public static Connection getConnection(String dbPath, String port, String db, String userName, String password)
            throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:mysql://" + dbPath + ":" + port + "/" + db;

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, userName, password);

        return con;
    }

    public static void moveData2() {
        Connection con = null;
        Connection con2 = null;
        try {
            con = getConnection("10.0.10.4", "3306", "cms", "root", "wait4you");
            PreparedStatement pt = con.prepareStatement("select * from channel where status = 0");
            ResultSet rs = pt.executeQuery();

            con2 = getConnection("zhaojun", "3306", "cms", "root", "wait4you");
            while (rs.next()) {
                PreparedStatement pt2 = con2.prepareStatement("INSERT INTO channel("
                        + "channel_id,channel_template_id,channel_name,data_type,css,"
                        + "file_name,domain_type,zt_category,introduce,zt_img,parent_id,deep,"
                        + "left_val,right_val,status)" + "values(" + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pt2.setString(1, rs.getString("channel_id"));
                pt2.setInt(2, 1);
                pt2.setString(3, rs.getString("channel_name"));
                pt2.setInt(4, rs.getInt("data_type"));
                pt2.setString(5, rs.getString("css"));
                pt2.setString(6, rs.getString("file_name"));
                pt2.setInt(7, rs.getInt("domain_type"));
                pt2.setString(8, "1");
                pt2.setString(9, "1");
                pt2.setString(10, "1");
                pt2.setInt(11, rs.getInt("parent_id"));
                pt2.setInt(12, rs.getInt("deep"));
                pt2.setInt(13, rs.getInt("left_val"));
                pt2.setInt(14, rs.getInt("right_val"));
                pt2.setInt(15, rs.getInt("status"));
                pt2.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
