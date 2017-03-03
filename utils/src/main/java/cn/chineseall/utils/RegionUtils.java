package cn.chineseall.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionUtils {
    
    public static void main(String[] arg) {
        Connection con,con2,con3;
        try {
            con = getConnection("125.39.194.44", "3306", "bookchina2", "bcbuser_book", "B{^%DFkiw22");
            con2 = getConnection("125.39.194.44", "3306", "bookchina3_develop", "bcbuser_book", "B{^%DFkiw22");
            //更新机构地域
            PreparedStatement pt1 = con.prepareStatement("update org set region_id=? where id=?");
            //按full_name查询region
            PreparedStatement pt2 = con2.prepareStatement("select * from region where name=?");
            //查找所有老的机构信息
            PreparedStatement pt3 = con.prepareStatement("select * from org");
            ResultSet rs3 = pt3.executeQuery();
            while(rs3.next()){
                Long orgId = rs3.getLong("id");
                String province = rs3.getString("province");
                String county = rs3.getString("county");
                String city = rs3.getString("city");
                province = (province == null?"":province.trim());
                county = (county == null && !"".equals(county.trim())?"":county.trim());
                city = (city == null && !"".equals(city.trim())?"":city.trim());
                
                //查找新的regionId
                if(!"".equals(city)){
                    pt2.setString(1, city);
                }else if (!"".equals(county)){
                    pt2.setString(1, county);
                }else if(!"".equals(province)){
                    pt2.setString(1, province);
                }
                ResultSet rs = pt2.executeQuery();
                if(rs.next()){
                    pt1.setInt(1, rs.getInt("id"));
                    pt1.setLong(2, orgId);
                    pt1.execute();
                }
            }
            pt2.close();
            rs3.close();
            pt1.close();
            pt3.close();
            con2.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection(String dbPath, String port, String db, String userName, String password) throws SQLException, java.lang.ClassNotFoundException {
        
        String url = "jdbc:mysql://" + dbPath + ":" + port + "/" + db;

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, userName, password);

        return con;
    }

}
