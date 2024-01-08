package com.core_java.neoSoft;

/**
 Given an array of integers. Find the Inversion Count in the array.
 Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted.
 If the array is already sorted then the inversion count is 0.
 If an array is sorted in the reverse order then the inversion count is the maximum.
 Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

 Example 1:
 Input: N = 5, arr[] = {2, 4, 1, 3, 5}
 Output: 3
 Explanation: The sequence 2, 4, 1, 3, 5
 has three inversions (2, 1), (4, 1), (4, 3).

 Example 2:
 Input: N = 5
 arr[] = {2, 3, 4, 5, 6}
 Output: 0
 Explanation: As the sequence is already
 sorted so there is no inversion count.

 Example 3:
 Input: N = 3, arr[] = {10, 10, 10}
 Output: 0
 Explanation: As all the elements of array
 are same, so there is no inversion count
 */
public class Problem8 {
    public static void main(String[] args) {

        int arr[] = {2, 4, 1, 3, 5};

        int arr1[] = {2, 3, 4, 5, 6};

        int arr2[] = {10, 10, 10};

        System.out.println(inversionCount(arr));
        System.out.println(inversionCount(arr1));
        System.out.println(inversionCount(arr2));
    }

    public static int inversionCount(int[] arr){
        int inversionCount = 0 ;
        for(int i = 0 ; i < arr.length -1 ;i++){
            for(int j = i+1 ; j< arr.length ;j++){
               if(arr[i] > arr[j]){
                   inversionCount++;
               }
            }
        }
        return inversionCount;
    }

}
