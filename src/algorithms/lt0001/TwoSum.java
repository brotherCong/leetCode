package algorithms.lt0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * Description TODO
 * Author cds
 * Date 2019/9/6 16:54
 * Version 1.0
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] b = twoSumHash(nums, target);
        Arrays.stream(b).forEach((num) -> {
            System.out.println(num);
        });

    }

    /**
     *
     * @param nums
     * @param target
    * @return int[]
     * @author cds
     * @create:
     * @date 2019/9/6 17:42
     */
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement  = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }

    /**
     *简单粗暴
     * @param nums
     * @param target
    * @return int[]
     * @author cds
     * @create:
     * @date 2019/9/6 17:47
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
}
