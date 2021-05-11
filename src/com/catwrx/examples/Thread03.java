package com.catwrx.examples;

public class Thread03 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        T4 t4 = new T4();
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);
        thread3.start();
        thread4.start();
    }
}

class T3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            System.out.println("HelloHello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class T4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 4; i++){
            System.out.println("Hellooooo");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}