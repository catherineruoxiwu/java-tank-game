package com.catwrx.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{

    Vector<Shot> shots = new Vector<>();

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private boolean isAlive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        do {
            int times = (int) (Math.random() * 20) + 30;
            switch (getDirection()) {
                case 0 -> moveUp(times);
                case 1 -> moveRight(times);
                case 2 -> moveDown(times);
                case 3 -> moveLeft(times);
            }
            setDirection((int) (Math.random() * 4));
        } while (isAlive());
    }
}
