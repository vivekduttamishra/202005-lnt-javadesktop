package demo09.calculatorapp;

import demo09.calculatorapp.models.CalculatorDigitClickListener;
import demo09.calculatorapp.models.CalculatorOperatorClickListner;
import demo09.calculatorapp.models.DisplayChangeListener;

public class CalculatorBrain implements CalculatorDigitClickListener, CalculatorOperatorClickListner {
	
	DisplayChangeListener displayChangeListner;
	
	
	public DisplayChangeListener getDisplayChangeListner() {
		return displayChangeListner;
	}

	public void setDisplayChangeListner(DisplayChangeListener displayChangeListner) {
		this.displayChangeListner = displayChangeListner;
	}

	String first="0"; //first value
	String second="0"; //a second value is added to the result
	
	
	boolean isFirst=true;
	boolean isDecimalAdded=false; //decimal has not been added
	
	
	public String getValue() {
		if(isFirst)
			return first;
		else
			return second;
	}
	
	public void setValue(String value) {
		if(isFirst)
			first=value;
		else
			second=value;
	}

	

	@Override
	public void digitClicked(String digit) {
		
		//This method will recieve 0-9, . and +/-
		//we will handle this in 3 parts
		
		//decimal point
		if(digit.equals("."))
			handleDot();
		
		else if(digit.equals("+/-"))
			handleNegation();
		
		else
			
			handleValue(digit);
	}

	private void handleValue(String digit) {
		// TODO Auto-generated method stub
		String value=getValue(); //returns current value first/second
		if(value.contentEquals("0"))
			value=digit;
		else
			value+=digit;
		
		setValue(value); //update the first/second
		updateDisplay();
		
	}

	private void updateDisplay() {
		// TODO Auto-generated method stub
		if(displayChangeListner!=null)
			displayChangeListner.updateDisplay(getValue());
	}

	private void handleNegation() {
		// TODO Auto-generated method stub
		String value=getValue();
		if(value.contentEquals("0"))
			return ; //ignore a 0 value
		
		if(value.startsWith("-"))
			value=value.substring(1); //take everything from char 1 i.e. after '-' i.e. remove the '-' sign 
		else
			value="-"+value;
		
		setValue(value);
		updateDisplay();
	}

	private void handleDot() {
		// TODO Auto-generated method stub
		String value=getValue();
		if(!value.contains(".")) {
			value+=".";
			setValue(value);
			updateDisplay();
		}
		
		
			
	}

	@Override
	public void operatorClicked(String operator) {
		// TODO Auto-generated method stub
		//System.out.println("Received operator:"+operator);
		if(displayChangeListner!=null)
			displayChangeListner.updateDisplay("operator:"+operator);
		
	}

	
	
	
	
	
	
	
	

}
