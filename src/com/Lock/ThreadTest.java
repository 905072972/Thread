package com.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class ThreadTest {
    private int j;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        for (int i = 0; i < 2; i++) {
            new Thread(tt.new Adder()).start();
            new Thread(tt.new subtractor()).start();
        }
    }

    private class Adder implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println("j++=" + j++);
                }finally {
                    lock.unlock();
                }
            }


        }
    }
    private  class subtractor implements  Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    System.out.println("j--="+j--);
                }finally {
                    lock.unlock();
                }
            }
        }
    }


}