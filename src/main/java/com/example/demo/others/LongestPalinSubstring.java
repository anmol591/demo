package com.example.demo.others;

public class LongestPalinSubstring {

    // This function prints the longest
    // palindrome substring of str[].
    // It also returns the length of the
    // longest palindrome
    static int longestPalSubstr(String str)
    {
        // get length of input string
        int n = str.length();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start,
                start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }



    //2nd approach: www.geeksforgeeks.org/longest-palindromic-substring-set-2/    [t=n^2,s=o(1)]
    private static void longestPalindromicSubstring(String str){
        int len = str.length();
        int low,high,start=0;
        int maxLength = 1;

        for(int i=1;i<len;i++){
            low = i-1;
            high = i+1;
            while(low >=0 && high<len && str.charAt(low) == str.charAt(high)){
                if(high-low+1 > maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }

            low = i-1;
            high = i;
            while(low >=0 && high<len && str.charAt(low) == str.charAt(high)){
                if(high-low+1 > maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }
        }

        System.out.println("Longest substring is:");
        printSubStr(str,start,start+maxLength-1);
    }


    private static void printSubStr(String str,
                            int low, int high)
    {
        System.out.println(
                str.substring(
                        low, high + 1));
    }
}
