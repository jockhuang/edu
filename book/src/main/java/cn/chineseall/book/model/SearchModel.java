package cn.chineseall.book.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.client.solrj.beans.Field;

public class SearchModel {
    @Field("id")
    long id;

    @Field("name")
    String name;

    @Field("img")
    String img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        if(img==null)
            return null;
        if (img.trim().length() == 0)
            return null;
        return img;
    }

    public void setImg(String img) {
        if (img.trim().length() == 0)
            this.img = null;
        else
            this.img = img;
    }
    
    String replaceHtml(String html){
        String regEx="<.+?>"; //表示标签
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(html);
        String s=m.replaceAll("");
        return s;
    }
}
