package demo04.gridlayoutdemo;

import java.awt.Button;
import java.awt.Frame;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame frame=new Frame("Hello AWT World");
		frame.setSize(800,600);
		
		//lets add a new Button
		
		Button button=new Button("Click Me!");
		button.setSize(200,100);
		
		
		//Add the button to the Frame as a Component
		frame.add(button);
		
		
		frame.setVisible(true);
		
		System.out.println("Program Started...");

	}

}
