package com.spconger.MovingBallAndPaddle;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.color.*;

public class Program extends GraphicsProgram{
	/**
	 * This class is a test for Breakout
	 * it sets up just the ball and the paddle
	 * the ball bounces off the walls of the form
	 * and when it meets the paddle.
	 * The paddle is moved by the left and right
	 * arrow keys. When the ball drops below
	 * the paddle the game is over.
	 * This test was created 7/6/2013
	 * by steve conger
	 */
	
	//set the constants for the objects
	private final int FORMWIDTH=400;
	private final int FORMHEIGHT=600;
	private final int BALLDIAMETER=10;
	private final int PADDLEWIDTH=60;
	private final int PADDLEHEIGHT=8;
	private final int PADDLEOFFSET=FORMHEIGHT-60;
	
	//set the class variables for ball vectors
	private double ballVX=3;
	private double ballVY;
	
	//declare the ball and paddle objects
	private GRect paddle;
	private GOval ball;
	
	
	public void run(){
		//the run sets the form size and calls
		//each of the methods
		setSize(FORMWIDTH, FORMHEIGHT);
		createPaddle();
		addKeyListeners();
		createBall();
		//it starts with a click
		waitForClick();
		moveBall();
	}
	
	//this method creates the paddle
	private void createPaddle(){
		paddle = new GRect (FORMWIDTH/2-PADDLEWIDTH/2,PADDLEOFFSET,  PADDLEWIDTH, PADDLEHEIGHT);
		paddle.setFillColor(Color.black);
		paddle.setFilled(true);
		add(paddle);
	}
	
	//this method handles the key press event
	//for the paddle
	public void keyPressed(KeyEvent e){
		double x = paddle.getX();
		double y=paddle.getY();
		
		//in the switch I try to limit the movement of the
		//paddle to the form width but it doesn't work
		//something to troubleshoot in class
		switch (e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			if(x!=FORMWIDTH){
				paddle.move(PADDLEWIDTH,0);
			}
			else
			{
				paddle.setLocation(FORMWIDTH-PADDLEWIDTH, PADDLEOFFSET);
			}
			
			break;
		case KeyEvent.VK_LEFT:
			if(x!=0){
				paddle.move(-PADDLEWIDTH,0);
			}
			else
			{
				paddle.setLocation(x+PADDLEWIDTH, PADDLEOFFSET);
			}
			break;
		default:
			break;
		}
	}
	
	//this creates the ball and uses a random generator object
	//randomly choose the first angle for the ball vector
	private void createBall(){
		RandomGenerator rand = new RandomGenerator();
		ballVY=rand.nextDouble(1.0, 3.0);
		//position the ball in the center of the form
		ball=new GOval(FORMWIDTH/2-BALLDIAMETER/2,
			    FORMHEIGHT/2-BALLDIAMETER/2,
			    BALLDIAMETER,BALLDIAMETER);
		ball.setFillColor(Color.BLUE);
		ball.setFilled(true);
		add(ball);

	}
	
	private void moveBall(){
		boolean keepGoing=true;
		while(keepGoing){
			   //this makes it so when the ball hits the edges
			   //it reverse direction
			   if(ball.getX()>=FORMWIDTH-BALLDIAMETER || ball.getX() <=0){
			    ballVX=-ballVX;
			   }
			   //same for top and bottom
			   if (ball.getY()>=FORMHEIGHT-BALLDIAMETER || ball.getY() <=0){
			    ballVY = -ballVY;
			   }
			   //this checks for the location of the paddle. If it and the ball's
			   //coordinates are the same, it bounces off the paddle
			   if (getElementAt(ball.getX() + BALLDIAMETER, ball.getY()+BALLDIAMETER)== paddle){
				   ballVY=-ballVY;
			   }
			   //if the ball goes below the paddle we exit the loop
			   //and end the game
			   if (ball.getY() > paddle.getY()){
				   keepGoing=false;
			   }
			   //move the ball
			   ball.move(ballVX, ballVY);
			   //slight pause between positions 
			   //(actually pretty slow)
			   pause(50);
			  }

	}
	

}
