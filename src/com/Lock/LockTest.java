package com.Lock;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class LockTest {
    public static  String  obj1="obj1";
    public static String obj2="obj2";
    public static void main(String[] args){  
        LockA la=new LockA();
        new Thread(la).start();
        LockB lb=new LockB();
        new Thread(lb).start();
    }




}
class LockA implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString()+"LockA running");
            while (true){
                synchronized (LockTest.obj1){
                    System.out.println(new Date().toString()+"LockA Lock obj1");
                    Thread.sleep(3000);
                    synchronized (LockTest.obj2){
                        System.out.println(new Date().toString()+"LockA Lock obj2");
                        Thread.sleep(60*1000);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class LockB implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(new Date().toString()+"LockB running");
            while (true){
                synchronized (LockTest.obj1){
                    System.out.println(new Date().toString()+"LockB Lock obj2");
                    Thread.sleep(3000);
                    synchronized (LockTest.obj2){
                        System.out.println(new Date().toString()+"LockB Lock obj1");
                        Thread.sleep(60*1000);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}