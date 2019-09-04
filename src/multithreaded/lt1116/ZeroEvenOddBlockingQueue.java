package multithreaded.lt1116;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.IntConsumer;

/**
 * @ClassName ZeroEvenOddBlockingQueue
 * Description TODO
 * Author cds
 * Date 2019/9/4 15:19
 * Version 1.0
 **/
public class ZeroEvenOddBlockingQueue {
    private  int n;
    private BlockingQueue bqzero;
    private BlockingQueue bqeven;
    private BlockingQueue bqodd;

    public ZeroEvenOddBlockingQueue(int n) {
        this.n = n;
        bqzero= new ArrayBlockingQueue(1);
        bqeven= new ArrayBlockingQueue(1);
        bqodd= new ArrayBlockingQueue(1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {


        for (int i = 1; i <= n; i++) {
            bqzero.put(i);
            printNumber.accept(0);
            if(i%2==0){
                bqeven.put(i);
            }
            if(i%2==1){
                bqodd.put(i);
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
            int x =(int) bqeven.take();
            printNumber.accept(x);
            bqzero.take();
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
            int x =(int)bqodd.take();
            printNumber.accept(x);
            bqzero.take();
        }
    }
}
