package multithreaded.lt1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @ClassName ZeroEvenOdd
 * Description TODO
 * Author cds
 * Date 2019/9/4 13:41
 * Version 1.0
 **/
public class ZeroEvenOddSemaphore {
    private  int n;
    private Semaphore spazero;
    private Semaphore spaeven;
    private Semaphore spaodd;

    public ZeroEvenOddSemaphore(int n) {
        this.n = n;
        spazero= new Semaphore(1);
        spaeven= new Semaphore(0);
        spaodd= new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {


        for (int i = 1; i <= n; i++) {
            spazero.acquire();
            printNumber.accept(0);
            if(i%2==0){
                spaeven.release();
            }
            if(i%2==1){
                spaodd.release();
            }
        }

    }

    /**
     *只输出偶数
     * @param printNumber
    * @return void
     * @author cds
     * @create:
     * @date 2019/9/4 14:45
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            spaeven.acquire();
            printNumber.accept(i);
            spazero.release();
        }
    }

    /**
     *只输出奇数
     * @param printNumber
    * @return void
     * @author cds
     * @create:
     * @date 2019/9/4 14:44
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            spaodd.acquire();
            printNumber.accept(i);
            spazero.release();
        }
    }
}
