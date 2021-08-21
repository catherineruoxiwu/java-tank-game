package com.catwrx.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    int maxShot = 3;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        do {
            int times = (int) (Math.random() * 20) + 30;
            setDirection((int) (Math.random() * 4));
            if ((int)Math.round(Math.random()) == 1 && isAlive() && shots.size() < maxShot) {
                switch (getDirection()) {
                    case 0 -> shot = new Shot(getX() + 20, getY(), 0);
                    case 1 -> shot = new Shot(getX() + 60, getY() + 20, 1);
                    case 2 -> shot = new Shot(getX() + 20, getY() + 60, 2);
                    case 3 -> shot = new Shot(getX(), getY() + 20, 3);
                }
                shots.add(shot);
                new Thread(shot).start();
            }
            switch (getDirection()) {
                case 0 -> moveUp(times);
                case 1 -> moveRight(times);
                case 2 -> moveDown(times);
                case 3 -> moveLeft(times);
            }
        } while (isAlive());
    }
}
