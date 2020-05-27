package demo09.calculatorapp;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import demo09.calculatorapp.models.ControlOperationListners;

public class ClearPanel extends Panel{
	
	ControlOperationListners controlListner;
	
	public ControlOperationListners getControlListner() {
		return controlListner;
	}

	public void setControlListner(ControlOperationListners controlListner) {
		this.controlListner = controlListner;
	}

	public ClearPanel() {
		
		this.setLayout(new GridLayout(1,3));
		
		String [] values= {"AC","C","<-"};
		
		for(String value :values) {
				Button button=new Button(value);
				this.add(button);
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(controlListner!=null)
							controlListner.controlInvoked(e.getActionCommand());
					}
				});
		}
		
	}

}
