package com.spconger.graphicsexamples;

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

@SuppressWarnings("restriction")
public class GraphicsTest extends GraphicsProgram {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run(){
		GLabel label = new GLabel("Hello,",100,75);
		GRect g = new GRect(100,50,125,60);
		g.setColor(Color.BLUE);
		g.setFilled(true);
		add(g);
	}
}
