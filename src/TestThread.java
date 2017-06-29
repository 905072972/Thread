/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class TestThread {
    public static void main(String[] args){
        Thread1 t1=new Thread1("thread-1");
        t1.start();
//        new Thread(t1).start();
//        new Thread(t1).start();
        Thread1 t2=new Thread1("thread-2");
        t2.start();
    }
}
