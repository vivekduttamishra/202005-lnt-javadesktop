package demo06.borderlayoutdemo;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Frame frame=new Frame("Hello AWT World");
		frame.setSize(800,600);
		
		frame.setLayout(new BorderLayout()); //default layout
		
		Button north=new Button("North");
		Button south=new Button("South");
		Button east=new Button("East");
		Button west=new Button("West");
		Button center=new Button("Center");
		
		frame.add(north, BorderLayout.NORTH);
		
		
		//frame.add(east, BorderLayout.EAST);
		//frame.add(west, BorderLayout.WEST);
		//frame.add(south, BorderLayout.SOUTH);
		
		
		frame.add(center); //default constraint BorderLayout.CENTER
		
		frame.setVisible(true);
		
		System.out.println("Program Started...");

	}

}
