package cn.chineseall.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class DBAlter {

    private static String url = "jdbc:mysql://localhost/%s?useUnicode=true&characterEncoding=utf-8";
    private static String user = "root";
    private static String password = "wait4you";
    private static String dbName = "bookchina2";
    
    /**
     * 生成alter语句修改数据库
     * @param args
     */
    public static void main(String[] args) {
        StringBuffer sqlBuffer = new StringBuffer();
        List<String> tableList = MataDataTool.loadTables(url, user, password, dbName);
        for(String tableName : tableList){
            sqlBuffer.append("##########TABLE "+tableName+" 修改开始").append("\n\r");
            List<String[]> matadataList = MataDataTool.loadTableFields(url, user, password, dbName, tableName);
            for(String[] matadata: matadataList){
                String alertStatement = getContent(tableName,matadata[0],matadata[1], matadata[2], matadata[3], matadata[4],matadata[5], matadata[6]);
                if(alertStatement!=null){
                    sqlBuffer.append(alertStatement).append("\n\r");
                }
            }
            sqlBuffer.append("##########TABLE "+tableName+" 修改结束").append("\n\r");
        }
        writeFile("/home/huqilong/Desktop/alert.sql",sqlBuffer.toString());
    }

    
    public static String getContent(String tableName,String fieldName,String typeName,String key,String nullable,String defaultValue,String extra, String comment){
        //ALTER TABLE `security`.`security_user` CHANGE COLUMN `Id` `id` INT(11) NOT NULL AUTO_INCREMENT  ;
        //dbName tableName   orgin_fieldName newfieldName  newType  null/not null  default_value  autoincrement
        String alterStatement = "ALTER TABLE `%s`.`%s` CHANGE COLUMN `%s` `%s` %s  %s %s %s COMMENT '%s';";
        String regx="[A-Z]+[^A-Z]?";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(fieldName);
        String parameters[] = new String[9];
        parameters[0]=dbName;
        parameters[1]=tableName;
        parameters[2]=fieldName;
        parameters[4]=typeName;
        if(nullable.equalsIgnoreCase("yes")){
            parameters[5]=" ";
        }else{
            parameters[5]="NOT NULL";
        }
        if(defaultValue!=null){
            if(defaultValue.equalsIgnoreCase("CURRENT_TIMESTAMP")){
                parameters[6]=" DEFAULT "+defaultValue+"";
            }else{
                parameters[6]=" DEFAULT '"+defaultValue+"'";
            }
        }else{
            parameters[6]=""+defaultValue+"";
        }
             
        if(extra==null){
            parameters[7]="";
        }else{
            parameters[7]=extra;
        }
        if(comment==null){
            parameters[8]="";
        }else{
            parameters[8]=comment;
        }
        
        String alertStatement = "";
        String newFieldName = fieldName;
        if(!matcher.find()){
            return null;
        }else{
            String replacedFieldName = matcher.group();
            if(fieldName.startsWith(replacedFieldName)){
                newFieldName = newFieldName.replaceAll(replacedFieldName, replacedFieldName.toLowerCase());
            }else{
                if(!newFieldName.substring(newFieldName.indexOf(replacedFieldName)-1).startsWith("_")){
                    newFieldName = newFieldName.replaceAll(replacedFieldName, "_"+replacedFieldName.toLowerCase());
                }else{
                    newFieldName = newFieldName.replaceAll(replacedFieldName, replacedFieldName.toLowerCase());
                }
            }
        }
        while(matcher.find()){
            String replacedFieldName = matcher.group();
            if(fieldName.startsWith(replacedFieldName)){
                newFieldName = newFieldName.replaceAll(replacedFieldName, replacedFieldName.toLowerCase());
            }else{
                //非开头字符前面有下划线的也不加_
                if(!newFieldName.substring(newFieldName.indexOf(replacedFieldName)-1).startsWith("_")){
                    newFieldName = newFieldName.replaceAll(replacedFieldName, "_"+replacedFieldName.toLowerCase());
                }else{
                    newFieldName = newFieldName.replaceAll(replacedFieldName, replacedFieldName.toLowerCase());
                }
                parameters[3]=newFieldName;
            }
        }
        parameters[3]=newFieldName;
        alertStatement = String.format(alterStatement, parameters);
        return alertStatement;
    }
    
    private static void writeFile(String filePath,String content){
        File file = new File(filePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
        if(!file.exists()){
            file.createNewFile();
        }
        FileUtils.writeStringToFile(file, content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
