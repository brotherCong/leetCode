package lt1115;

import java.util.concurrent.Semaphore;

/**
 * @ClassName FooBar
 * Description TODO
 * Author cds
 * Date 2019/9/4 11:28
 * Version 1.0
 **/
public class FooBar {

    private int n;
    private Semaphore semaphore01;
    private Semaphore semaphore02;

    public FooBar(int n) {
        this.n = n;
        semaphore01 = new Semaphore(1);
        semaphore02 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphore01.acquire();
            printFoo.run();
            semaphore02.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphore02.acquire();
            printBar.run();
            semaphore01.release();
        }
    }
}
