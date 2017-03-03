package cn.chineseall.book.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.chineseall.utils.PageUtil;

public class SearchVo {

    private String word;
    private int queryfield;
    private String c0;
    private String c1;
    private String u0;
    private String u1;
    private int t = 0;
    private int s = 0;
    private final long org = 4;

    private String letter;
    private List<String> groupfield;
    private Map<String, String> categorymap = new HashMap<String, String>();
    private Map<String, String> custommap = new HashMap<String, String>();
    private int total = 0;
    private List result;
    private String r;
    private List<GroupItem> regions;
    private List<GroupItem> tag;
    private List<GroupItem> category0;
    private Map<String, List<GroupItem>> category1;
    private List<GroupItem> customcat0;
    private Map<String, List<GroupItem>> customcat1;
    private char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    PageUtil pageUtil = new PageUtil(null, total, 20, 0);

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getC0() {
        return c0;
    }

    public void setC0(String c0) {
        this.c0 = c0;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getQueryfield() {
        return queryfield;
    }

    public void setQueryfield(int queryfield) {
        this.queryfield = queryfield;
    }

    public List<String> getGroupfield() {
        return groupfield;
    }

    public void setGroupfield(List<String> groupfield) {
        this.groupfield = groupfield;
    }

    public Map<String, String> getCategorymap() {
        return categorymap;
    }

    public void setCategorymap(Map<String, String> categorymap) {
        this.categorymap = categorymap;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        pageUtil = new PageUtil(null, total, pageUtil.getPageSize(), pageUtil.getCurrentPage());
        this.total = total;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public List<GroupItem> getRegions() {
        return regions;
    }

    public void setRegions(List<GroupItem> regions) {
        this.regions = regions;
    }

    public List<GroupItem> getCategory0() {
        return category0;
    }

    public void setCategory0(List<GroupItem> category0) {
        this.category0 = category0;
    }

    public Map<String, List<GroupItem>> getCategory1() {
        return category1;
    }

    public void setCategory1(Map<String, List<GroupItem>> category1) {
        this.category1 = category1;
    }

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public List<GroupItem> getCustomcat0() {
        return customcat0;
    }

    public void setCustomcat0(List<GroupItem> customcat0) {
        this.customcat0 = customcat0;
    }

    public Map<String, List<GroupItem>> getCustomcat1() {
        return customcat1;
    }

    public void setCustomcat1(Map<String, List<GroupItem>> customcat1) {
        this.customcat1 = customcat1;
    }

    public String getU0() {
        return u0;
    }

    public void setU0(String u0) {
        this.u0 = u0;
    }

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public Map<String, String> getCustommap() {
        return custommap;
    }

    public void setCustommap(Map<String, String> custommap) {
        this.custommap = custommap;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public long getOrg() {
        return org;
    }

    public List<GroupItem> getTag() {
        return tag;
    }

    public void setTag(List<GroupItem> tag) {
        this.tag = tag;
    }

}
