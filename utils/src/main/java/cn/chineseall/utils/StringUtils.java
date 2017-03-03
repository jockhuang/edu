package cn.chineseall.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 判断字符串中是否包含符号
	 * <p>
	 * 	查看传进来的字符串是否包含符号(除字母,汉字和数字以外的文本内容)
	 * </p>
	 * @param text 字符串
	 * @return {true:包含符号 false:不包含符号}
	 */
	public static boolean isHaveSymbol(String text){
		if(text != null){
			Pattern pattern = Pattern.compile("^[\\u3E00-\\u9FA5A-Za-z\\d]+$");
			return !pattern.matcher(text).find();
		}else{
			return false;
		}
	}
	
	public static String textEllipsis(String text, int size) {
		if (text != null && (text = text.trim()).length() > size) {
			return text.substring(0, size - 1) + "…";
		}
		return text;
	}
	
	public static String simpleFilterHTML(String source) {
		if (source == null) {
			return "";
		}
		return source.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}
	
	public static String clearHtmlTag(String s) {
		try {
			if ((s == null) || (s.length() == 0))
				return "";
			Matcher m = null;
			m = Pattern.compile("<(.[^>]*)>", 32).matcher(s);
			while (m.find()) {
				s = s.replace(m.group(), "");
			}
			s = s.replaceAll("&nbsp;", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public static boolean haveSql(String s){
	    String regex = "truncate|declare|%|select|insert|and|or|update|delete|\\'|\\/\\*|\\*|\\.\\.\\/|\\.\\/|union|into|load_file|outfile";
	    Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(s);
	    if(matcher.find()){
	        return true;
	    }
	    return false;
	}
	
	public static String replaceSql(String s){
        String regex = "truncate|declare|%|select|insert|and|or|update|delete|\\'|\\/\\*|\\*|\\.\\.\\/|\\.\\/|union|into|load_file|outfile";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        return matcher.replaceAll("");
    }
	
	public static void main(String args[]){
	    System.out.println(haveSql("table"));
	}
}
