package set02.swt.eventloop;

import java.awt.Frame;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		Frame frame=new Frame();
		frame.setTitle("Hello AWT Window");
		frame.setSize(400,400);
		frame.setVisible(true);
		
		//Step1 — Controller of a SWT application and its window
		Display display=new Display();
		
		//Step2 — Create A Shell (similar to AWT Frame)
		Shell shell=new Shell(display);  //Shell needs the Display
		shell.setText("Hello SWT World");
		shell.setSize(400, 400);
		//Step 3 — Display the Shell.
		shell.setVisible(true);
		
		while(!shell.isDisposed()) {  //as long as my window is not closed.
			//read message from queue and dispatch to listners
			if(!display.readAndDispatch()) //if no message found
				display.sleep(); //wait till next message arrives.				
		}
		
	}

}
