package com.example.demo.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DoTest {
    // Iterative function to find all possible combinations of words
    // formed from the mobile keypad

    static boolean flag = false;
    public static Set<String> findCombinations(List<List<Character>> keypad, int[] keys)
    {
        // HashSet to store combinations of all possible words
        Set<String> combinations = new HashSet<>();

        // invalid input - return empty set
        if (keypad == null || keypad.size() == 0 || keys == null || keys.length == 0) {
            return combinations;
        }

        // push all characters associated with the first digit into the output list
        for (char ch : keypad.get(keys[0])) {
            combinations.add(String.valueOf(ch));
        }

        // start from the second digit
        for (int i = 1; i < keys.length; i++) {
            // create a temporary list and clear the contents of the output list
            Set<String> prevList = new HashSet<>(combinations);
            combinations.clear();

            // for each character associated with the current digit in the keypad,
            for (Character ch : keypad.get(keys[i])) {
                // append each word's current character in the output list
                for (String s : prevList) {
                    combinations.add(s + ch);
                }
            }

            // list now contains all possible combinations of words
            // until the current digit
        }

        // return output list containing all combinations of words possible
        return combinations;
    }

    public static Date[] getFromToTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -2);
        Date endDate = new Date(getStartEnd(calendar.getTime().getTime(), 0, 0, 0));
        calendar.add(Calendar.DAY_OF_YEAR, -31);
        Date startDate = new Date(getStartEnd(calendar.getTime().getTime(), 0, 0, 0));
       return new Date[]{startDate,endDate};
    }

    public static Long getStartEnd(Long timeInMilliSeconds, int hour, int minute, int second) {
        Calendar lastAccessDateCal = Calendar.getInstance();
        lastAccessDateCal.setTimeInMillis(timeInMilliSeconds);
        lastAccessDateCal.set(Calendar.HOUR_OF_DAY, hour);
        lastAccessDateCal.set(Calendar.MINUTE, minute);
        lastAccessDateCal.set(Calendar.SECOND, second);
        lastAccessDateCal.set(Calendar.MILLISECOND, 0);
        return lastAccessDateCal.getTimeInMillis();
    }

    static void permute(String s1, String s2, int l) {
        if (l == s1.length()) {
            if (s2.indexOf(s1) >= 0)
                flag = true;
        } else {
            for (int i = l; i < s1.length(); i++) {
                s1 = swap(s1, l, i);
                permute(s1, s2, l + 1);
                s1 = swap(s1, l, i);
            }
        }
    }

    public static String swap(String s, int i0, int i1) {
        if (i0 == i1)
            return s;
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0 + 1, i1);
        String s3 = s.substring(i1 + 1);
        return s1 + s.charAt(i1) + s2 + s.charAt(i0) + s3;
    }


    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        HashMap<Character, Integer> s1map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++)
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2map.put(s2.charAt(i + j), s2map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (matches(s1map, s2map))
                return true;
        }
        return false;
    }

    public static boolean matches(HashMap<Character, Integer> s1map, HashMap<Character, Integer> s2map) {
        for (char key : s1map.keySet()) {
            if (s1map.get(key) - s2map.getOrDefault(key, -1) != 0)
                return false;
        }
        return true;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, nums.length, counter, results);
        return results;
    }

    private static void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            List<List<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
//        // mobile keypad
//        List<List<Character>> keypad = Arrays.asList(
//                // 0 and 1 digit doesn't have any characters associated
//                Arrays.asList(),
//                Arrays.asList(),
//                Arrays.asList('A', 'B', 'C'),
//                Arrays.asList('D', 'E', 'F'),
//                Arrays.asList('G', 'H', 'I'),
//                Arrays.asList('J', 'K', 'L'),
//                Arrays.asList('M', 'N', 'O'),
//                Arrays.asList('P', 'Q', 'R', 'S'),
//                Arrays.asList('T', 'U', 'V'),
//                Arrays.asList('W', 'X', 'Y', 'Z')
//        );
//
//        // input number in the form of an array (number cannot start from 0 or 1)
//        int[] keys = {2, 3, 4};
//
//        // find all combinations
//        Set<String> combinations = findCombinations(keypad, keys);
//        System.out.println(combinations);
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums,3));
    }
}
