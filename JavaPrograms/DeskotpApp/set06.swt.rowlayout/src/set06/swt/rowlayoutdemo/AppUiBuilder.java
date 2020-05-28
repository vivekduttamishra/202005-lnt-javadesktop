package set06.swt.rowlayoutdemo;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
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
		//similar to the flow layout of Java AWT
		RowLayout layout=new RowLayout(SWT.HORIZONTAL);
		//layout.justify=true;
		layout.marginLeft=200;
		layout.marginTop=100;
		
		
		shell.setLayout(layout);
		
		
		for(int i=1;i<=10;i++) {
			Button button1=new Button(shell, 0);
			button1.setText("Button "+i);
			
			//you can pass layout related information to the child component
			//row layout allows you specify the size of your component
			button1.setLayoutData(new RowData(100+ i*20 , 50));
			
			//every layout ignore setBounds
			button1.setBounds(20,20,100,100);  //applicable only if layout is not set
		}
		
		
		
		
	}
}
