/**
 Given an integer array num, find a sub-array that has the largest product, and return the product.
 The test cases are generated so that the answer will fit in a 32-bit integer.
 Example 1:
 Input: num = [2,3,-2,4]
 Output: 6
 Explanation: [2,3] has the largest product 6.

 Example 2:
 Input: num = [-2,0,-1]
 Output: 0
 Explanation: The result cannot be 2, because [-2,-1] is not a sub-array.
 */
public class Problem5 {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(getLargestProduct(arr));
    }
    public static int getLargestProduct(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int prefixProduct = 0;
        int suffixProduct = 0;
        int maxProduct = arr[0];
        for(int i = 0; i< arr.length ;i++){
             prefixProduct = (prefixProduct == 0 ? 1 : prefixProduct) * arr[i];
             suffixProduct = (suffixProduct == 0 ? 1 : suffixProduct) * arr[arr.length-i-1];
             maxProduct = Math.max(maxProduct,Math.max(prefixProduct,suffixProduct));
        }
        return maxProduct;
    }
}
