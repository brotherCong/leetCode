package lt1114;

import java.util.concurrent.Semaphore;

/**
 * @ClassName Foo
 * Description TODO
 * Author cds
 * Date 2019/9/4 10:09
 * Version 1.0
 **/
public class Foo {

        private Semaphore semaphore01;
        private Semaphore semaphore02;

        public Foo() {
            semaphore01= new Semaphore(0);
            semaphore02= new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore01.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            semaphore01.acquire();
            printSecond.run();
            semaphore02.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            semaphore01.acquire();
            printThird.run();
        }
}
