package demo09.calculatorapp;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import demo09.calculatorapp.models.CalculatorOperatorClickListner;

public class OperatorPanel extends Panel implements ActionListener {

	CalculatorOperatorClickListner operatorListner;
	
	public CalculatorOperatorClickListner getOperatorListner() {
		return operatorListner;
	}

	public void setOperatorListner(CalculatorOperatorClickListner operatorListner) {
		this.operatorListner = operatorListner;
	}

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
				button.addActionListener(this);
			}
		}
		
		
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String value=e.getActionCommand().trim();
		//System.out.println("Operator '"+value+"'");
		operatorListner.operatorClicked(value);
		
	}
	
	
	
	
}
