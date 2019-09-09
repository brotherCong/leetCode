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
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 0, 0};
//        List<List<Integer>> list=threeSum(nums);
        List<List<Integer>> list = threeSum(nums, 0);
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

        for (int i = 0; i < nums.length-2; i++) {//循环数组 这里不能到-3  -3会导致000不走
            int min = i + 1, max = nums.length - 1;
            if(nums[i] > 0 || nums[max] < 0){//最小的大于0或者最大的小于0  退出
                break;
            }
            if (min >= max ) {//如果两个相遇或者 同符号则跳出|| nums[i] * nums[max] > 0  加了这一段就会失败 为什么？
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
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    /**
     *给定数组和 指定值
     * @param nums
     * @param target
    * @return java.util.List<java.util.List<java.lang.Integer>>
     * @author cds
     * @create:
     * @date 2019/9/9 14:57
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();

        if (nums == null || nums.length <= 2) {//如果数组为空或者长度小于3则直接返回
            return result;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < nums.length - 2; i++) {//循环数组 这里不能到-3  -3会导致000不走
            int min = i + 1, max = nums.length - 1;
            if (nums[i] > target || nums[max] < target) {//最小的大于目标值  或者最大的小于目标值  退出
                break;
            }
            if (min >= max) {//如果两个相遇 则跳出
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//跳过重复
                continue;
            }
            while (min < max) {
                int sum = nums[i] + nums[min] + nums[max];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[min], nums[max]));
                    while (min < max && nums[min] == nums[min + 1]) min++; //跳过重复
                    while (max > min && nums[max] == nums[max - 1]) max--; //跳过重复
                    min++;
                    max--;
                } else if (sum > target) {//如果大于0 说明右边的值太大了
                    max--;
                } else if (sum < target) {//如果小于0 说明左边值太小了
                    min++;
                }
            }
        }

        return result;
    }

}
