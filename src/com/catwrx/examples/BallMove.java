package com.catwrx.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class BallMove extends JFrame {
    BallPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new BallPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class BallPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if (y > 0) y -= 5;
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if (y < 200) y += 5;
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (x > 0) x -= 5;
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (x < 380) x += 5;
        }
        System.out.println("x"+x+"y"+y);
        this.repaint();
    }

    public boolean isvalidArea(int x, int y) {
        return (x > 0 && x < 380 && y > 0 && y < 280);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}