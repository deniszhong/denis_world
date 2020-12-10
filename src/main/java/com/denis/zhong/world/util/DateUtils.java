package com.denis.zhong.world.util;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/***
 * 事实上Instant就是java8以前的Date
 */
@Slf4j
public class DateUtils {

    /**
     * SimpleDateFormat 线程不安全
     *
     * @param dateStr
     * @param format
     * @return
     */
    @Deprecated
    public static Date formatToDate(String dateStr, String format) {
        if (StringUtils.isEmpty(format)) {
            log.info("格式为空");
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.info("日期转化出错");
        }
        return null;
    }

    @Deprecated
    public static String formatToDateStr(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            log.info("格式为空");
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);

    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime
     * @return
     */
    public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateTime = localDateTime.atZone(zoneId);
        return Date.from(dateTime.toInstant());
    }

    /**
     * 时间戳 转 LocalDateTime
     *
     * @param timeStamp
     * @return
     */
    public static LocalDateTime timeStampToLocalDateTime(Long timeStamp) {
        Instant instant = Instant.ofEpochMilli(timeStamp);
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 时间字符串转换成LocalDateTime
     * @param date
     * @param format
     * @return
     */
    public static LocalDateTime formatToLocalDateTime(String date, String format) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
    }

    /**
     * localDateTime根据格式转换成String
     * @param localDateTime
     * @param format
     * @return
     */
    public static String parseLocalDateTimeToDateStr(LocalDateTime localDateTime, String format) {
        return localDateTime.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 计算时间差
     * 只对应的月份计算 年 月 日
     * @param firstDate
     * @param secDate
     * @param chronoUnit
     * @return
     */
    public static long calcLocalDateTime(Date firstDate, Date secDate, ChronoUnit chronoUnit){
      Instant firstInstant =  firstDate.toInstant();
      Instant secInstant = secDate.toInstant();
      ZoneId zoneId = ZoneId.systemDefault();
      LocalDateTime firstLocal = firstInstant.atZone(zoneId).toLocalDateTime();
      LocalDateTime secLocal = secInstant.atZone(zoneId).toLocalDateTime();
      return calcLocalDatePeriod(firstLocal,secLocal,chronoUnit);
    }

    /**
     * 计算年月日时间差
     * @param firstDateTime
     * @param secDateTime
     * @param chronoUnit
     * @return
     */
    public static long calcLocalDatePeriod(LocalDateTime firstDateTime,LocalDateTime secDateTime,ChronoUnit chronoUnit){
        Period period =  Period.between(firstDateTime.toLocalDate(),secDateTime.toLocalDate());
        return period.get(chronoUnit);
    }

    /**
     * 计算2个时间之间的毫秒数
     * @param first
     * @param second
     * @return
     */
    public static long calcLocalTimeDuration(LocalDateTime first,LocalDateTime second){
        Duration duration =  Duration.between(first.toLocalTime(),second.toLocalTime());
        return duration.toMillis();
    }

//    public static void main(String[] args) {
//        LocalDateTime date = DateUtils.formatToLocalDateTime("2020-12-09 15:23:00", "yyyy-MM-dd HH:mm:ss");
//        LocalDateTime secDate = DateUtils.formatToLocalDateTime("2019-10-09 15:10:00", "yyyy-MM-dd HH:mm:ss");
//        System.out.println(DateUtils.parseLocalDateTimeToDateStr(date, "yyyy-MM-dd HH:mm:ss"));
//        System.out.println(DateUtils.timeStampToLocalDateTime(System.currentTimeMillis()));
//        System.out.println(DateUtils.dateToLocalDateTime(new Date()).toLocalDate());
//        LocalDateTime first = LocalDateTime.now();
//        LocalDateTime second = LocalDateTime.of(2020,12,9,15,24,0);
//        System.out.println(DateUtils.calcLocalDatePeriod(first,second,ChronoUnit.YEARS));
//        System.out.println(calcLocalTimeDuration(date,second));
//    }
}
