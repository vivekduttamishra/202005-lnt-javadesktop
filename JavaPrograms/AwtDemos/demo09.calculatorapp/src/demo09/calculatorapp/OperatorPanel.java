package demo09.calculatorapp;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class OperatorPanel extends Panel {

	public OperatorPanel() {
	
		this.setLayout(new GridLayout(5,1));		
		String [] values= {"%","*","-","+","="};
		String space="       ";
		
		for(String value :values) {
			if(value==null)
				this.add(new Label("?")); //just add an empty label
			else {
				Button button=new Button(space+value+space);
				button.setSize(60,40);
				this.add(button);
			}
		}
		
		
				
	}
}
