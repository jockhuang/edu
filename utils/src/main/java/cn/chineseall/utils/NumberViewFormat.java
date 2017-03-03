package cn.chineseall.utils;

import java.text.DecimalFormat;

public final class NumberViewFormat {
    private static final DecimalFormat df = new DecimalFormat("###.####");

    public static String format(Integer num) {
        if (num == null)
            num = 0;
        return format(num.longValue());
    }

    public static String format(Long num) {
        if (num > 99999 && num < 100000000) {
            double a = new Double(num) / 10000;
            String s = df.format(a);
            if (a < 100)
                s = s.substring(0, 4);
            else if (a > 100 && a < 1000)
                s = s.substring(0, 3);
            else
                s = s.substring(0, 4);
            return String.format("%s万", s);
        } else if (num >= 100000000) {
            double a = new Double(num) / 100000000;
            String s = df.format(a);

            if (a < 100 && s.length() > 4)
                s = s.substring(0, 4);
            else if (a >= 100 && a < 999.9)
                s = s.substring(0, 3);
            else if (a >= 100000)
                s = s.substring(0, s.indexOf("."));
            return String.format("%s亿", s);
        } else
            return String.valueOf(num);
    }

    

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NumberViewFormat.format(0));
        System.out.println(NumberViewFormat.format(9999L));
        System.out.println(NumberViewFormat.format(99999L));
        System.out.println(NumberViewFormat.format(999999L));
        System.out.println(NumberViewFormat.format(9999999L));
        System.out.println(NumberViewFormat.format(99999999L));
        System.out.println(NumberViewFormat.format(11111111L));
        System.out.println(NumberViewFormat.format(199499989L));
        System.out.println(NumberViewFormat.format(999999989L));
        System.out.println(NumberViewFormat.format(1994999899L));
        System.out.println(NumberViewFormat.format(9998999899L));
        System.out.println(NumberViewFormat.format(11111111111111L));
    }

}
