package com.Evan;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculato9r extends JFrame implements ActionListener {
    JButton one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, div, mul, equal, reset;
    JLabel display, display2; // took a label for display named display
    Calculato9r()
    {
        display = new JLabel();// innitialize
        display.setSize(300, 200); // lebel size
        display2 = new JLabel();
        display2.setSize(300,200);
        this.setTitle("Mevan Calculator");
        /*this.setBackground(Color.pink);
        this.setForeground(Color.pink);*/

        this.setVisible(true);
        reset = new JButton();
        reset.setText("AC");
        reset.setBackground(Color.red);
        reset.setForeground(Color.yellow);
        reset.setBounds(400, 260, 80, 40);
        reset.addActionListener(this);
        equal = new JButton();
        equal.setText("=");
        equal.setBackground(Color.red);
        equal.setForeground(Color.yellow);
        equal.setBounds(220, 300, 80, 40);
        equal.addActionListener(this);
        one = new JButton();
        one.setText("1");
        one.setBackground(Color.red);
        one.setForeground(Color.yellow);
        one.setBounds(30, 40, 80, 40);
        one.addActionListener(this);
        two = new JButton();
        two.setText("2");
        two.setBackground(Color.red);
        two.setForeground(Color.yellow);
        two.setBounds(130, 40, 80, 40);
        two.addActionListener(this);
        three = new JButton();
        three.setText("3");
        three.setBackground(Color.red);
        three.setForeground(Color.yellow);
        three.setBounds(230, 40, 80, 40);
        three.addActionListener(this);
        four = new JButton();
        four.setText("4");
        four.setBackground(Color.red);
        four.setForeground(Color.yellow);
        four.setBounds(30, 100, 80, 40);
        four.addActionListener(this);
        five = new JButton();
        five.setText("5");
        five.setBackground(Color.red);
        five.setForeground(Color.yellow);
        five.setBounds(130, 100, 80, 40);
        five.addActionListener(this);
        six = new JButton();
        six.setText("6");
        six.setBackground(Color.red);
        six.setForeground(Color.yellow);
        six.setBounds(230, 100, 80, 40);
        six.addActionListener(this);
        seven = new JButton();
        seven.setText("7");
        seven.setBackground(Color.red);
        seven.setForeground(Color.yellow);
        seven.setBounds(30, 160, 80, 40);
        seven.addActionListener(this);
        eight = new JButton();
        eight.setText("8");
        eight.setBackground(Color.red);
        eight.setForeground(Color.yellow);
        eight.setBounds(130, 160, 80, 40);
        eight.addActionListener(this);
        nine = new JButton();
        nine.setText("9");
        nine.setBackground(Color.red);
        nine.setForeground(Color.yellow);
        nine.setBounds(230, 160, 80, 40);
        nine.addActionListener(this);
        zero = new JButton();
        zero.setText("0");
        zero.setBackground(Color.red);
        zero.setForeground(Color.yellow);
        zero.setBounds(130, 220, 80, 40);
        zero.addActionListener(this);
        plus = new JButton();
        plus.setText("+");
        plus.setBackground(Color.red);
        plus.setForeground(Color.yellow);
        plus.setBounds(400, 40, 80, 40);
        plus.addActionListener(this);
        minus = new JButton();
        minus.setText("-");
        minus.setBackground(Color.red);
        minus.setForeground(Color.yellow);
        minus.setBounds(400, 100, 80, 40);
        minus.addActionListener(this);
        div = new JButton();
        div.setText("/");
        div.setBackground(Color.red);
        div.setForeground(Color.yellow);
        div.setBounds(400, 160, 80, 40);
        div.addActionListener(this);
        mul = new JButton();
        mul.setText("X");
        mul.setBackground(Color.red);
        mul.setForeground(Color.yellow);
        mul.setBounds(400, 220, 80, 40);
        mul.addActionListener(this);
        this.setSize(680, 680); // size of widget
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(reset);
        this.add(one);
        this.add(two);
        this.add(three);
        this.add(four);
        this.add(five);
        this.add(six);
        this.add(seven);
        this.add(eight);
        this.add(nine);
        this.add(zero);
        this.add(plus);
        this.add(minus);
        this.add(mul);
        this.add(div);
        this.add(equal);

        display.setBounds(50, 350, 100, 100); // Label size and location (x, y, height, width)
        this.add(display); // added label to the Jframe
        display.setForeground(Color.blue);
        display.setBackground(Color.gray);
        display.setFont(new Font("Coic Sans", Font.BOLD, 24)); // Font class

        display2.setBounds(50, 400, 100, 100); // Label size and location (x, y, height, width)
        this.add(display2);
        display2.setForeground(Color.red);
        display2.setFont(new Font("Coic Sans", Font.BOLD, 24)); // Font class
    }
    int x = 0, y = 0;
    long ans = 0;
    int count = 0;
    int count2 = 0;
    Boolean jellybean = false;
    int check = 0;
    @Override
    public void actionPerformed(ActionEvent take_my_input) {
        if(take_my_input.getSource() == one)
        {
            if(jellybean == false) {
                if (count == 0) {
                    x = 1;
                    count = count + 1;
                } else {
                    x = x * 10;
                    x = x + 1;
                }
                display.setText(""+x);
            }
            System.out.print(1);
        }
        if(take_my_input.getSource() == two)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 2;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 2;
                }
                display.setText(""+x);
            }
            System.out.print(2);
            // showing in the text label
        }
        if(take_my_input.getSource() == three)
        {
            if(jellybean == false) {
                if (count == 0) {
                    x = 3;
                    count++;
                } else {
                    x = x * 10;
                    x = x + 3;
                }
                display.setText("" + x);
            }
            System.out.print(3);
        }
        if(take_my_input.getSource() == four)
        {
            if(jellybean == false) {
                if (count == 0) {
                    x = 4;
                    count++;
                } else {
                    x = x * 10;
                    x = x + 4;
                }
                display.setText("" + x);
            }
            System.out.print(4);

        }
        if(take_my_input.getSource() == five)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 5;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 5;
                }
                display.setText(""+x);
            }
            System.out.print(5);
        }
        if(take_my_input.getSource() == six)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 6;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 6;
                }
                display.setText(""+x);
            }
            System.out.print(6);
        }
        if(take_my_input.getSource() == seven)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 7;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 7;
                }
                display.setText(""+x);
            }
            System.out.print(7);
        }
        if(take_my_input.getSource() == eight)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 8;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 8;
                }
                display.setText(""+x);
            }
            System.out.print(8);
        }
        if(take_my_input.getSource() == nine)
        {
            if(jellybean == false)
            {
                if(count == 0)
                {
                    x = 9;
                    count ++;
                }
                else
                {
                    x = x * 10;
                    x = x + 9;
                }
                display.setText(""+x);
            }
            System.out.print(9);
        }

        if(take_my_input.getSource() == zero)
        {
            if(jellybean == false)
            {
                x = x * 10;
                display.setText(""+x);
            }
            System.out.print(0);
        }
        if(take_my_input.getSource() == plus)
        {
            check = 1;
            y = x;
            x = 0;
            System.out.print(" ");
            display.setText(" ");
            System.out.print("+ ");
            display.setText("+ ");
            //jellybean = true;
        }
        if(take_my_input.getSource() == minus)
        {
            y = x;
            x = 0;
            System.out.print(" ");
            display.setText(" ");
            System.out.print("- ");
            display.setText("- ");
            // jellybean = true;
            check = 2;
        }
        if(take_my_input.getSource() == mul)
        {
            y = x;
            x = 0;
            System.out.print(" ");
            display.setText(" ");
            System.out.print("X ");
            display.setText("X ");
            //jellybean = true;
            check = 3;
        }
        if(take_my_input.getSource() == div)
        {
            y = x;
            x = 0;
            System.out.print(" ");
            display.setText(" ");
            System.out.print("/ ");
            display.setText("/ ");
            //jellybean = true;
            check = 4;
        }
        if(take_my_input.getSource() == equal)
        {
            System.out.print(" = ");
            if(check == 1)
            {
                ans = x + y;
                System.out.println(ans);
                display2.setText(""+ans);
            }
            else if(check == 2)
            {
                ans = y - x;
                System.out.println(ans);
                display2.setText(""+ans); // Printing in the display using setText takes parameter as string so that answer is taking as a string
            }
            else if(check == 3)
            {
                ans = x * y;
                System.out.println(ans);
                display2.setText(""+ans); // Printing in the display using setText takes parameter as string so that answer is taking as a string
            }
            else if(check == 4)
            {
                double f = (double)y / x;
                System.out.println(f);
                display2.setText(""+f);
            }

        }
        if(take_my_input.getSource() == reset)
        {
            x = 0;
            y = 0;
            ans = 0;
            display.setText(""+0);
        }
    }
}
