package demo09.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import demo09.calculatorapp.models.DisplayChangeListener;

public class DisplayPanel extends Panel implements DisplayChangeListener{

	Label screen;
	public DisplayPanel() {
		screen=new Label("0",Label.RIGHT); //align text to the right
		screen.setFont( new Font("Courier", Font.BOLD, 30));		
		screen.setBackground( new Color(220, 220, 220));
		this.setLayout(new BorderLayout());
		this.add(screen);
		//Clear Panel is not a part of Display
		//Clear is input, Display is output
		//this.add(new ClearPanel(), BorderLayout.SOUTH);
	}

	@Override
	public void updateDisplay(String value) {
		// TODO Auto-generated method stub
		screen.setText(value);
	}
	
}
