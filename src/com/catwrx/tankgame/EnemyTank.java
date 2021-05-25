package com.catwrx.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank {

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
}
