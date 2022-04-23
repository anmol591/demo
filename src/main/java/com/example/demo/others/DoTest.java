package com.example.demo.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoTest {
    // Iterative function to find all possible combinations of words
    // formed from the mobile keypad
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

    public static void main(String[] args)
    {
        // mobile keypad
        List<List<Character>> keypad = Arrays.asList(
                // 0 and 1 digit doesn't have any characters associated
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList('A', 'B', 'C'),
                Arrays.asList('D', 'E', 'F'),
                Arrays.asList('G', 'H', 'I'),
                Arrays.asList('J', 'K', 'L'),
                Arrays.asList('M', 'N', 'O'),
                Arrays.asList('P', 'Q', 'R', 'S'),
                Arrays.asList('T', 'U', 'V'),
                Arrays.asList('W', 'X', 'Y', 'Z')
        );

        // input number in the form of an array (number cannot start from 0 or 1)
        int[] keys = {2, 3, 4};

        // find all combinations
        Set<String> combinations = findCombinations(keypad, keys);
        System.out.println(combinations);
    }
}
