package demo04.simpleawtapp;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetButtonHandler implements ActionListener{

	
	TextField nameTextField;
	private Label greetLabel;
	
	public GreetButtonHandler(TextField nameTextField, Label greetingLabel) {
		super();
		this.nameTextField = nameTextField;
		this.greetLabel=greetingLabel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=nameTextField.getText(); 
		//System.out.println("Hello "+name);
		greetLabel.setText("Hello "+name);
	}
	
	

}
