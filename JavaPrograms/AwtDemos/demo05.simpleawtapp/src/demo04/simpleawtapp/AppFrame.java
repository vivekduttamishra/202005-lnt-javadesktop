package demo04.simpleawtapp;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class AppFrame extends Frame{
	
      public AppFrame() {
    	  CreateUI();
      }
      
    Label nameLabel, greetingLabel;
    TextField nameTextField;
    Button greetButton, quitButton;
    
    

	private void CreateUI() {
		// TODO Auto-generated method stub
		setLayout(new FlowLayout());
		this.setTitle("Greet App");
		
		nameLabel=new Label("Please Enter your Name");
		nameTextField=new TextField(20);
		greetButton=new Button("Greet");
		quitButton=new Button("I Quit");
		greetingLabel=new Label();
		
		
		//create the handler object
		GreetButtonHandler greetButtonHandler=new GreetButtonHandler(nameTextField,greetingLabel);
		//add the handler object to the right component
		greetButton.addActionListener(greetButtonHandler);

		
		quitButton.addActionListener(new QuitAppHandler());

		
		
		this.add(nameLabel);
		this.add(nameTextField);
		this.add(greetButton);
		this.add(quitButton);
		this.add(greetingLabel);
		
		setSize(500,200);
		
	}

}
