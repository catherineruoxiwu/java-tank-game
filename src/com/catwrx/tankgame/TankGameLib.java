package com.catwrx.tankgame;

import java.util.Vector;

public class TankGameLib {

    private static Vector<Shot> updateShotVector(Vector<Shot> Shots) {
        Vector<Shot> newVector = new Vector<>();
        for (Shot shot: Shots) {
            if (shot.isAlive()) {
                newVector.add(shot);
            }
        }
        return newVector;
    }

    public static PlayerTank updatePlayerTankShotVector(PlayerTank player) {
        if (player.isAlive()) {
            player.shots = updateShotVector(player.shots);
        } else {
            player.shots = new Vector<>();
        }
        return player;
    }

    public static Vector<EnemyTank> updateEnemyTankShotVector(Vector<EnemyTank> Tanks) {
        for (EnemyTank tank: Tanks) {
            if (tank.isAlive()) {
                tank.shots = updateShotVector(tank.shots);
            } else {
                tank.shots = new Vector<>();
            }
        }
        return Tanks;
    }

}
