package demo09.calculatorapp;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import demo09.calculatorapp.models.CalculatorDigitClickListener;

public class DigitPanel extends Panel implements ActionListener{

	//whoever is interested in knowing digit click let me know
	CalculatorDigitClickListener digitClickListner;
	
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
				button.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button button=(Button) e.getSource();		
		String value=button.getLabel();		
		//System.out.println(value);
		
		//I will inform the listner that digit is clicked
		digitClickListner.digitClicked(value);  //inform the brain about digit clicked
		
		
	}
	
	
	

	
	public CalculatorDigitClickListener getDigitClickListner() {
		return digitClickListner;
	}

	public void setDigitClickListner(CalculatorDigitClickListener digitClickListner) {
		this.digitClickListner = digitClickListner;
	}

	
}
