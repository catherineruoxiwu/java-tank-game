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
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        shots.add(shot);
        new Thread(shot).start();
    }
}
