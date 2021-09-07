package com.Evan;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    //Declaring the Default Width and Height of GamePanel
    JButton Restart = new JButton();
    static final int SCREEN_WIDTH = 1300;
    static final int SCREEN_HEIGHT = 750;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE); // How many game unit or how many cell in the matrics
    static final int DELAY = 130; // Time delay of movement how slow or fast that will move
    final int x[] = new int[GAME_UNITS]; //for the snake body part..it will hold the X dimension of the snake
    final int y[] = new int[GAME_UNITS]; //for the snake body part..it will hold the Y dimension of the snake
    int bodyParts = 2; //initial Body parts of the snake
    int applesEaten; //Score
    int appleX; // X coordinate of where the apple will be
    int appleY; // Y coordinate of where the apple will be
    char direction = 'R'; // to where it will start going
    boolean running = false; //to check If the snake is running
    Timer timer; //Timer class for timing
    Random random; // for generating the random apples in the co ordinate the game field :p

    //Constructor for initialising
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true); // It is very important but don't know why it is very important in that case if i don't use it then key won't work
        this.addKeyListener(new MyKeyAdapter()); // Added Key Listener for tracking the keyboard
        startGame();
    }
    public void startGame() {
        newApple(); // Beginning of the game an apple is on
        running = true; // and when the game is started so the game is running so true
        timer = new Timer(DELAY,this); //Started Timer and as this class is implementing the action listener so this
        timer.start(); //Starting the timer
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // I have no IDEA HOW DID I DO THAT AND WHY BUT IT IS VERY IMPORTANT
        draw(g); // called the draw function below
    }
    public void draw(Graphics g) {

        if(running) {
            //this is used to draw a grid like a two dimensional array
            /*
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			    (x1,y1, x2, y2) co ordinates of two dots
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT); // for the top to bottom  lines
				g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE); // for the left to bottom lines
			}
			//this code was used for applying everything so that it becomes easier
			*/
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for(int i = 0; i< bodyParts;i++) {
                if(i == 0) {
                    g.setColor(Color.blue);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
                else {
                    g.setColor(new Color(60,70,200));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            g.setColor(Color.red);
            g.setFont( new Font("MV Boli",Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        }
        else {
            gameOver(g);
        }

    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE; // giving the next apple's a random x coordinate
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE; // giving the next apple's random y coordinates
        // I am multiplying the unit size because the apples need to be in the same alignment
    }
    public void move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }
    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
        }
        //check if head touches left border
        if(x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        //Score
        /*Restart.setBounds(300,600,100,40);
        Restart.setBackground(Color.GREEN);
        Restart.setFocusable(false);
        Restart.setFont(new Font("Mv Boli", Font.BOLD, 14));
        Restart.setText("Restart");

        this.add(Restart);*/


        g.setColor(Color.red);
        g.setFont( new Font("MV Boli",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: "+applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.red);
        g.setFont( new Font("MV Boli",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, (SCREEN_HEIGHT/2) - 200);
        g.drawString("CP is FUN", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
        g.drawString("But You are", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, (SCREEN_HEIGHT/2) + 100);
        g.drawString("Noob", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, (SCREEN_HEIGHT/2) + 200);
        g.drawString("--Mehrab Evan", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, (SCREEN_HEIGHT/2) + 300);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(!running)
        {
            if(e.getSource() == Restart) new SnakeGame();
        }*/
        if(running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}

