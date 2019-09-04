package multithreaded.lt1114;

/**
 * @ClassName FooCountDownLatch
 * Description  CountDownLatch
 * Author cds
 * Date 2019/9/4 10:49
 * Version 1.0
 **/
public class FooCountDownLatch {



    private java.util.concurrent.CountDownLatch countDownLatch01;
    private java.util.concurrent.CountDownLatch countDownLatch02;

    public FooCountDownLatch() {//初始化为1
        countDownLatch01= new java.util.concurrent.CountDownLatch(1);
        countDownLatch02= new java.util.concurrent.CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch01.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        countDownLatch01.await();//current count 大于0时会等待
        printSecond.run();
        countDownLatch02.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        countDownLatch02.await();
        printThird.run();
    }
}
