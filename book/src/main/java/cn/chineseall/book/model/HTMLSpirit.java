package cn.chineseall.book.model;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HTMLSpirit {

    public static String delHTMLTag(String content) {
        Parser myParser;
        NodeList nodes = null;
        StringBuffer str = new StringBuffer();
        myParser = Parser.createParser(content, null);
        NodeFilter filter = new NodeClassFilter(TextNode.class);

        try {
            nodes = myParser.extractAllNodesThatMatch(filter);

            for (int i = 0; i < nodes.size(); i++) {
                TextNode textnode = (TextNode) nodes.elementAt(i);
                String line = textnode.toPlainTextString().trim();
                if (line.equals(""))
                    continue;
                str.append(line);
            }
        } catch (ParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // exception could be thrown here

        return str.toString();
    }

}
