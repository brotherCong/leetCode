package lt1114;

/**
 * @ClassName FooSynchnorize
 * Description TODO
 * Author cds
 * Date 2019/9/4 11:09
 * Version 1.0
 **/
public class FooSynchnorize {

    public FooSynchnorize() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
