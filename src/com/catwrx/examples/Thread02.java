package com.catwrx.examples;

public class Thread02 {
    public static void main(String[] args) {
        T2 dog = new T2();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class T2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("woooooof");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}