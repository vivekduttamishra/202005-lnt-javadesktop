package set07.swt.filllayout;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
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
		
		//set the layout of a composite
		FillLayout layout=new FillLayout(); // SWT.VERTICAL); //Default is Horizontal
		layout.marginWidth=50;
		layout.marginHeight=100;
		layout.spacing=20;
		
		shell.setLayout(layout);
		
		
		for(int i=1;i<=5;i++) {
			Button btn1=new Button(shell,0);
			btn1.setText("Button "+i);
		}
		

		
		
		
		
		
	}
}
