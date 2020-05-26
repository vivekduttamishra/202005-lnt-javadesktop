package demo09.calculatorapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

public class DisplayPanel extends Panel {

	public DisplayPanel() {
		Label screen=new Label("23.45",Label.RIGHT); //align text to the right
		screen.setFont( new Font("Courier", Font.BOLD, 20));		
		screen.setBackground( new Color(220, 220, 220));
		this.setLayout(new BorderLayout());
		this.add(screen);
	}
	
}
