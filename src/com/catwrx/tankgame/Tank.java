package com.catwrx.tankgame;

public class Tank extends BaseGameObject {

    public Tank(int x, int y) {
        super(x, y);
    }

    public void moveUp(){
        if (getY() > 0) {
            y -= speed;
        }
    }

    public void moveDown(){
        if (getY() + 60 < 720) {
            y += speed;
        }
    }

    public void moveLeft(){
        if (getX() > 0) {
            x -= speed;
        }
    }

    public void moveRight(){
        if (getX() + 60 < 1000){
            x += speed;
        }
    }

    public void moveUp(int times) {
        for (int i = 0; i < times; i++) {
            moveUp();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveDown(int times) {
        for (int i = 0; i < times; i++) {
            moveDown();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveLeft(int times){
        for (int i = 0; i < times; i++) {
            moveLeft();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveRight(int times){
        for (int i = 0; i < times; i++) {
            moveRight();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
