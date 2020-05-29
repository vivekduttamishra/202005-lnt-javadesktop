package set16.swt.todoapp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.UIBuilder;

public class AboutScreen implements UIBuilder {
	
	Shell shell;
	
	public AboutScreen(String title) {
		this();
		shell.setText(title);
		shell.setVisible(true);
		
	}
	
	public AboutScreen() {
		// TODO Auto-generated constructor stub
		shell= new Shell(Display.getDefault());
		build(shell);
		
	}
	
	public Shell getShell() {return shell;}
	

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		RowLayout layout=new RowLayout(SWT.VERTICAL);
		
		layout.justify=true;
		parent.setLayout(layout);
		
		ControlBuilder builder=new ControlBuilder(parent);
		
		builder
				.label("About Todo Manager")
				.label("Version 1.0")
				.button("OK")
				.get(Button.class).addListener(SWT.Selection, new Listener() {
					
					@Override
					public void handleEvent(Event arg0) {
						// TODO Auto-generated method stub
						parent.dispose();
					}
				});
		
		parent.setSize(400,200);
		
		
		
		
	}

}
