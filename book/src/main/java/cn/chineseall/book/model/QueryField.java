package cn.chineseall.book.model;


public enum QueryField {
    ALL(""), AUTHOR("author"),NAME("name"),PUBLISHER("publisher"),READER("reader"),TAG("tag");
    private String title = null;

    QueryField(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (QueryField obj : QueryField.values()) {
            if (obj.getIndex() == index) {
                return obj.title;
            }
        }
        return null;
    }

    public int getIndex() {
        return this.ordinal();
    }

}
