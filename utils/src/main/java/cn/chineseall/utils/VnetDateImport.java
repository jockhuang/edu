package cn.chineseall.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VnetDateImport {
    
    public static void importBookPackage() throws FileNotFoundException{
        String path = "/home/huqilong/桌面/家长亲子和bookchina3匹配结果.xlsx";
        List<Object[]> dataList = ExcelUtil.loadData(new FileInputStream(new File(path)), 0);
        StringBuffer sqlBuffer = new StringBuffer();
        try {
            List<String> list = new ArrayList<String>();
            int j = 0;
            
            for(int i =0; i<dataList.size(); i++){
                Object[] data = dataList.get(i);
                if(data[0] == null || "".equals(data[0])){
                    continue;
                }
                String  bookId = new BigDecimal(data[0].toString().trim()).longValue()+"";
                System.out.println("insert into common_app_book(app_id,book_id,status,app_name) values (1,"+bookId+",0,\"江苏电信\");\n\r");
                j++;
            }
            System.out.println(j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(String dbPath, String port, String db, String userName, String password)
            throws SQLException, java.lang.ClassNotFoundException {
        String url = "jdbc:mysql://" + dbPath + ":" + port + "/" + db;

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, userName, password);

        return con;
    }
    
    public static void main(String args[]) throws FileNotFoundException{
        importBookPackage();
    }
}
