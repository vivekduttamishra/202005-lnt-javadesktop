package in.conceptarchitect.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Application {
	
	Shell shell;
	Display display;
	
	private Application() {
		
		display=new Display();
		shell=new Shell(display);
		
	}
	
	public static final Application instance=new Application();
	

	public Shell getShell() {
		return shell;
	}


	public void setShell(Shell shell) {
		this.shell = shell;
	}


	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}




	public void run() {
		shell.setVisible(true);
		while(!shell.isDisposed()) {  //as long as my window is not closed.
			//read message from queue and dispatch to listners
			if(!display.readAndDispatch()) //if no message found
				display.sleep(); //wait till next message arrives.				
		}
	}
	
}
