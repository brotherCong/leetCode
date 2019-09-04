package multithreaded.lt1114;

/**
 * @ClassName Foo
 * Description TODO
 * Author cds
 * Date 2019/9/4 10:09
 * Version 1.0
 **/
public class FooSemaphore {

        private java.util.concurrent.Semaphore semaphore01;
        private java.util.concurrent.Semaphore semaphore02;

        public FooSemaphore() {
            semaphore01= new java.util.concurrent.Semaphore(0);
            semaphore02= new java.util.concurrent.Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore01.release();//释放一个凭证
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            semaphore01.acquire();//占用一个凭证
            printSecond.run();
            semaphore02.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            semaphore02.acquire();
            printThird.run();
        }
}
