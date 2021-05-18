package com.catwrx.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    PlayerTank player = null;
    Vector<EnemyTank> enemy= new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        player = new PlayerTank(100, 100);
        player.setSpeed(10);
        for (int i = 0; i < enemyTankSize; i++){
            EnemyTank enemyTank = new EnemyTank(100*(i+1), 0);
            enemyTank.setDirection(i);
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemy.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 1000, 750);
        drawTank(player.getX(), player.getY(), g, player.getDirection(), 0);
        if (player.shot != null && player.shot.isAlive()) {
            g.drawOval(player.shot.getX() - 3, player.shot.getY() - 3, 6, 6);
        }
        for (int i = 0; i < enemyTankSize; i++){
            EnemyTank enemyTank = enemy.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 1);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot.isAlive()){
                    g.drawOval(shot.getX() - 3, shot.getY() - 3, 6, 6);
                } else {
                    enemyTank.shots.remove(shot);
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
