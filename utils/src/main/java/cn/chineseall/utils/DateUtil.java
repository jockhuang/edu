package cn.chineseall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    private static final SimpleDateFormat shortsdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat longsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat localsdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");

    /**
     * 时间格式化（到日期）
     * 
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        String newDate = "";
        if (date == null) {
            return newDate;
        }
        try {
            newDate = shortsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

    /**
     * 时间格式化（到秒）
     * 
     * @param obj
     * @return
     */
    public static String formatTime(Date date) {
        String newDate = "";
        if (date == null) {
            return newDate;
        }
        try {
            newDate = longsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

    public static String formatLoaclTime(Date date) {
        String newDate = "";
        if (date == null) {
            return newDate;
        }
        try {
            newDate = localsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /*
     * 根据时间转换问候语 早上：5:00 —— 8:59 上午：9:00 ——10:59 中午：11:00——12:59 下午：13:00——18:59 晚上：19:00——23:59 凌晨：24:00—— 4:59
     */
    public static String getGreetings() {
        String greetings = "早上好";
        String nowdate1 = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());// 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            Date d1 = sdf.parse("5:00:00");
            Date d2 = sdf.parse("8:59:59");

            Date d3 = sdf.parse("9:00:00");
            Date d4 = sdf.parse("10:59:59");

            Date d5 = sdf.parse("11:00:00");
            Date d6 = sdf.parse("12:59:59");

            Date d7 = sdf.parse("13:00:00");
            Date d8 = sdf.parse("18:59:59");

            Date d9 = sdf.parse("19:00:00");
            Date d10 = sdf.parse("23:59:59");

            Date d11 = sdf.parse("24:00:00");
            Date d12 = sdf.parse("4:59:59");
            Date nowdate = sdf.parse(nowdate1);
            if (nowdate.after(d12) && nowdate.before(d3)) {
                greetings = "早上好";
            } else if (nowdate.after(d2) && nowdate.before(d5)) {
                greetings = "上午好";
            } else if (nowdate.after(d4) && nowdate.before(d7)) {
                greetings = "中午好";
            } else if (nowdate.after(d6) && nowdate.before(d9)) {
                greetings = "下午好";
            } else if (nowdate.after(d8) && nowdate.before(d11)) {
                greetings = "晚上好";
            } else if (nowdate.after(d10) && nowdate.before(d1)) {
                greetings = "凌晨好";
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return greetings;
    }

    /**
     * 时间格式化（到秒）
     * 
     * @param ticks 时间刻度
     * @return
     */
    public static String formatTime(Long ticks) {
        String newDate = "";
        if (ticks == null) {
            return newDate;
        }
        try {
            Date date = new Date(ticks);
            newDate = longsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

    public static String formatTimeMin(Date date) {
        String newDate = "";
        if (date == null) {
            return newDate;
        }
        try {
            newDate = shortsdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

    public static Date string2Date(String s, int type) {
        if (s == null) {
            return null;
        }
        Calendar cal = null;
        String a[] = s.split("-| |:");
        try {
            if (a.length >= 3) {
                cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, Integer.valueOf(a[0]));
                cal.set(Calendar.MONTH, Integer.valueOf(a[1]) - 1);
                cal.set(Calendar.DATE, Integer.valueOf(a[2]));
            }
            if (type == 0) {
                if (a.length >= 5) {
                    cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(a[3]));
                    cal.set(Calendar.MINUTE, Integer.valueOf(a[4]));
                    if (a.length == 6) {
                        cal.set(Calendar.SECOND, Integer.valueOf(a[5]));
                    }
                } else {
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                }
            } else if (type == 1) {
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
            } else if (type == 2) {
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
            }
        } catch (Exception e) {

        }
        if (cal != null) {
            return cal.getTime();
        }
        return null;
    }

    public static Date stringDateMin(String s) {
        Date date = null;

        try {
            date = shortsdf.parse(s);
        } catch (ParseException e) {
        }
        return date;
    }

    public static Date stringDate(String s) {
        Date date = null;

        try {
            date = longsdf.parse(s);
        } catch (ParseException e) {
        }
        return date;
    }

    /**
     * 以短格式格式化时间,实例：2010-09-19
     * 
     * @param time 时间刻度
     * @return 格式化后的时间
     * @author zhengrunjin @ 2010-09-19
     */
    public static String StringDateShortFormat(Long time) {
        if (time != null) {
            return shortsdf.format(new Date(time));
        }
        return null;
    }

    public static String StringDate(Long l) {
        if (l != null) {
            return longsdf.format(new Date(l));
        }
        return null;
    }

    /**
     * 返回于指定日期间隔一定天数的日期
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date getSpecDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - days);
        return calendar.getTime();
    }

    public static boolean after(Date date1, Date date2) {
        Calendar dc1 = Calendar.getInstance();
        dc1.setTime(date1);
        Calendar dc2 = Calendar.getInstance();
        dc2.setTime(date2);
        return dc1.after(dc2);
    }

    public static boolean before(Date date1, Date date2) {
        Calendar dc1 = Calendar.getInstance();
        dc1.setTime(date1);
        Calendar dc2 = Calendar.getInstance();
        dc2.setTime(date2);
        return dc1.before(dc2);
    }

    // 日期转换
    public static java.sql.Date getBeforeAfterDate(String datestr, int day) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date olddate = null;
        try {
            df.setLenient(false);
            olddate = new java.sql.Date(df.parse(datestr).getTime());
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(olddate);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        int NewDay = Day + day;

        cal.set(Calendar.YEAR, Year);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, NewDay);

        return new java.sql.Date(cal.getTimeInMillis());
    }

    // 日期转换
    public static Date getBeforeAfterDate(Date date, int day) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        int Year = cal.get(Calendar.YEAR);
        int Month = cal.get(Calendar.MONTH);
        int Day = cal.get(Calendar.DAY_OF_MONTH);

        int NewDay = Day + day;

        cal.set(Calendar.YEAR, Year);
        cal.set(Calendar.MONTH, Month);
        cal.set(Calendar.DAY_OF_MONTH, NewDay);

        return new Date(cal.getTimeInMillis());
    }

    // 参数日期+小时数得到新日期
    // type：1=天数 ，2=小时数 3=月数
    public static Date getNewDate(Date d, int num, int type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        switch (type) {
        case 1:
            calendar.add(Calendar.DAY_OF_YEAR, num);
            break;
        case 2:
            calendar.add(Calendar.HOUR_OF_DAY, num);
            break;
        case 3:
            calendar.add(Calendar.MONTH, num);
            break;
        }

        return calendar.getTime();
    }

    /**
     * 两个日期相差的天数,只精确到天
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static Integer diffDays(Date date1, Date date2) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 返回一天的结束时间
     * 
     * @param d
     * @return
     */
    public String getEndTimeOfDays(String d) {
        return d.trim() + " 23:59:59";
    }

    /**
     * 去掉日期的时间部分
     * 
     * @param d
     * @return
     */
    public String formatDateStr(String d) {
        try {
            return shortsdf.format(longsdf.parse(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        System.out.println(formatLoaclTime(new Date()));
        // System.out.println(formatTime(getZeroOfDay(0)));
        // System.out.println(formatTime(getZeroOfDay(7)));
        // System.out.println(formatTime(getZeroOfDay(6)));
    }

    /**
     * 获取过几分钟的时间
     * 
     * @param d
     * @param num
     * @param type
     * @return
     */
    public static Date getDateAfterSomeMinutes(Date d, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 获得过几小时的时间
     * 
     * @param d 需要计算的时间类型
     * @param hours 小时数
     * @return
     */
    public static Date addHours(Date d, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.HOUR, hours);
        return calendar.getTime();
    }

    public static String formatDate(Date date, String format) {
        String newDate = "";
        if (date == null) {
            return newDate;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat(format);
            newDate = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDate;
    }

    public static String getDate(String datetime) {
        if (datetime == null) {
            return null;
        }
        if (datetime.indexOf(" ") == -1) {
            return datetime;
        }
        return datetime.trim().split(" ")[0];
    }

    /**
     * 获得HH:mm:ss格式的时间字符串
     * 
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     */
    public static String getTimeStr(int hours, int minutes, int seconds) {
        StringBuffer timeStr = new StringBuffer();
        if (hours < 10) {
            timeStr.append("0" + hours);
        } else {
            timeStr.append(hours);
        }
        timeStr.append(":");
        if (minutes < 10) {
            timeStr.append("0" + minutes);
        } else {
            timeStr.append(minutes);
        }
        timeStr.append(":");
        if (seconds < 10) {
            timeStr.append("0" + seconds);
        } else {
            timeStr.append(seconds);
        }

        return timeStr.toString();
    }

    /**
     * 获取时间为0点的某天的Date对象
     * 
     * @param offset
     * @return
     */
    public static Date getZeroOfDay(int offset) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), (cal.get(Calendar.DAY_OF_MONTH) + offset), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 供图片使用（缓存）
     * 
     * @return
     */
    public static Long currentTimeMillis() {
        return System.currentTimeMillis();
    }

}
