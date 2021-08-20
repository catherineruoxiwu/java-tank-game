package com.catwrx.tankgame;

import java.util.Vector;

public class PlayerTank extends Tank {

    Shot shot = null;
    Vector<Shot> shots = new Vector<>();
    int maxShot = 50;

    public PlayerTank(int x, int y) {
        super(x,y);
    }

    public void shotEnemyTank() {
        if (shots.size() >= maxShot)  {
            return;
        }
        switch (getDirection()) {
            case 0 -> shot = new Shot(getX() + 20, getY(), 0);
            case 1 -> shot = new Shot(getX() + 60, getY() + 20, 1);
            case 2 -> shot = new Shot(getX() + 20, getY() + 60, 2);
            case 3 -> shot = new Shot(getX(), getY() + 20, 3);
        }

        shots.add(shot);
        new Thread(shot).start();
    }
}
