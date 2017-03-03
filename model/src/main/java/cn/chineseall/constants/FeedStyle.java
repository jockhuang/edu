package cn.chineseall.constants;

public enum FeedStyle {

	NORMAL("normal"), TIME_AXIS("timeAxis");

	private String value;

	FeedStyle(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}