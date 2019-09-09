package algorithms.lt0016;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSumClosest
 * Description TODO
 * Author cds
 * Date 2019/9/9 15:30
 * Version 1.0
 **/
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,10,11};
//        int[] nums = new int[]{0, 0, 0};
//        List<List<Integer>> list=threeSum(nums);
        int sum = threeSumClosest(nums, 12);
        System.out.println(sum);
    }
    public static int threeSumClosest(int[] nums, int target) {

        //先排序
        Arrays.sort(nums);

        int result=0;
        for (int i = 0; i < nums.length-1; i++) {
            int left=i+1;
            int right=nums.length-1;
            int sum=nums[i]+nums[left]+nums[right];
            if(i==0){//第一次循环的时候将第一次求得的sum赋值给result
                result=sum;
            }
            while (left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==target){

                    return target;
                }else if(sum>target){//右边值太大了
                    if(Math.abs(sum-target)<Math.abs(result-target)){
                        result=sum;
                    }
                    right--;
                }else{
                    if(Math.abs(sum-target)<Math.abs(result-target)){
                        result=sum;
                    }
                    left++;
                }
            }
        }

        return result;
    }
}
