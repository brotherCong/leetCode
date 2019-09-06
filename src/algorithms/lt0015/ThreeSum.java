package algorithms.lt0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSum
 * Description TODO
 * Author cds
 * Date 2019/9/6 19:34
 * Version 1.0
 **/
public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> list=threeSum(nums);
        for (List<Integer> l:list) {
            for (Integer i:l) {
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        if(nums==null||nums.length<=2){//如果数组为空或者长度小于3则直接返回
            return result;
        }
        Arrays.sort(nums);//数组排序

        for (int i = 0; i < nums.length - 2; i++) {//循环数组 这里不能到-3  -3会导致000不走
            int min = i + 1, max = nums.length - 1;
            if(nums[i] > 0 || nums[max] < 0){//最小的大于0或者最大的小于0  退出
                break;
            }
            if (min >= max || nums[i] * nums[max] > 0) {//如果两个相遇或者 同符号则跳出
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){//跳过重复
                continue;
            }
            while (min < max) {
                int sum=nums[i] + nums[min] + nums[max];
                if (sum== 0) {
                    result.add(Arrays.asList(nums[i], nums[min], nums[max]));
                    while (min < max && nums[min] == nums[min + 1]) min++; //跳过重复
                    while (max > min && nums[max] == nums[max - 1]) max--; //跳过重复
                    min++;
                    max--;
                } else if (sum > 0) {//如果大于0 说明右边的值太大了
                    max--;
                } else if (sum < 0) {//如果小于0 说明左边值太小了
                    min++;
                }
            }
        }

        return result;
    }
}
