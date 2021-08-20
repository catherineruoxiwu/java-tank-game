package com.catwrx.tankgame;

public class Bomb extends BaseGameObject{
    private int life = 120;

    public int getLife() {
        return life;
    }

    public Bomb(int x, int y) {
        super(x,y);
    }

    public void lifeDown() {
        if (life > 0) {
            life--;
        } else {
            isAlive = false;
        }
    }
}
