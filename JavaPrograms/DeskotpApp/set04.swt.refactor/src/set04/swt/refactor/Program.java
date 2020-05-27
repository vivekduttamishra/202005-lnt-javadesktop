package set04.swt.refactor;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String []args) {
		
		Display display=new Display();
		AppWindow window=new AppWindow(display,"Hello SWT");
		
		window.open();
		
		System.out.println("end of program");
	}
}
