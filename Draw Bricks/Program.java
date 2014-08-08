package com.spconger.com;
import acm.graphics.*;
import acm.program.*;
import java.awt.Color;




public class Program extends GraphicsProgram{
	
	private final int GAMEWIDTH=400;
	private final int GAMEHEIGHT=600;
	private final int BRICKSPACE=4;
	private final int NUMBEROFBRICKS=10;
	private final int BRICKWIDTH=GAMEWIDTH/NUMBEROFBRICKS-BRICKSPACE;
	private final int BRICKHEIGHT=8;
	private final int BRICKSTARTPOSITIONX=0;
	private final int BRICKSTARTPOSITIONY = 60;
	
	public void run(){
		
			setSize(GAMEWIDTH, GAMEHEIGHT);
		
			int x=BRICKSTARTPOSITIONX;
			int y=BRICKSTARTPOSITIONY;
			
			for (int r=1; r < 11; r++){
				
				Color c = pickColor(r);
			
				for (int i=1;i<11;i++){
					
					GRect brick = new GRect(x,y,BRICKWIDTH,BRICKHEIGHT);
					brick.setFillColor(c);
					brick.setFilled(true);
					add(brick);
					x+=BRICKWIDTH + 4;
				}
				x=0;
				y+=BRICKHEIGHT + 4;
			}
		}
		private Color pickColor(int row){
			Color c=Color.red;
			switch (row)
			{
				case 1:
				case 2:
					c=Color.red;
					break;
				case 3:
				case 4:
					c=Color.orange;
					break;
				case 5:
				case 6:
					c=Color.yellow;
					break;
				case 7:
				case 8:
					c=Color.green;
					break;
				case 9:
				case 10:
					c=Color.blue;
					break;
				default:
					c=Color.gray;
					break;
					
				
		
			}
			
			return c;
		}
		
	}


