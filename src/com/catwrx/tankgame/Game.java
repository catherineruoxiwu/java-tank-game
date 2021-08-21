package com.catwrx.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Game extends JFrame {
    MainPanel mp = null;
    public static void main(String[] args) {
        Game game = new Game();
    }

    // TODO: adding welcome page
    public Game() {
        try {
            TankGameLib.initGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp = new MainPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1500, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    TankGameLib.keepGameRecord(false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });
    }
}
