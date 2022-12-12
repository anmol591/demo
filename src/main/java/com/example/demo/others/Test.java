package com.example.demo.others;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Node3{
    private int data;
    private Node3 next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node3 getNext() {
        return next;
    }

    public void setNext(Node3 next) {
        this.next = next;
    }
}
//[1,2,2,3,3,5] : 5
public class Test {
    public static void find(){
        Map<String, String> errorCodeMap = null;
        String bankResponseCode = "{resultStatus=8010, resultCode=FGW_NOT_SUFFICIENT_FUNDS, resultCodeId=U30-Z9, resultMsg=NA}";
        try {
            if (StringUtils.isNotBlank(bankResponseCode)) {
                bankResponseCode = bankResponseCode.replaceAll("[{}]", "");
                errorCodeMap = Arrays.stream(bankResponseCode.split(",")).map(s -> s.split("="))
                        .collect(Collectors.toMap(s -> s[0], s -> s[1]));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(errorCodeMap);
    }

    public static void newDateTime(Date dateObj){
        LocalDateTime currentDate = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        currentDate = currentDate.minus(5, ChronoUnit.MINUTES); //Handling if job runs at 00:00:00 midnight
        LocalDateTime endOfDate = LocalDateTime.of(currentDate.toLocalDate(), LocalTime.MAX);
        Date endOfDate2 = Date.from(endOfDate.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(dateObj.compareTo(endOfDate2) > 0);
        System.out.println(endOfDate2);
    }

    public static void main(String[] args){
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH,1);
//        newDateTime(calendar.getTime());
        System.out.println(new Date());
    }

    //1->2->2->1

}
