package com.example.demo.datastructure;


import org.apache.commons.lang3.math.NumberUtils;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(20);
//        tree.root.setLeft(new Node(8));
//        tree.root.setRight(new Node(22));
//        tree.root.getLeft().setRight(new Node(3));
//        tree.root.getRight().setLeft(new Node(4));
//        tree.root.getLeft().setLeft(new Node(5));
//        tree.root.getLeft().getRight().setRight(new Node(14));
//        tree.root.getLeft().getRight().setLeft(new Node(10));
//        tree.root.getRight().setRight(new Node(25));
//        BinaryTree.bottomView(tree.root);
//        Long i = new Long("3456.78");
//        LocalDate endDate = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toLocalDate();
//        List<Integer> items= new ArrayList<>();
//        System.out.println();
//        System.out.println(endDate.atStartOfDay());
//        Integer d = checkException();
//        System.out.println("the value is" + d);
//        System.out.println(BigDecimal.valueOf(i));
        MultivaluedMap<String,Object> entity = new MultivaluedHashMap();
        entity.add("Authorization", "Basic " + checkFun());


    }

    public static Calendar adjustEndDays(Calendar calendar, int startDays) {
        int renewDays = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDaysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (renewDays != maxDaysInMonth && renewDays < startDays)
            if (startDays < maxDaysInMonth)
                calendar.set(Calendar.DAY_OF_MONTH, startDays);
            else
                calendar.set(Calendar.DAY_OF_MONTH, maxDaysInMonth);

        return calendar;
    }

    public static Integer checkException(){
        Integer renewNo = 1;
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return renewNo;
    }
//    public static String getTransactionAmountInRupee(String transactionAmount) {
//        if (NumberUtils.isNumber(transactionAmount)) {
//            double txnAmount = Double.parseDouble(transactionAmount);
//            txnAmount /= 100.00;
//            String formattedTxnAmount = format(txnAmount);
//            LOGGER.debug("Formatted Txn Amount is :: {}", formattedTxnAmount);
//            return formattedTxnAmount;
//        } else {
//            return transactionAmount;
//        }
//    }

    public static String checkFun(){
        return null;
    }
}
