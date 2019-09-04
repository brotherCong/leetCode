package multithreaded.lt1115;

/**
 * @ClassName lt1115
 * Description TODO
 * Author cds
 * Date 2019/9/4 11:33
 * Version 1.0
 **/
public class lt1115 {
    public static void main(String[] args) {
        int a = 6;
        print(a);
    }

    public static void print(int a){


//        FooSemaphore foo = new FooSemaphore();
//        FooCountDownLatch foo = new FooCountDownLatch();
        FooBarSemaphore foo= new FooBarSemaphore(a);

        Thread first = new Thread(()->{
            try{
                foo.foo(()->{
                    System.out.print("foo");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        Thread second = new Thread(()->{
            try{
                foo.bar(()->{
                    System.out.println("bar");
                });
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

        });

        first.start();
        second.start();




    }
}
