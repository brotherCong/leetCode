package multithreaded.lt1114;

/**
 * @ClassName FooSynchnorize
 * Description TODO
 * Author cds
 * Date 2019/9/4 11:09
 * Version 1.0
 **/
public class FooSynchronized {

    private boolean one;
    private boolean two;
    private Object lock = new Object();

    public FooSynchronized() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            printFirst.run();
            one = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (!one) {
                lock.wait();
            }
            printSecond.run();
            two = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (!two) {
                lock.wait();
            }
            printThird.run();
        }

    }
}
