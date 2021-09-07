package com.Evan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Profile extends JFrame implements ActionListener {


    //Runtime Class
    Runtime forRun = Runtime.getRuntime();
    //Declaration of All JLabel--------------------------
    JLabel FirstName = new JLabel();
    JLabel LastName = new JLabel();
    JLabel UserName = new JLabel();
    JLabel PassWord = new JLabel();
    JLabel ConfirmPassword = new JLabel();
    JLabel ErrorOfSamePassWord = new JLabel();
    JLabel playgame = new JLabel();

    //Declaration of All JLABEL FROM FILES----------------------
    JLabel FN = new JLabel();
    JLabel LN = new JLabel();
    JLabel UN = new JLabel();
    JLabel PW = new JLabel();
    JLabel CP = new JLabel();
    JLabel Welcome = new JLabel();

    JButton OpenSnakeGame = new JButton();
    JButton Back = new JButton();
    JButton Google = new JButton();

    Profile() throws FileNotFoundException {
        //FRAME
        this.setTitle("Welcome TO your Profile");
        this.setSize(500, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //========LABELS=============================================//
        Welcome.setText("Welcome");
        Welcome.setBounds(50,50,100,30);
        this.add(Welcome);

        //FirstName---------------------------------------
        FirstName.setBounds(50, 100, 100, 30);
        FirstName.setText("First Name");
        this.add(FirstName);

        //LastName----------------------------------------
        LastName.setBounds(50, 150, 100, 30);
        LastName.setText("Last Name");
        this.add(LastName);

        //UserName----------------------------------------
        UserName.setBounds(50, 200, 100, 30);
        UserName.setText("UserName");
        this.add(UserName);


        //============LABELFINISHED=================DESIGN==================//

        //Read From File;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        File Show = new File("E:/JavaIntelligi/LogIn1/Profile.txt");
        Scanner input = new Scanner(Show); // will take input from the file which is declared as show

        while (input.hasNext())
        {
            String First_Name = input.next();
            String Last_Name = input.next();
            String User_Name = input.next();
            FN.setText(First_Name);
            LN.setText(Last_Name);
            UN.setText(User_Name);
        }
        //============TXTFIELD START==============DESIGN======================//
        FN.setBounds(150, 100, 200, 30);
        this.add(FN);

        LN.setBounds(150, 150, 200, 30);
        this.add(LN);

        UN.setBounds(150, 200, 200, 30);
        this.add(UN);

        //===============TXTFIELD DONE ===================================//

        //============BUTTON=============================================//
        /*Confirm.setText("Confirm");
        Confirm.setBounds(100, 700, 80, 40);
        Confirm.addActionListener(this);
        this.add(Confirm);*/

        Back.setText("Back");
        Back.setBounds(350, 500, 100, 40);
        Back.addActionListener(this);
        Back.setFocusable(false);
        this.add(Back);

        OpenSnakeGame.setText("SnakePro");
        OpenSnakeGame.setFocusable(false);
        OpenSnakeGame.setBounds(40,500,100,40);
        OpenSnakeGame.addActionListener(this);
        this.add(OpenSnakeGame);

        Google.setText("Google");
        Google.setFocusable(false);
        Google.setBounds(190,500,100,40);
        Google.addActionListener(this);
        this.add(Google);

        //==============Button Design End===============================//
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == Back)
        {
            new LoginPage();
            this.dispose();
        }
        if(actionEvent.getSource() == OpenSnakeGame)
        {
            new SnakeGame();
            this.dispose();
        }
        if(actionEvent.getSource() == Google)
        {
            try {
                forRun.exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.dispose();
        }
    }
}