package set09.swt.multiplelayouts;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.UIBuilder;

public class AppUiBuilder implements UIBuilder {

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(new FillLayout(SWT.VERTICAL)); //split the screen in two parts upper and lower
		
		
		Composite upperPanel=new Composite(parent, 0);		
		upperPanel.setLayout(new FillLayout()); //Horizontal Fill Layout
		
		addButtons(upperPanel, "Uppder Panel");
		
		
		
		
		Composite lowerPanel=new Composite(parent, 0);
		lowerPanel.setLayout(new FillLayout());
		
		Composite lowerLeftPane=new Composite(lowerPanel, 0);
		RowLayout lowerLeftPaneLayout=new RowLayout(SWT.VERTICAL);
		
		
		lowerLeftPaneLayout.justify=true;
		
		lowerLeftPane.setLayout(lowerLeftPaneLayout);
		lowerLeftPaneLayout.marginLeft=50;
		lowerLeftPaneLayout.marginTop=20;
		
		addButtons(lowerLeftPane, "LowerLeft#");
		
		
		
		
		Composite lowerRightPane=new Composite(lowerPanel, 0);
		lowerRightPane.setLayout(new FillLayout(SWT.VERTICAL));
		addButtons(lowerRightPane, "LowerRight#");
		

		
		
		
	}

	private void addButtons(Composite parentPanel, String nameBase) {
		for(int i=1;i<=5;i++) {
			Button button=new Button(parentPanel,SWT.PUSH);
			button.setText(nameBase+i);
			
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
