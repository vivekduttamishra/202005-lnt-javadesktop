package set16.swt.todoapp;





import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.MessageDialog;
import in.conceptarchitect.swt.UIBuilder;

public class TodoMainScreen implements UIBuilder {

	ControlBuilder builder;
	int count;

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		builder=new ControlBuilder(parent);
		
		parent.setLayout(new RowLayout());
		
		builder.button("Greet").get(Button.class).addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
//				MessageBox message=new MessageBox(Application.instance.getShell(),SWT.ICON_INFORMATION);
//				message.setMessage("Welcome To Todo Manager");
//				message.setText("Hello World");
//				int result=message.open();
				
				int result=MessageDialog.info("Hello World", "Welcome ToDO Manager");
				System.out.println("You selected "+result);
			}
		});
		
		
		builder.button("Ask").get(Button.class).addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				int answer=0;
				while(answer!=SWT.YES) {
					answer= MessageDialog.yesNo("Honest Survey", "Do you like SWT");
					if(answer==SWT.NO)
						MessageDialog.warning("Think Again!!!", "How can someone not like SWT");
				}
				
				MessageDialog.info("Thanks", "Thanks for you honest opinion!\nWe have recorded it");
				
				
				
			}
		});
		
		
		builder.button("About").get(Button.class).addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				count++;
				AboutScreen about=new AboutScreen("About #"+count);
				
			}
		});
		
		
		builder.button("Quit").get(Button.class).addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
	}

}
