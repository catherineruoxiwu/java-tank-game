package com.catwrx.tankgame;

public class Shot extends BaseGameObject implements Runnable {

    public Shot(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
        this.speed = 2;
        this.isAlive = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction) {
                case 0 -> y -= speed;
                case 1 -> x += speed;
                case 2 -> y += speed;
                case 3 -> x -= speed;
            }

            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750)) {
                isAlive = false;
                break;
            }
        }

    }
}
