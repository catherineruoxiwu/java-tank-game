// Tutorials followed: https://www.bilibili.com/video/BV1Ay4y1t7hz

package com.catwrx.tankgame;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game game01 = new Game();
    }

    public Game() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
