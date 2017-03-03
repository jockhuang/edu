package cn.chineseall.book.model;

public class GroupItem {
    private String id;
    private String name;
    private long count;
    
    public GroupItem() {
       
    }
    
    
    public GroupItem(String id, String name, long count) {
        super();
        this.id = id;
        this.name = name;
        this.count = count;
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
    }
    
    
}
