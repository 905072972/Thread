/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class Thread1 extends Thread{
    private Thread t;
    private String threadName;
    Thread1(String name){
        threadName=name;
        System.out.println("创建"+threadName);
    }
    public void run(){
        System.out.println("running "+threadName);
        try {
            for(int i=4;i>0;i--){
                System.out.println("thread "+threadName+","+i);
                Thread.sleep(50);
            }

        }catch (InterruptedException e){
            System.out.println("exception "+threadName);

        }
        System.out.println("thread "+"exiting ");

    }
    public void start(){
        System.out.println("starting "+threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }


    }

}
