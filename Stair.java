package com.spconger.stairway;

import java.awt.Color;

import acm.program.GraphicsProgram;
import acm.graphics.*;
import acm.io.IODialog;

public class Stair extends GraphicsProgram {
	
	int numberOfSteps=0;
	
	public void run(){
		GetNumberOfSteps();
		DrawSteps();
	}
	
	private void GetNumberOfSteps(){
		 IODialog dialog = new IODialog();
		   numberOfSteps= dialog.readInt("Enter the number of steps: ");
	}
	
	private void DrawSteps(){
		int x=10;
		int y=10;	
		for (int i=1;i<=numberOfSteps;i++){
			
			x+=80-20;  
			y+=40;
			@SuppressWarnings("restriction")
			GRect rect = new GRect(x,y, 80, 40 );
			if (i <= numberOfSteps /2){
				rect.setFillColor(Color.red);
				rect.setFilled(true);
			}
			else{
				rect.setFillColor(Color.blue);
				rect.setFilled(true);
			}
			add(rect);
		}
	}

}
