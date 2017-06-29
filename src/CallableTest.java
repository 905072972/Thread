import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class CallableTest implements Callable<Integer> {
    public static void main(String[] args) {
        CallableTest ct = new CallableTest();
        FutureTask<Integer> ft = new FutureTask<>(ct);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " i " + i);
            if (i ==20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public Integer call() {
        int i = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
        return i;
    }

}
