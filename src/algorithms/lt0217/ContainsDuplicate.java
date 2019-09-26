package algorithms.lt0217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ContainsDuplicate
 * Description TODO
 * Author cds
 * Date 2019/9/26 14:42
 * Version 1.0
 **/
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        boolean flag = false;
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                flag = true;
                break;
            } else {
                m.put(nums[i], 1);
            }
        }
        return flag;
    }

    public boolean containsDuplicateSet(int[] nums) {

        Set<Integer> m = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (m.contains(nums[i])) {
                return  true;
            }
            m.add(nums[i]);

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        ContainsDuplicate cd = new ContainsDuplicate();
        cd.containsDuplicate(nums);
        cd.containsDuplicateSet(nums);
    }
}
