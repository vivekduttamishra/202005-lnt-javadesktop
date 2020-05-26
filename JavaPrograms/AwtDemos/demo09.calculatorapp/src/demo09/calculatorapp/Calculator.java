package demo09.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;

import in.conceptarchitect.ui.Window;


public class Calculator {

	
	Window calculatorWindow;
	DisplayPanel displayPanel;
	DigitPanel digitPanel;
	OperatorPanel operatorPanel;
	CalculatorBrain calculatorBrain;
	
	
	
	public Calculator(String title) {
		// TODO Auto-generated constructor stub
		
		buildUi(title);
	}
	
	

	private void buildUi(String title) {
		// TODO Auto-generated method stub
		calculatorWindow=new Window(title);
		calculatorWindow.setLayout(new BorderLayout());

		calculatorBrain=new CalculatorBrain();
		
		
		displayPanel=new DisplayPanel();
		calculatorWindow.add(displayPanel, BorderLayout.NORTH);
		
		digitPanel=new DigitPanel();
		digitPanel.setDigitClickListner(calculatorBrain); //inform calculator brain that digit is clicked
		calculatorWindow.add(digitPanel,BorderLayout.CENTER);
		
		operatorPanel=new OperatorPanel();
		operatorPanel.setOperatorListner(calculatorBrain); //inform calculator brain that operator is clicked
		calculatorWindow.add(operatorPanel,BorderLayout.EAST);
		
		calculatorBrain.setDisplayChangeListner(displayPanel);  //display panel will recieve display changes
		
		
	}

	public void start() {
		// TODO Auto-generated method stub
		calculatorWindow.setSize(350,350);
		calculatorWindow.setVisible(true);
	}

}
