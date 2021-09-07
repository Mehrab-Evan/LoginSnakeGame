package com.Evan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PlayGameClass extends JFrame implements ActionListener {

    Runtime mehrab = Runtime.getRuntime();

    JLabel game1 = new JLabel();
    JLabel game2 = new JLabel();
    JLabel chrome = new JLabel();

    JButton g1 = new JButton();
    JButton g2 = new JButton();
    JButton cB = new JButton();

    PlayGameClass()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(null);
        this.setTitle("YOUR CHOICE");

        game1.setText("Red Dead Redemption");
        game1.setBounds(60,100,200,30);
        this.add(game1);

        game2.setText("WatchDOgs 2");
        game2.setBounds(60,200,200,30);
        this.add(game2);

        chrome.setText("Google");
        chrome.setBounds(60,300,200,30);
        this.add(chrome);


        g1.setText("RDR2");
        g1.setBounds(200,100,100,30);
        this.add(g1);
        g1.addActionListener(this);

        g2.setText("Watchdogs2");
        g2.setBounds(200,200,100, 30);
        this.add(g2);
        g2.addActionListener(this);

        cB.setText("Google");
        cB.setBounds(200,300,120,30);
        this.add(cB);
        cB.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == g1)
        {
            try {
                mehrab.exec("D:\\Games 1\\Red Dead Redemption 2\\RDR2.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.dispose();
        }
        else if(actionEvent.getSource() == g2)
        {
            try {
                mehrab.exec("E:\\Games 2\\Watch Dogs 2\\bin\\WatchDogs2.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.dispose();
        }
        else if(actionEvent.getSource() == cB)
        {
            try {
                mehrab.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.dispose();
        }
    }
}

