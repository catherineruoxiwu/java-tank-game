package com.catwrx.tankgame;

import java.io.*;
import java.util.Vector;

public class TankGameLib {

    public final static int tankNum = 5;
    private static int deadEnemyTankNum = 0;
    private static FileWriter fw = null;
    private static FileReader fr = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private final static String storeInfo = "TankGameRecord.txt";

    public static int getDeadEnemyTankNum() {
        return deadEnemyTankNum;
    }

    public static void setDeadEnemyTankNum(int deadEnemyTankNum) {
        TankGameLib.deadEnemyTankNum = deadEnemyTankNum;
    }

    public static void addDeadEnemyTankNum() {
        TankGameLib.deadEnemyTankNum++;
    }

    public static void initGame() throws IOException {
        if (deadEnemyTankNum == tankNum) {
            deadEnemyTankNum = 0;
        }
        br = new BufferedReader(new FileReader(storeInfo));
        setDeadEnemyTankNum(Integer.parseInt(br.readLine()));
    }

    // TODO: smoother quitting
    public static void keepGameRecord(boolean isPlayerDead) throws IOException {
        if (deadEnemyTankNum == tankNum || isPlayerDead) {
            deadEnemyTankNum = 0;
        }
        bw = new BufferedWriter(new FileWriter(storeInfo));
        bw.write(deadEnemyTankNum + "\r\n");
        if (bw != null) {
            bw.close();
        }
        System.exit(0);
    }

    private static Vector<Shot> updateShotVector(Vector<Shot> Shots) {
        Vector<Shot> newVector = new Vector<>();
        for (Shot shot: Shots) {
            if (shot != null && shot.isAlive()) {
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
