package com.com;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        new ThreadTest2().init();
    }

    public void init() {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.SubThread(i);
                }
            }
        }).start();
        for (int i = 0; i < 50; i++) {
            business.MainThread(i);
        }


    }

    private class Business {
        boolean bShouldSub = true;

        public synchronized void MainThread(int i) {
            if (bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "i=" + i + ",j=" + j);
                }
                bShouldSub = true;
                this.notify();
            }
        }


        public synchronized void SubThread(int i) {
            if (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + "i=" + i + ",j=" + j);
                }
                bShouldSub = false;
                this.notify();
            }

        }

    }
}


