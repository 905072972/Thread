/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class Runnable1 implements Runnable {
    private Thread t;
    private String threadName;

    Runnable1(String name) {
        threadName = name;
        System.out.println("create " + threadName);

    }

    public void run() {
        System.out.println("running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread " + threadName + "," + i);
                Thread.sleep(50);
            }


        } catch (Exception e) {
            System.out.println("Thread " + threadName + "interrupt.");

        }
        System.out.println("Thread " + threadName + "存在");
    }

    public void start() {
        System.out.println("starting " + threadName);
        if (t == null) {
            t=new Thread(this,threadName);
            t.start();
        }
    }
}
