Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number
 of 1's in the binary representation of i.

 Example 1:
 Input: n = 2
 Output: [0,1,1]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 Example 2:

 Input: n = 5
 Output: [0,1,1,2,1,2]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 3 --> 11
 4 --> 100
 5 --> 101

 Constraints:
 0 <= n <= 105
 */
public class Problem12 {
    public static void main(String[] args) {
        int n = 5;
        print(bitsCount(n));
    }

    public static int[] bitsCount(int n){
        int[] arr = new int[n+1];
        for(int i = 1; i< arr.length;i++){
             arr[1] = arr[i >> 1] + i % 2;
        }
        return arr;
    }

    public static void print(int[] arr){
        for(int i = 0;i< arr.length ;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
