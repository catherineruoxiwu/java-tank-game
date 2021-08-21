package com.catwrx.tankgame;

import java.util.Vector;

public class Tank extends BaseGameObject {

    public Tank(int x, int y) {
        super(x, y);
    }

    Vector<Tank> allTanks = new Vector<>();
    
    // All other tanks are "enemyTanks"
    public void setAllTanks(Vector<Tank> allTanks) {
        this.allTanks = allTanks;
    }

    // Make sure that the tanks do not overlap
    public boolean isNotOverlapped() {
        switch(getDirection()) {
            case 0:
                for (Tank tank : allTanks) {
                    if (this == tank || !tank.isAlive()) {
                        continue;
                    }
                    if (tank.getDirection() == 0 || tank.getDirection() == 2) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 40
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 40 >= tank.getX() && this.getX() + 40 <= tank.getX() + 40
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 60) {
                            return false;
                        }
                    }
                    if (tank.getDirection() == 1 || tank.getDirection() == 3) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 60
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 40) {
                            return false;
                        }
                        if (this.getX() + 40 >= tank.getX() && this.getX() + 40 <= tank.getX() + 60
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 1:
                for (Tank tank : allTanks) {
                    if (this == tank || !tank.isAlive()) {
                        continue;
                    }
                    if (tank.getDirection() == 0 || tank.getDirection() == 2) {
                        if (this.getX() >= tank.getX() + 60 && this.getX() + 60 <= tank.getX() + 40
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 60 >= tank.getX() && this.getX() + 60 <= tank.getX() + 40
                                && this.getY() + 40 >= tank.getY() && this.getY() + 40 <= tank.getY() + 60) {
                            return false;
                        }
                    }
                    if (tank.getDirection() == 1 || tank.getDirection() == 3) {
                        if (this.getX() + 60 >= tank.getX() && this.getX() + 60 <= tank.getX() + 60
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 40) {
                            return false;
                        }
                        if (this.getX() + 60 >= tank.getX() && this.getX() + 60 <= tank.getX() + 60
                                && this.getY() + 40 >= tank.getY() && this.getY() + 40 <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 2:
                for (Tank tank : allTanks) {
                    if (this == tank || !tank.isAlive()) {
                        continue;
                    }
                    if (tank.getDirection() == 0 || tank.getDirection() == 2) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 40
                                && this.getY() + 60 >= tank.getY() && this.getY() + 60 <= tank.getY() + 60) {
                            return false;
                        }
                        if (this.getX() + 40 >= tank.getX() && this.getX() + 40 <= tank.getX() + 40
                                && this.getY() + 60 >= tank.getY() && this.getY() + 60 <= tank.getY() + 60) {
                            return false;
                        }
                    }
                    if (tank.getDirection() == 1 || tank.getDirection() == 3) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 60
                                && this.getY() + 60 >= tank.getY() && this.getY() + 60 <= tank.getY() + 40) {
                            return false;
                        }
                        if (this.getX() + 40 >= tank.getX() && this.getX() + 40 <= tank.getX() + 60
                                && this.getY() + 60 >= tank.getY() && this.getY() + 60 <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
            case 3:
                for (Tank tank : allTanks) {
                    if (this == tank || !tank.isAlive()) {
                        continue;
                    }
                    if (tank.getDirection() == 0 || tank.getDirection() == 2) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 40
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 60) {
                            return false;
                        }
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 40
                                && this.getY() + 40 >= tank.getY() && this.getY() + 40 <= tank.getY() + 60) {
                            return false;
                        }
                    }
                    if (tank.getDirection() == 1 || tank.getDirection() == 3) {
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 60
                                && this.getY() >= tank.getY() && this.getY() <= tank.getY() + 40) {
                            return false;
                        }
                        if (this.getX() >= tank.getX() && this.getX() <= tank.getX() + 60
                                && this.getY() + 40 >= tank.getY() && this.getY() + 40 <= tank.getY() + 40) {
                            return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

    public void moveUp(){
        if (getY() > 0 && isNotOverlapped()) {
            y -= speed;
        }
    }

    public void moveDown(){
        if (getY() + 60 < 720 && isNotOverlapped()) {
            y += speed;
        }
    }

    public void moveLeft(){
        if (getX() > 0 && isNotOverlapped()) {
            x -= speed;
        }
    }

    public void moveRight(){
        if (getX() + 60 < 1000 && isNotOverlapped()){
            x += speed;
        }
    }

    public void moveUp(int times) {
        for (int i = 0; i < times; i++) {
            moveUp();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveDown(int times) {
        for (int i = 0; i < times; i++) {
            moveDown();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void moveLeft(int times){
        for (int i = 0; i < times; i++) {
            moveLeft();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void moveRight(int times){
        for (int i = 0; i < times; i++) {
            moveRight();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
