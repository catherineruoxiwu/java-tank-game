package com.catwrx.tankgame;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    PlayerTank player = null;
    public MyPanel() {
        player = new PlayerTank(1000, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(player.getX(), player.getY(), g, 0, 0);
    }

    /**
     *
     * @param x x-coordinate of the tank's left-upper corner
     * @param y y-coordinate of the tank's left-upper corner
     * @param g Graphics instance for painting tanks
     * @param direction Up(0)/down(1)/left(2)/right(3)
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
                System.out.println("lllll");
                break;
            default:
                g.fill3DRect(x, y, 10, 60, false);
                break;
        }
    }

}
