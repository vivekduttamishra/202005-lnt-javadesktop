package demo09.calculatorapp;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class DigitPanel extends Panel {

	public DigitPanel() {
		this.setLayout(new GridLayout(4,3));
		
		String [] values= {"7","8","9",
						   "4","5","6",
						   "1","2","3",
						   "+/-","0","."
						   };
		
		for(String value :values) {
				Button button=new Button(value);
				this.add(button);
		}
	}
	
}
