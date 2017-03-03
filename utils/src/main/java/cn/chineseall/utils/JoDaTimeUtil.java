package cn.chineseall.utils;

import java.util.Date;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class JoDaTimeUtil {

    public static Date toDate(String dateStr) {
        DateTime dateTime = new DateTime(dateStr);
        return dateTime.toDate();
    }
    
    public static int getDayOfMonth(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getDayOfMonth();
    }

    public static int getDayOfYear(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getDayOfYear();
    }

    public static int getDayOfWeek(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.getDayOfWeek();
    }

    public static Date addDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        DateTime newDateTime = dateTime.plusDays(days);
        return newDateTime.toDate();
    }

    public static Date minusDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        DateTime newDateTime = dateTime.minusDays(days);
        return newDateTime.toDate();
    }
    
    public static Date addMonth(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        DateTime newDateTime = dateTime.plusMonths(months);
        return newDateTime.toDate();
    }

    public static String toString(Date date, String format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    public static Date getBeginOfDay(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime newDateTime = dateTime.hourOfDay().setCopy(0).minuteOfHour().setCopy(0).secondOfMinute().setCopy(0);
        return newDateTime.toDate();
    }

    public static Date getEndOfDay(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime newDateTime = dateTime.hourOfDay().setCopy(23).minuteOfHour().setCopy(59).secondOfMinute().setCopy(59);
        return newDateTime.toDate();
    }

    public static Date getDate(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour,
            int secondOfMinute, int millisOfSecond) {
        DateTime dateTime = new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour, secondOfMinute,
                millisOfSecond);
        return dateTime.toDate();
    }
    
}
