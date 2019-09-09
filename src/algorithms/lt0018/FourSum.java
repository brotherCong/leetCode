package algorithms.lt0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FourSum
 * Description TODO
 * Author cds
 * Date 2019/9/9 11:20
 * Version 1.0
 **/
public class FourSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        Arrays.sort(nums);//数组排序
        int target = 0;
        List<List<Integer>> list = fourSum(nums, target);
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length <= 3) {//如果数组为空或者长度小于4则直接返回
            return result;
        }


        for (int i = 0; i < nums.length-3; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            List<List<Integer>> resulttmp = new ArrayList();
            resulttmp = threeSum(nums, target-nums[i],i+1);
            if (resulttmp != null && resulttmp.size() > 0) {
                for (List<Integer> t:resulttmp) {
                    t.add(nums[i]);
                    result.add(t);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums, int target,int m) {
        List<List<Integer>> result = new ArrayList();

        if (nums == null || nums.length <= 2) {//如果数组为空或者长度小于3则直接返回
            return result;
        }

        for (int i = m; i < nums.length - 2; i++) {//循环数组 这里不能到-3  -3会导致000不走
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
//                    result.add(Arrays.asList(nums[i], nums[min], nums[max]));
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[min]);
                    list.add(nums[max]);
                    result.add(list);
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
