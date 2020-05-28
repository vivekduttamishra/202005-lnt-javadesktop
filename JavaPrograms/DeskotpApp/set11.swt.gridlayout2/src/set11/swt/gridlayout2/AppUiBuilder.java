package set11.swt.gridlayout2;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.UIBuilder;

public class AppUiBuilder implements UIBuilder {

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		GridLayout layout=new GridLayout();		
		layout.numColumns=4;		
		//layout.makeColumnsEqualWidth=true;
		parent.setLayout(layout);
		
		Button button=new Button(parent,SWT.PUSH);
		button.setText("My Button 1");
		button.setLayoutData(new GridData());
		
		Button button2=new Button(parent,SWT.PUSH);
		button2.setText("My Button 2");
		GridData button2Data=new GridData();
		button2Data.horizontalAlignment=SWT.FILL;
		button2Data.verticalAlignment=SWT.FILL;
		button2Data.verticalSpan=3; //expand to 3 rows
		button2Data.grabExcessHorizontalSpace=true;
		button2.setLayoutData(button2Data);
		
		
		Button button3=new Button(parent,SWT.PUSH);
		button3.setText("My Button 3");
		GridData button3Data=new GridData();
		button3Data.horizontalSpan=2 ; // use two horizontal cells togther
		button3Data.verticalAlignment=SWT.FILL;
		button3Data.horizontalAlignment=SWT.FILL;
		
		button3.setLayoutData(button3Data);
		
		addButtons(parent, 10, "AutoButtons");
		
		Button button4=new Button(parent,SWT.PUSH);
		button4.setText("My Button 4");
		GridData button4Data=new GridData();
		button4Data.horizontalAlignment=SWT.FILL;
		button4Data.verticalAlignment=SWT.FILL;
		
		
		button4Data.grabExcessVerticalSpace=true;
		//button4Data.grabExcessHorizontalSpace=true;
		button4Data.horizontalSpan=4;
		button4.setLayoutData(button4Data);
		
		
		
		//parent.pack(); //trim to the required size
				
		
	}

	private void addButtons(Composite parentPanel, int buttonCount, String nameBase) {
		for(int i=1;i<=buttonCount;i++) {
			Button button=new Button(parentPanel,SWT.PUSH);
			button.setText(nameBase+i);
			GridData data=new GridData();
			data.horizontalAlignment=SWT.FILL;
			button.setLayoutData(data);
			
			button.addSelectionListener(new SelectionAdapter() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					Button btn=(Button) e.getSource();
					Application.instance.setTitle("Button "+btn.getText()+" clicked");
				}
			});
			
		}
	}

}
