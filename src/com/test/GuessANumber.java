package com.test;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class GuessANumber extends Thread {
    private int number;

    public GuessANumber(int number) {
        this.number = number;

    }

    @Override
    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess= (int) (Math.random()*10+1);
            System.out.println(this.getName()+"guess "+guess);
            counter++;
        }while (guess!=number);
        System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");

    }
}
