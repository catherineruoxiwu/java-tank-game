package com.catwrx.tankgame;

import javax.swing.*;

public class Game extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        Game game01 = new Game();
    }

    public Game() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
