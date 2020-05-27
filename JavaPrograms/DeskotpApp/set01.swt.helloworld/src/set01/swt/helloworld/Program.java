package set01.swt.helloworld;

import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
//		Frame frame=new Frame();
//		frame.setSize(400,400);
//		frame.setVisible(true);
		
		//Step1 — Controller of a SWT application and its window
		Display display=new Display();
		
		//Step2 — Create A Shell (similar to AWT Frame)
		Shell shell=new Shell(display);  //Shell needs the Display
		
		//Step 3 — Display the Shell.
		shell.setVisible(true);
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
