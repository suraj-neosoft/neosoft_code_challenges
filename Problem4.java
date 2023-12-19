/**
 Given an integer array nums and an integer k, return the k most frequent elements.
 You may return the answer in any order.
 Example 1:
 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]

 Example 2:
 Input: nums = [1], k = 1
 Output: [1]
 */
public class Problem4 {
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        printArrayElement(getResult(arr,k));
        System.out.println();
        int[] arr1 = {1};
        int k1 = 1;
        printArrayElement(getResult(arr1,k1));
    }

    public static int[] getResult(int[] arr,int k){
        int[] result = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer element : arr ){
            if(map.containsKey(element)){
                map.put(element ,map.get(element)+1);
            }
            else {
                map.put(element ,1);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> map.get(b) - map.get(a));
        int index = 0 ;
        for(int i = 0 ; i < k ;i++){
              result[index] = list.get(i);
              index++;
        }
        return result;
    }

    public static void printArrayElement(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
