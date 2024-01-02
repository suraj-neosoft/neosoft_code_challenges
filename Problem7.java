import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
    i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 Notice that the solution set must not contain duplicate triplets.
 Example 1:
 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]
 Explanation:
 nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 The distinct triplets are [-1,0,1] and [-1,-1,2].
 Notice that the order of the output and the order of the triplets does not matter.

 Example 2:
 Input: nums = [0,1,1]
 Output: []
 Explanation: The only possible triplet does not sum up to 0.

 Example 3:
 Input: nums = [0,0,0]
 Output: [[0,0,0]]
 Explanation: The only possible triplet sums up to 0.
 */
public class Problem7 {
    public static void main(String[] args) {
       int[] arr = {-1,0,1,2,-1,-4};
       System.out.println(getResult(arr));
    }

    public static List<List<Integer>> getResult(int[] arr){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
         for(int i = 0 ; i< arr.length-2;i++){
             if(i>0 && arr[i] == arr[i-1])
                 continue;
             int target = -arr[i];
             int low = i+1;
             int high = arr.length-1;
             while (low < high){
                 if(arr[low]+arr[high] == target){
                     result.add(Arrays.asList(arr[low],arr[high],arr[i]));
                     while (low < high && arr[low]==arr[low+1])
                         low++;
                     while (low < high && arr[high]==arr[high-1])
                         high--;

                     low++;
                     high--;
                 }else if(arr[low]+arr[high]<target)
                     low++;
                 else
                     high--;
             }
         }
        return result;
    }
}
