package com.spconger.acmTest;

import acm.program.GraphicsProgram;
import acm.graphics.*;

public class HelloWorld extends GraphicsProgram {

	@SuppressWarnings("restriction")
	public void run(){
		add(new GLabel("Hello World",75, 100));
	}
}
