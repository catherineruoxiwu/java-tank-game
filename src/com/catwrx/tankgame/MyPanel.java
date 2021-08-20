package com.catwrx.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


public class MyPanel extends JPanel implements KeyListener, Runnable {
    PlayerTank player = null;
    Vector<EnemyTank> enemy = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Image image1, image2, image3;
    int initEnemyTankSize = 3;

    public MyPanel() {
        player = new PlayerTank(100, 100);
        player.setSpeed(4);
        for (int i = 0; i < initEnemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(i);
            enemyTank.setSpeed(4);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemy.add(enemyTank);
        }
        image1 = Toolkit.getDefaultToolkit().getImage("res/1.gif");
        image2 = Toolkit.getDefaultToolkit().getImage("res/2.gif");
        image3 = Toolkit.getDefaultToolkit().getImage("res/3.gif");
        MediaTracker t = new MediaTracker(this);
        t.addImage(image1, 0);
        t.addImage(image2, 0);
        t.addImage(image3, 0);
        try {
            t.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 1000, 750);
        if (player != null && player.isAlive()) {
            drawTank(player.getX(), player.getY(), g, player.getDirection(), 0);
        }
//        if (player.shot != null && player.shot.isAlive()) {
//            g.drawOval(player.shot.getX() - 3, player.shot.getY() - 3, 6, 6);
//        }
        for (int i = 0; i < player.shots.size(); i++) {
            Shot shot = player.shots.get(i);
            if (shot != null && shot.isAlive()) {
                g.drawOval(shot.getX() - 3, shot.getY() - 3, 6, 6);
            } else {
                assert shot != null;
                shot.setAlive(false);
            }
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (!bomb.isAlive()) {
                continue;
            }
            if (bomb.getLife() > 80) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 40) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.lifeDown();
        }
        for (int i = 0; i < enemy.size(); i++){
            EnemyTank enemyTank = enemy.get(i);
            if (enemyTank.isAlive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isAlive()){
                        g.drawOval(shot.getX() - 3, shot.getY() - 3, 6, 6);
                    } else {
                        shot.setAlive(false);
                    }
                }
            }
        }
    }

    /**
     *
     * @param x x-coordinate of the tank's left-upper corner
     * @param y y-coordinate of the tank's left-upper corner
     * @param g Graphics instance for painting and repainting tanks
     * @param direction Up(0)/right(1)/down(2)/left(3)
     * @param type Used to differentiate PlayerTank(0) and EnemyTank(1)
     */
    public void drawTank (int x, int y, Graphics g, int direction, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch (direction) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
            default:
                g.fill3DRect(x, y, 10, 60, false);
                break;
        }
    }

    public void hitTank(Shot s, Tank tank) {
        if (!tank.isAlive()) {
            return;
        }
        switch (tank.getDirection()) {
            case 0:
            case 2:
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 40
                        && s.getY() > tank.getY() && s.getY() < tank.getY() + 60) {
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    tank.setAlive(false);
                    s.setAlive(false);
                };
                break;
            case 1:
            case 3:
                if (s.getX() > tank.getX() && s.getX() < tank.getX() + 60
                        && s.getY() > tank.getY() && s.getY() < tank.getY() + 40) {
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                    tank.setAlive(false);
                    s.setAlive(false);
                };
                break;
            default:
                break;
        }
    }

    public void hitEnemyTank() {
        for (int i = 0; i < player.shots.size(); i++) {
            Shot shot = player.shots.get(i);
            if (shot != null &&  shot.isAlive()) {
                for (int j = 0; j < enemy.size(); j++) {
                    EnemyTank enemyTank = enemy.get(j);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }

    public void hitPlayerTank() {
        if (!player.isAlive()) {
            return;
        }
        for (int i = 0; i < enemy.size(); i++) {
            EnemyTank enemyTank = enemy.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (player.isAlive() && shot.isAlive()) {
                    hitTank(shot, player);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            player.setDirection(0);
            player.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            player.setDirection(1);
            player.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            player.setDirection(2);
            player.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            player.setDirection(3);
            player.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J){
            player.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();
            hitPlayerTank();
            enemy = TankGameLib.updateEnemyTankShotVector(enemy);
            player = TankGameLib.updatePlayerTankShotVector(player);
            this.repaint();
        }
    }
}
