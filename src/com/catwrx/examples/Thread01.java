package com.catwrx.examples;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        T1 news = new T1();
        news.start();
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("main: " + i);
            Thread.sleep(1000);
        }
    }
}

class T1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("LOLOL");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
