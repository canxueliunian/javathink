package com.canxue.day;

import com.sun.istack.internal.NotNull;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;


/**
 * @Author Lishuntao
 * @Date 2019/10/17
 */
public class LocalDateUtil {
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
     * 年-月-日 格式
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 年-月-日 中文格式
     */
    public static final String ZH_YYYY_MM_DD = "yyyy年MM月dd日";
    /**
     * 年-月-日 时-分-秒 常用格式
     */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年月日 时分秒 常用格式 -- 中文格式
     */
    public static final String ZH_ALL = "yyyy年MM月dd日 HH:mm:ss";
    /**
     * 时-分-秒 格式
     */
    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 默认 时区
     */
    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    /**
     * 上海时区
     */
    public static final ZoneId SHANGHAI_ZONE = ZoneId.of("Asia/Shanghai");
    /**
     * 上海的时差转换
     */
    public static final ZoneOffset SHANGHAI_OFFSET = ZoneOffset.ofHours(8);
    /**
     * 星期
     */
    public static final TemporalField FIELD_ISO = WeekFields.of(Locale.FRANCE).dayOfWeek();


    private static final Logger logger = LoggerFactory.getLogger(LocalDateUtil.class);

    /**
     * 获取时间的指定pattern格式字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String getDateStr(LocalDateTime localDateTime, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取时间的默认字符串
     *
     * @param localDateTime
     * @return
     */
    public static String getDateStr(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取传入时间的年月日字符串格式
     *
     * @param localDateTime
     * @return
     */
    public static String getDateYMDStr(LocalDateTime localDateTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD);
            return localDateTime.format(formatter);

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据传入的 pattern 格式 string 转 LocalDateTime
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
     * string 转 LocalDateTime 使用默认的格式
     *
     * @param dateStr 例："2017-08-11 01:00:00"
     * @return
     */
    public static LocalDateTime pattern(String dateStr) {
        try {
            return pattern(dateStr, DEFAULT_PATTERN);
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
     * Date 转 LocalDate
     *
     * @param date
     * @return LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return dateToLoclTime(date).toLocalDate();
    }


//    ----- 日期处理部分


    public boolean isBefore(LocalDateTime before, LocalDateTime after) {
        return before.isBefore(after);
    }

    public boolean isAfter(LocalDateTime before, LocalDateTime after) {
        return before.isAfter(after);
    }

    /**
     * 获取两个传入时间的相差的秒数
     */
    public static int getDiffSecond(@NotNull LocalDateTime before, @NotNull LocalDateTime after) {
        Instant beforeInstant = before.toInstant(ZoneOffset.ofHours(8));
        Instant afterInstant = after.toInstant(ZoneOffset.ofHours(8));
        long beforeLong = beforeInstant.toEpochMilli();
        long afterLong = afterInstant.toEpochMilli();
        return (int) ((afterLong - beforeLong) / SECONDMILLI);
    }

    /**
     * 获取两个传入时间的相差的分钟数
     */
    public static long getDiffMin(LocalDateTime lt, LocalDateTime gt) {
        return (int) (getDiffSecond(lt, gt) / 60);
    }

    /**
     * 比较time1,time2两个时间相差的小时数
     */
    public static long getDiffHour(LocalDateTime lt, LocalDateTime gt) {
        return (int) (getDiffMin(lt, gt) / 60);
    }

    /**
     * 计算两个日期LocalDate相差的天数
     */
    public static int getDiffDay(LocalDate before, LocalDate after) {
        return (int) (after.toEpochDay() - before.toEpochDay());
    }

    /**
     * 计算两个日期LocalDate相差的天数
     */
    public static int getDiffDay(LocalDateTime before, LocalDateTime after) {
        LocalDate beforeDate = before.toLocalDate();
        LocalDate afterDate = after.toLocalDate();
        return (int) (afterDate.toEpochDay() - beforeDate.toEpochDay());
    }

    /**
     * 获取传入日期月份有多少天
     *
     * @param date
     * @return
     */
    public static int getMonthDaysByDate(LocalDate date) {
        int i = date.getMonth().maxLength();
        return i;

    }

    /**
     * 获取传入日期月份有多少天
     *
     * @param date
     * @return
     */
    public static int getMonthDaysByDate(LocalDateTime date) {
        int i = date.getMonth().maxLength();
        return i;
    }


    /**
     * 特定日期的当月第一天
     *
     * @return
     */
    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 特定日期的当月第一天
     *
     * @return
     */
    public static LocalDate getFirstDayOfMonth(LocalDateTime localDate) {
        return localDate.toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 特定日期的当月最后一天
     *
     * @return
     */
    public static LocalDate getLastDayOfMonth(LocalDateTime localDate) {

        return localDate.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 特定日期的当月最后一天
     *
     * @return
     */
    public static LocalDate getFirstDayOfWeek(LocalDate localDate) {

        return localDate.with(FIELD_ISO, 1);
    }

    /**
     * 特定日期的当月最后一天
     *
     * @return
     */
    public static LocalDate getLastDayOfWeek(LocalDate localDate) {

        return localDate.with(FIELD_ISO, 7);
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
