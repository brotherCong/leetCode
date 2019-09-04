package multithreaded.lt1114;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName lt1114
 * Description TODO
 * Author cds
 * Date 2019/9/4 10:10
 * Version 1.0
 **/
public class lt1114 {

    public static void main(String[] args) {
        int[] a= new int[]{2,3,1};
        print(a);
    }

    public static void print(int[] a){


//        FooSemaphore foo = new FooSemaphore();
//        FooCountDownLatch foo = new FooCountDownLatch();
        FooSynchronized foo= new FooSynchronized();

        Thread first = new Thread(()->{
            try{
                foo.first(()->{
                    System.out.println("one");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread second = new Thread(()->{
            try{
                foo.second(()->{
                    System.out.println("two");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread third = new Thread(()->{
            try{
                foo.third(()->{
                    System.out.println("three");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

       Map<Integer,Thread> m = new HashMap();
       m.put(1,first);
       m.put(2,second);
       m.put(3,third);

        Arrays.stream(a).forEach(num ->{
            m.get(num).start();
        });


    }

}
