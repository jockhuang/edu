package cn.chineseall.utils;

import org.htmlparser.Node;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;

public class HtmlUtils {
    /**
     * 去除字符串中的html代码
     * 
     * @param userId 会员ID
     * @return
     */
    public static String dealHtmlContent(String content) {
    	   StringBuilder result = new StringBuilder();
		   try {
			Lexer lexer=new Lexer(content);
			for(Node node=null;(node=lexer.nextNode())!=null;){
				if(node instanceof TextNode){
					result.append(node.getText().trim());
				}
			}
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   String tmp = result.toString().replace("&nbsp;", "");
		   tmp = tmp.replace(" ", "");
		   tmp = tmp.replace("&ldquo;", "");
		   tmp = tmp.replace("&rdquo;", "");
		   tmp = tmp.replace("&quot;", "");
		   tmp = tmp.replace("&hellip;", "");
		   tmp = tmp.replace("&lsquo;", "");
		   tmp = tmp.replace("&rsquo;", "");
		   tmp = tmp.replace("&mdash;", "");
		   tmp = tmp.replace("&middot;", "");
		   return tmp;
    }
}
