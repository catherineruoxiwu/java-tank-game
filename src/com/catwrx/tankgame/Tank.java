package com.catwrx.tankgame;

public class Tank {
    private int x;
    private int y;
    private int direction;    // Up(0) Right(1) Down(2) Left(3)
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
