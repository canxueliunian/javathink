package com.canxue.day;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


/**
 * @Author Lishuntao
 * @Date 2019/10/17
 */
public class DateUtil {
    /**
     * the milli second of a day
     */
    public static final long DAYMILLI = 24 * 60 * 60 * 1000;
    /**
     * the milli seconds of an hour
     */
    public static final long HOURMILLI = 60 * 60 * 1000;
    /**
     * the milli seconds of a minute
     */
    public static final long MINUTEMILLI = 60 * 1000;
    /**
     * the milli seconds of a second
     */
    public static final long SECONDMILLI = 1000;
    /**
     * 年月日
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 年月日中文
     */
    public static final String YYYY_MM_DD_ZH = "yyyy年MM月dd日";

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static final String ALL_ZH = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * date format MM月dd日 HH:mm
     */
    public static final String HH_MM_SS = "HH:mm:ss";


    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    public static final ZoneId ZONE = ZoneId.systemDefault();


    /**
     * date format yyyy-MM-dd HH:mm:ss
     */

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * date --> string by format
     */
    public static String format(LocalDateTime localDateTime, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date --> string by format
     */
    public static String format(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date --> string by format
     */
    public static String formatYMD(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * string 转 LocalDateTime
     *
     * @param dateStr 例："2017-08-11 01:00:00"
     * @param format  例："yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static LocalDateTime pattern(String dateStr, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * string 转 LocalDateTime
     *
     * @param dateStr 例："2017-08-11 01:00:00"
     * @return
     */
    public static LocalDateTime pattern(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLoclTime(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, DEFAULT_ZONE);

        return localDateTime;
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {

        return dateToLoclTime(date).toLocalDate();
    }

    public boolean isBefore(LocalDateTime before, LocalDateTime after) {
        return before.isBefore(after);
    }

    public boolean isAfter(LocalDateTime before, LocalDateTime after) {
        return before.isAfter(after);
    }

    public static long getDiffSecond(LocalDateTime lt, LocalDateTime gt) {
        Instant ltInstant = lt.toInstant(ZoneOffset.ofHours(8));
        Instant gtInstant = gt.toInstant(ZoneOffset.ofHours(8));
        long l1 = ltInstant.toEpochMilli();
        long l2 = gtInstant.toEpochMilli();
        return (l2 - l1) / SECONDMILLI;
    }

    public static long getDiffMin(LocalDateTime lt, LocalDateTime gt) {
        return getDiffSecond(lt, gt) / 60;
    }

    /**
     * 比较time1,time2两个时间相差的小时数，如果time1<=time2,返回0
     *

     */
    public static long getDiffHour(LocalDateTime lt, LocalDateTime gt) {
        return getDiffMin(lt, gt) / 60;
    }

    /**
     * 比较time1,time2两个时间相差的秒数，如果time1<=time2,返回0
     *

     */


    /**
     * 计算两个日期LocalDate相差的天数，不考虑日期前后，返回结果>=0
     *
     * @param before
     * @param after
     * @return
     */
    public static int getDiffDate(LocalDate before, LocalDate after) {
        return Math.abs(Period.between(before, after).getDays());
    }


    /**
     * 根据时间获取当月有多少天数
     *
     * @param date
     * @return
     */
    public static int getMonthDays(Date date) {

        return dateToLoclTime(date).getMonth().length(dateToLocalDate(date).isLeapYear());
    }

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return 1:星期一；2:星期二；3:星期三；4:星期四；5:星期五；6:星期六；7:星期日；
     */
    public static int getWeekByDate(Date date) {
        return dateToLoclTime(date).getDayOfWeek().getValue();
    }


    /**
     * 计算两个时间LocalDateTime相差的月数，不考虑日期前后，返回结果>=0
     *
     * @param before
     * @param after
     * @return
     */
    public static int getDiffMonth(LocalDateTime before, LocalDateTime after) {

        return Math.abs(Period.between(before.toLocalDate(), after.toLocalDate()).getMonths());
    }

    /**
     * 计算两个时间LocalDateTime相差的年数，不考虑日期前后，返回结果>=0
     *
     * @param before
     * @param after
     * @return
     */
    public static int getDiffYear(LocalDateTime before, LocalDateTime after) {

        return Math.abs(Period.between(before.toLocalDate(), after.toLocalDate()).getYears());
    }


    /**
     * 特定日期的当月第一天
     *
     * @return
     */
    public static LocalDate newThisMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 特定日期的当月第一天
     *
     * @return
     */
    public static LocalDate newThisMonth(LocalDateTime localDate) {
        return localDate.toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 特定日期的当月最后一天
     *
     * @return
     */
    public static LocalDate lastThisMonth(LocalDateTime localDate) {

        return localDate.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
    }


    public static void main(String[] args) {
    }


    /**
     * 获取当前时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime now() {
        return LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));

    }


    /**
     * 增加或减少年/月/周/天/小时/分/秒数
     *
     * @param localDateTime 例：ChronoUnit.DAYS
     * @param num
     * @return LocalDateTime
     */
    public static LocalDateTime addSecond(LocalDateTime localDateTime, int num) {
        return localDateTime.plusSeconds(num);
    }

    public static LocalDateTime addDay(LocalDateTime localDateTime, int num) {
        return localDateTime.plusDays(num);
    }


    /**
     * 比较两个时间LocalDateTime大小
     *
     * @param time1
     * @param time2
     * @return 1:第一个比第二个大；-1：第一个与第二个相同；0：第二个大于第一个:1
     */
    public static int compare(LocalDateTime time1, LocalDateTime time2) {

        if (time1.isAfter(time2)) {
            return -1;
        } else if (time1.isBefore(time2)) {
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * 比较time1,time2两个时间相差的分钟数，如果time1<=time2,返回0
     *
     * @param time1
     * @param time2
     */
    public static long getDiffMin(Timestamp time1, Timestamp time2) {
        long diff = 0;
        if (diff > 0) {
            return diff;
        } else {
            return 0;
        }
    }


    /**
     * 判断当前时间是否在时间范围内
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean isInRange(Date startTime, Date endTime) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = dateToLoclTime(startTime);
        LocalDateTime end = dateToLoclTime(endTime);
        return (start.isBefore(now) && end.isAfter(now)) || start.isEqual(now) || end.isEqual(now);
    }

}
