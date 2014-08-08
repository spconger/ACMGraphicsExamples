package com.spconger.OvalMove;
import acm.graphics.*;
import acm.program.GraphicsProgram;

@SuppressWarnings("restriction")
public class MoveClass extends GraphicsProgram{

		public void run(){
			//GOval oval = new GOval(25,50);
			GTurtle bob = new GTurtle(25, 50);
			add(bob);
			waitForClick();
			
			while(true){
				if(bob.getX() >=getWidth()){
					bob.setDirection(180);
				}
				else if (bob.getX() <= 0){
					bob.setDirection(0);
				}
				bob.forward(22);
			}
			
		}
}
