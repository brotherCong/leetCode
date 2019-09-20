package jdk;

import com.sun.glass.ui.Pixels;

import java.text.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName HashMapTest
 * Description TODO
 * Author cds
 * Date 2019/9/17 9:33
 * Version 1.0
 **/
public class HashMapTest {

    public static final int   MAX_VALUE = 0x7fffffff;

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("1","张三");
        map.put("2","李四");
        map.put("3","王五");
        System.out.println(map.get("2"));

        ConcurrentHashMap<String,String> cmap= new ConcurrentHashMap<>();
        cmap.put("A","Tom");
        cmap.put("B","Jack");
        cmap.put("C","John");
        System.out.println(cmap.get("B"));

        System.out.println(false^false);

        System.out.println(MAX_VALUE);
        Double i =Math.pow(2,31)-1;
        Format format = new DecimalFormat();
        System.out.println(((DecimalFormat) format).format(i));
        System.out.println( 1 << 30);
    }

}
