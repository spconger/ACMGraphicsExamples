package com.spconger.KeyPressExample;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.program.GraphicsProgram;
import acm.graphics.*;

@SuppressWarnings("restriction")
public class MoveTurtle extends GraphicsProgram {
	
	private GTurtle portia;
	
	public void run(){
		portia = new GTurtle(getWidth()/2, getHeight() /2);
		add(portia);
		addKeyListeners();
	}
	
	public void keyPressed(KeyEvent e){
		switch (e.getKeyCode()){
		case KeyEvent.VK_RIGHT:
			portia.setDirection(0);
			break;
		case KeyEvent.VK_LEFT:
			portia.setDirection(180);
			break;
		case KeyEvent.VK_UP:
			portia.setDirection(90);
			break;
		case KeyEvent.VK_DOWN:
			portia.setDirection(-90);
			break;
		default:
			return;
		}
		portia.forward(10);
	}

}

