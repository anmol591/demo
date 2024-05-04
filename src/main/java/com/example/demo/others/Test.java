package com.example.demo.others;


import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
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
//        Job[] jobs = {new Job(3,6,10),new Job(8,9,12),new Job(1,5,7)};
        List<Job> jobs1 = new ArrayList<>();
        jobs1.add(new Job(3,6,10));
        jobs1.add(new Job(8,9,12));
        jobs1.add(new Job(1,5,7));
        Collections.sort(jobs1, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.getEndTime()- o1.getEndTime();
            }
        });
        int[] t = new int[jobs1.size()];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i< jobs1.size();i++){
            t[i] = jobs1.get(i).getProfit();
        }

        for(int i=1;i<jobs1.size();i++){
            for(int j=0;j<i;j++){
                if(jobs1.get(i).getStartTime()>=jobs1.get(j).getEndTime()){
                    t[i] = Math.max(t[j]+ jobs1.get(i).getProfit(),jobs1.get(i).getProfit());
                    maxProfit = Math.max(t[i],maxProfit);
                }
            }
        }
    }

    //1->2->2->1

}
