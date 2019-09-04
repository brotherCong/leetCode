package multithreaded.lt1117;

import multithreaded.lt1114.FooSynchronized;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName lt1117
 * Description TODO
 * Author cds
 * Date 2019/9/4 17:09
 * Version 1.0
 **/
public class lt1117 {

    public static void main(String[] args) {
        String a="HHOOHH";
        print(a);
    }

    public static void print(String a){

        H2O foo= new H2O(a);
        Thread H = new Thread(()->{
            try{
                foo.hydrogen(()->{
                    System.out.println("H");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread O = new Thread(()->{
            try{
                foo.oxygen(()->{
                    System.out.println("O");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        char[] s = a.toCharArray();

        for (int i = 0; i < s.length; i++) {
            if('H'==s[i]) {
                new Thread(()->{
                    try{
                        foo.hydrogen(()->{
                            System.out.print("H");
                        });
                    }catch(InterruptedException e){
                        System.out.println(e.getMessage());
                    }

                }).start();
            }else{
                new Thread(()->{
                    try{
                        foo.oxygen(()->{
                            System.out.print("O");
                        });
                    }catch(InterruptedException e){
                        System.out.println(e.getMessage());
                    }

                }).start();
            }

        }
    }
}
