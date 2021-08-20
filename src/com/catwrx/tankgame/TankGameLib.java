package com.catwrx.tankgame;

import java.util.Vector;

public class TankGameLib {

    public static Vector<Shot> updateShotVector(Vector<Shot> Shots) {
        Vector<Shot> newVector = new Vector<>();
        for (Shot shot: Shots) {
            if (shot.isAlive()) {
                newVector.add(shot);
            }
        }
        return newVector;
    }

    public static Vector<EnemyTank> updateEnemyTankShotVector(Vector<EnemyTank> Tanks) {
        for (EnemyTank tank: Tanks) {
            if (tank.isAlive()) {
                tank.shots = updateShotVector(tank.shots);
            }
        }
        return Tanks;
    }

}
