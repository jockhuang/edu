package cn.chineseall.model;

public class IndexVariate extends BaseEntity {
	
	private static final long serialVersionUID = -7511533710546129202L;
	private Integer id;
	private String name;
	private String val;
	private String img;
	private String url;
	private Integer type;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}


}
