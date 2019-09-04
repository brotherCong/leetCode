package multithreaded.lt1116;

/**
 * @ClassName lt1116
 * Description TODO
 * Author cds
 * Date 2019/9/4 13:50
 * Version 1.0
 **/
public class lt1116 {

    public static void main(String[] args) {
        int a = 6;
        print(a);
    }

    public static void print(int a){


//        FooSemaphore foo = new FooSemaphore();
//        FooCountDownLatch foo = new FooCountDownLatch();
//        ZeroEvenOddSemaphore foo= new ZeroEvenOddSemaphore(a);
        ZeroEvenOddBlockingQueue foo= new ZeroEvenOddBlockingQueue(a);
        Thread zero = new Thread(()->{
            try{
                foo.zero((x)->{
                    System.out.print(x);
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread even = new Thread(()->{
            try{
                foo.even((x)->{
                    System.out.println(x);
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread odd = new Thread(()->{
            try{
                foo.odd((x)->{
                    System.out.println(x);
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        zero.start();
        even.start();
        odd.start();

    }
}
