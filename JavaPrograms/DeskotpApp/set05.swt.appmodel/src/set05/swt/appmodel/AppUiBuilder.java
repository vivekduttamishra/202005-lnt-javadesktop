package set05.swt.appmodel;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import in.conceptarchitect.swt.UIBuilder;


public class AppUiBuilder implements UIBuilder{
	

	public void build(Composite parent) {
		//Write your logic to Build your applicaiton
		//parent.setText("My SWT Application");
		
		Button greetButton=new Button(parent, 0);
		greetButton.setText("Greet");
		greetButton.setBounds(20,20,100,100);
		
		parent.setSize(500,500);
		
		
	}
}
