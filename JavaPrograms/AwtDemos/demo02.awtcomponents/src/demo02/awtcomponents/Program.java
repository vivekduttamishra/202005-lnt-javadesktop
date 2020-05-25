package demo02.awtcomponents;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame frame=new Frame("Hello AWT World");
		frame.setSize(800,600);
		frame.setLayout(new GridLayout(3,3,5,10));
		
		//lets add a new Button
		frame.setVisible(true);
		
		for(int i=1;i<=13;i++)
		{
			Button button=new Button("Button "+i);
			frame.add(button);
		}
		
		
		frame.invalidate(); //refresh the frame
		
		
		System.out.println("Program Started...");

	}

}
