/**
 Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ]
 where 0 ≤ i ≤ j < len(S). Palindrome string: A string that reads the same backward.
 More formally, S is a palindrome if reverse(S) = S.
 In case of conflict, return the substring which occurs first ( with the least starting index).
 Example 1:

 Input:
 S = "aaaabbaa"
 Output: aabbaa
 Explanation: The longest Palindromic
 substring is "aabbaa".
 Example 2:

 Input:
 S = "abc"
 Output: a
 Explanation: "a", "b" and "c" are the
 longest palindromes with same length.
 The result is the one with the least
 starting index.
 */

public class Problem3 {
    public static void main(String[] args) {
       String str1 ="aaaabbaa";
       String str2 ="abc";
       System.out.println(longestPalindrome(str1));
    }

    public static String longestPalindrome(String str) {
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = length(str, i, i);
            int len2 = length(str, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > endIndex - startIndex) {
                startIndex = i - (len - 1) / 2;
                endIndex = i + len / 2;
            }
        }
        return str.substring(startIndex, endIndex + 1);
    }

    private static int length(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
