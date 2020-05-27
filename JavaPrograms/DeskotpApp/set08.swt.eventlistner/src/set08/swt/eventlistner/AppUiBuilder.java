package set08.swt.eventlistner;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
		RowLayout layout=new RowLayout(SWT.VERTICAL);
		layout.marginLeft=100;
		layout.marginTop=50;
		layout.spacing=20;
		
		
		shell.setLayout(layout);
		
		int types[]= {SWT.PUSH, SWT.RADIO, SWT.CHECK};
		
		for(int i=1;i<=5;i++) {
			Button btn1=new Button(shell,types[i%3]);
			btn1.setText("Button "+i);
			btn1.setData("Button "+i);
			//attachSelectionListner(btn1);
			
			
			
			btn1.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					Button b=(Button)e.getSource();
					
					System.out.println(b.getText()+" clicked");
					
					super.widgetSelected(e);
				}
			});
		}
				
		
		
	}
	
	void attachSelectionListner(Button btn1) {
		
		btn1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Button selected ");
				Button src=(Button)e.getSource();
				System.out.println("e.item :"+ src.getText());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("Button default selected ");					
				Button src=(Button)e.getSource();
				System.out.println("e.item :"+ src.getText());
			}
		});

	}
	
}
