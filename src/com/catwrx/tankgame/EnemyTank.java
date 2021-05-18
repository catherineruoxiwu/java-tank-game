package com.catwrx.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank {

    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
