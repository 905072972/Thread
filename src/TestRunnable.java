/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class TestRunnable {
    public static void main(String[] args){  
        Runnable1 R1=new Runnable1("thread-1");
        R1.start();
        Runnable1 r2=new Runnable1("thread-2");
        r2.start();
    }
}
