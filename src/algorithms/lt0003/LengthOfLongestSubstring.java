package algorithms.lt0003;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LengthOfLongestSubstring
 * Description 3. 无重复字符的最长子串
 * Author cds
 * Date 2019/9/20 15:21
 * Version 1.0
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }

    public static void lengthOfLongestSubstring(String s) {

        Map<Character, Integer> m = new HashMap<>();
        int n = s.length();
        int max = 0;
        for (int start = 0, end = 0; start < n; start++) {
            char x = s.charAt(start);
            if (m.containsKey(x)) {//重复字符
                System.out.println(m.get(x)+":"+x+end);
                end = Math.max(m.get(x),end);//获取重复字符的位置+1的位置 获取最大是防止位置回退

            }
            max = Math.max(max, start - end + 1);
            m.put(x, start+1 );//put是为了更新最新一个字符的位置，加一是为了发生重复的时候直接定位到最新一个位置 比如tmmzuxt 第一次重复是m位置为2 ，第二次重复是t位置为1
        }
        System.out.println(max);

    }
}
