package set03.swt.application;

import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shell shell= Application.instance.getShell();
		shell.setText("Hello SWT World");
		shell.setVisible(true);
		
		
		//Shows my shell and runs the message
		Application.instance.run();
				
	}

}
