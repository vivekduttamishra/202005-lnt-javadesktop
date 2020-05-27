package set04.swt.refactor;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AppWindow extends Shell{
	
	Display display;
	public AppWindow(Display display, String title) {
		super(display);
		this.display=display;
		setText(title);
		
		Button myButton=new Button(this, 0);
		myButton.setText("Greet");
		myButton.setBounds(10, 80, 150, 80);
		
		Button quitButton=new Button(this,0);
		quitButton.setText("I Quit");
		quitButton.setBounds(200, 80, 250,180);
		
	}
	
	public void open() {
		this.setVisible(true);
		
		while(!this.isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}

}
