package cn.chineseall.utils;


public class FirstLetter {

    public static String getFirstLetter(String s) {
        if((s==null)||s.length()==0)
            return " ";
        return null;
    }
    
    public static void main(String[] args){
        
        System.out.println(FirstLetter.getFirstLetter("(文轩）门萨之路：500天才思维游戏"));
        System.out.println(FirstLetter.getFirstLetter("“春”字联"));
        System.out.println(FirstLetter.getFirstLetter("饕餮"));
        System.out.println(FirstLetter.getFirstLetter("600道精选数独游戏"));
        System.out.println(FirstLetter.getFirstLetter("Q版语文"));
        System.out.println(FirstLetter.getFirstLetter("满足孩子好奇心的经典故事（青少年心灵成长直通车）"));
        System.out.println(FirstLetter.getFirstLetter(null));
    }
}
