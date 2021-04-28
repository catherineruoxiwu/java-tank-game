package com.catwrx.examples;

import javax.swing.*;
import java.awt.*;


public class DrawCircle extends JFrame{
    private MyPanel mp = null;
    public static void main (String[] args){
        new DrawCircle();
    }

    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}


class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }
}