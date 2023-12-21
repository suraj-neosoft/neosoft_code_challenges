/**
 Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
 the array num = [0,1,2,4,5,6,7] might become:

   [4,5,6,7,0,1,2] if it was rotated 4 times.
   [0,1,2,4,5,6,7] if it was rotated 7 times.
 Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in
 the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 Given the sorted rotated array num of unique elements, return the minimum element of this array.
 You must write an algorithm that runs in O(log n) time.

 Example 1:
 Input: num = [3,4,5,1,2]
 Output: 1
 Explanation: The original array was [1,2,3,4,5] rotated 3 times.

 Example 2:
 Input: num = [4,5,6,7,0,1,2]
 Output: 0
 Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

 Example 3:
 Input: num = [11,13,15,17]
 Output: 11
 Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */
public class Problem6 {
    public static void main(String[] args) {
        /** The original array was [1,2,3,4,5] rotated 3 times.*/
        // we have to find minimum element from the array .i.e 1
        int[] arr = {3,4,5,1,2};
        System.out.println(getMinimumElementFromRotatedArray(arr));
    }

    public static int getMinimumElementFromRotatedArray(int[] arr){

        int lowIndex = 0;
        int highIndex = arr.length-1;

        while (lowIndex < highIndex){
            int midIndex = lowIndex + (highIndex-lowIndex)/2;
            if(arr[midIndex] > arr[highIndex]){
                lowIndex = midIndex+1;
            }else {
                highIndex = midIndex;
            }
        }
        return arr[highIndex];
    }
}
