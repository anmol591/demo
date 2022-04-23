package com.example.demo.commandpattern.utils;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static final Clock CLOCK = Clock.tick(Clock.systemDefaultZone(), Duration.ofHours(1));

    private static Date convertLocalDateTimeToDate(LocalDateTime dateTime){
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static void setTime(int hour,int minute,int second){
        //LocalDate date = LocalDate.now().with(ChronoField.DAY_OF_MONTH,5).with(ChronoField.DAY_OF_WEEK,2);
        LocalDateTime dateTime = LocalDateTime.now().withHour(hour).withMinute(minute).withSecond(second);
        System.out.println(dateTime);
    }

    private static void localDateTime(){
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date is: " + currentDate);
        LocalDateTime dateTime = currentDate.minusDays(3).atStartOfDay(); //subtract and get start of days
        LocalDateTime endDateTime = currentDate.minusDays(3).atTime(LocalTime.MAX); // get end of day
//        currentDate.atTime(6,7,8);
//        currentDate.plusMonths(1);

//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateTime.format(format));
        Date start = convertLocalDateTimeToDate(dateTime); //convert to date object
        Date end = convertLocalDateTimeToDate(endDateTime);
    }

    private static Date createDateTime(int hour,int minute,int second,int millisecond,int daysAgo){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-daysAgo);
        //calendar.setTimeInMillis(calendar.getTime().getTime());
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        calendar.set(Calendar.MILLISECOND,millisecond);
        Date newDate = new Date(calendar.getTime().getTime());
        return newDate;
    }

    public static Date getStartDate(int daysAgo){
        return createDateTime(0,0,0,0,daysAgo);
    }

    public static Date getEndDate(int daysAgo){
        return createDateTime(23,59,59,999,daysAgo);
    }

}
