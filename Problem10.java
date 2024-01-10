package com.core_java.neoSoft;

/**
 Given an integer array nums, return the length of the longest strictly increasing
 subsequence
 .
 Example 1:
 Input: nums = [10,9,2,5,3,7,101,18]
 Output: 4
 Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

 Example 2:
 Input: nums = [0,1,0,3,2,3]
 Output: 4

 Example 3:
 Input: nums = [7,7,7,7,7,7,7]
 Output: 1

 Constraints:
 1 <= nums.length <= 2500
 -104 <= nums[i] <= 104
 */
public class Problem10 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(longestSubsequence(arr));

        int[] arr1 = {0,1,0,3,2,3};
        System.out.println(longestSubsequence(arr1));

        int[] arr2 = {7,7,7,7,7,7,7};
        System.out.println(longestSubsequence(arr2));
    }

    public static int longestSubsequence(int[] arr){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] resultArr = new int[arr.length];
        resultArr[0] = 1;
        int maxResult = 1;

        for (int i = 1; i < arr.length; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxValue = Math.max(maxValue, resultArr[j]);
                }
            }
            resultArr[i] = maxValue + 1;
            maxResult = Math.max(maxResult, resultArr[i]);
        }
        return maxResult;
    }
}
