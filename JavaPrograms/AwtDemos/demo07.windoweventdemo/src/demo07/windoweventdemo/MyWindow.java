package demo07.windoweventdemo;

import java.awt.Frame;

public class MyWindow extends Frame {

	
	public MyWindow(String title) {
		super(title);
		
		//you can add multiple handler. each handler gets a chance to handle the request
		this.addWindowListener(new MyWindowListner());
		this.addWindowListener(new WindowDestroyer()); 
		this.setSize(500,500);
		
		
	}
}
		