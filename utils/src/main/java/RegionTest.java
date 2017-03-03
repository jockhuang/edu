import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cn.chineseall.utils.JsonUtil;

public class RegionTest {
    
    /**
     * 从js里读取地域信息写入region表
     * 
     * @param args
     */
    public static void main(String args[]){
        String regionJsonStr = null;
        try {
            InputStream inputStream = RegionTest.class.getClassLoader().getResourceAsStream("region");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            regionJsonStr = br.readLine();
            HashMap map = JsonUtil.fromJsonToObject(regionJsonStr, HashMap.class);
            Iterator keyIterator = map.keySet().iterator();
            HashMap<String, HashMap<String, ArrayList>> allRegionMap = new HashMap<String, HashMap<String, ArrayList>>();
            while (keyIterator.hasNext()){
                String key = keyIterator.next().toString();
                if(key.trim()=="" || map.get(key)==null || "".equals(map.get(key).toString().trim())){
                    continue;
                }else{
                    HashMap<String, ArrayList> regionMap = new HashMap<String, ArrayList>();
                    HashMap map2 = JsonUtil.jsonToObject(regionJsonStr, key, HashMap.class);
                    String jsonStr = JsonUtil.toJson(map2);
                    Iterator keyIterator2 = map2.keySet().iterator();
                    while (keyIterator2.hasNext()){
                          String secondkey = keyIterator2.next().toString();
                          if(secondkey.trim()==""|| map2.get(secondkey)==null || "".equals(map2.get(secondkey).toString().trim())){
                              continue;
                          }else{
                              ArrayList regionList = JsonUtil.jsonToObject(jsonStr,secondkey, ArrayList.class);
                              regionMap.put(secondkey, regionList);
                          }
                     }
                    allRegionMap.put(key, regionMap);
                }
            }
            
            //所有地域信息
            Iterator iterator = allRegionMap.keySet().iterator();
            Integer site = 1;
            //添加省
            while(iterator.hasNext()){
                String key = iterator.next().toString();
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/region?useUnicode=true&characterEncoding=UTF-8","root" ,"just4you" );
                Statement stat = conn.createStatement();
                String sqlstr = "insert into region_bak(name,region_type,parent_id,code,full_name,state) values ('"+key+"',1,0,'"+generateCode(site, null, 1)+"','"+key+"',1)";
                stat.executeUpdate(sqlstr);
                site++;
                stat.close();
                conn.close();
                
            }
            
          //添加市
            iterator = allRegionMap.keySet().iterator();
            while(iterator.hasNext()){
            	String key = iterator.next().toString();
            	Class.forName("com.mysql.jdbc.Driver");
                Connection conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/region?useUnicode=true&characterEncoding=UTF-8","root" ,"just4you" );
                Statement stat = conn.createStatement();
                String sqlstr = "select id,code from region_bak where name='"+key+"'";
                ResultSet rs = stat.executeQuery(sqlstr);
                if(rs.next()){
                	site = 1;
                	int id = rs.getInt("id");
                	String parentCode = rs.getString("code");
                	Iterator secondIterator = allRegionMap.get(key).keySet().iterator();
                	while(secondIterator.hasNext()){
                        String secondKey = secondIterator.next().toString();
                        sqlstr = "insert into region_bak(name,region_type,parent_id,code,full_name,state) values ('"+secondKey+"',2,"+id+",'"+generateCode(site, parentCode, 2)+"','"+key+"=>"+secondKey+"',1)";
                        stat.executeUpdate(sqlstr);
                        site++;
                	}
                }
                rs.close();
                stat.close();
                conn.close();
            }
            
            //添加县
            iterator = allRegionMap.keySet().iterator();
            while(iterator.hasNext()){
            	String key = iterator.next().toString();
            	Iterator secondIterator = allRegionMap.get(key).keySet().iterator();
            	Class.forName("com.mysql.jdbc.Driver");
            	Connection conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/region?useUnicode=true&characterEncoding=UTF-8","root" ,"just4you" );
            	Statement stat = conn.createStatement();
            	while(secondIterator.hasNext()){
            		String secondKey = secondIterator.next().toString();
            		String sqlstr = "select id from region_bak where name='"+key+"'";
	                ResultSet rrs = stat.executeQuery(sqlstr);
	                if(rrs.next()){
	                	int parentId = rrs.getInt("id");
	                	sqlstr = "select id,code from region_bak where name='"+secondKey+"' and parent_id="+parentId;
	                	ResultSet rs = stat.executeQuery(sqlstr);
	                	if(rs.next()){
	                		site = 1;
	                		int id = rs.getInt("id");
	                		String parentCode = rs.getString("code");
	                		List<String> threeList = allRegionMap.get(key).get(secondKey);
	                		for (String string : threeList) {
	                			sqlstr = "insert into region_bak(name,region_type,parent_id,code,full_name,state) values ('"+string+"',3,"+id+",'"+generateCode(site, parentCode, 3)+"','"+key+"=>"+secondKey+"=>"+string+"',1)";
	                			stat.executeUpdate(sqlstr);
	                			site++;
	                		}
	                	}
	                	rs.close();
	                }
	                rrs.close();
            	}
                stat.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static String generateCode(Integer site, String parentCode, Integer leve){
    	StringBuffer code = new StringBuffer(site.toString());
    	switch (leve) {
		case 1:
			while (code.length() < 4) {
				code.insert(0, '0');
			}
			break;
		default:
			while (code.length() < 4) {
				code.insert(0, '0');
			}
			code.insert(0, parentCode);
			break;
		}
    	return code.toString();
    }
    
}


//HashMap valueMap = null;
//if(map.get(key)!=null && !"".equals(map.get(key))){
//    valueMap = (HashMap)map.get(key);
//}
//if(valueMap!=null){
//    while (valueMap.keySet().iterator().hasNext()){
//        HashMap<String, ArrayList> regionMap = new HashMap<String, ArrayList>();
//        String secondkey = valueMap.keySet().iterator().next().toString();
//        String secondvalue = null;
//        if(valueMap.get(key)!=null){
//            secondvalue = valueMap.get(key).toString();
//            ArrayList regionList = JsonUtil.jsonToObject(secondvalue, ArrayList.class);
//            regionMap.put(secondkey, regionList);
//            allRegionMap.put(key, regionMap);
//        }else{
//            regionMap.put(secondkey, null);
//            allRegionMap.put(key, regionMap);
//        }
//    }
//    System.out.println(allRegionMap);
//}else{
//    allRegionMap.put(key, null);
//}