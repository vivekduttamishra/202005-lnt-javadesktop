package set04.swt.childcontrol;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String []args) {
		
		Display display=new Display();
		
		Shell shell=new Shell(display);
		
		//shell has no layout —> you can place and size your controls the way you like
		
		//You don't add button to shell, you tell button about its parent
		Button myButton=new Button(shell, 0);
		myButton.setText("Greet");
		myButton.setBounds(10, 80, 150, 80);  //manual placement and sizing fo the controls
		
		Button quitButton=new Button(shell,0);
		quitButton.setText("I Quit");
		quitButton.setBounds(200, 80, 250,180);
		
		
		
		shell.setVisible(true);
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
		System.out.println("end of program");
	}
}
