package com.Evan;

import javax.swing.JFrame;

class SnakeGame extends JFrame{

    SnakeGame(){

        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null); //this will take the frame into the middle

    }
}
