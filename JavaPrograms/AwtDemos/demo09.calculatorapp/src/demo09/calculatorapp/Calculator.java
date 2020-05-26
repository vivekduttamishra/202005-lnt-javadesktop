package demo09.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import in.conceptarchitect.ui.Window;


public class Calculator {

	
	public Calculator(String title) {
		// TODO Auto-generated constructor stub
		
		buildUi(title);
	}
	
	Window calculatorWindow;

	private void buildUi(String title) {
		// TODO Auto-generated method stub
		calculatorWindow=new Window(title);
		calculatorWindow.setLayout(new BorderLayout());

		//Screen Settings
		DisplayPanel screen=new DisplayPanel();		
		calculatorWindow.add(screen, BorderLayout.NORTH);
		
		DigitPanel digitPanel=new DigitPanel();
		calculatorWindow.add(digitPanel,BorderLayout.CENTER);
		
		OperatorPanel operatorPanel=new OperatorPanel();
		calculatorWindow.add(operatorPanel,BorderLayout.EAST);
		
		
	}

	public void start() {
		// TODO Auto-generated method stub
		calculatorWindow.setSize(350,350);
		calculatorWindow.setVisible(true);
	}

}
