package set05.swt.appmodel;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;


public class AppUiBuilder {
	Shell shell;

	public AppUiBuilder(Shell parent) {
		this.shell=parent;
	}
	
	public void build() {
		//Write your logic to Build your applicaiton
		shell.setText("My SWT Application");
		
		Button greetButton=new Button(shell, 0);
		greetButton.setText("Greet");
		greetButton.setBounds(20,20,100,100);
		
	}
}
