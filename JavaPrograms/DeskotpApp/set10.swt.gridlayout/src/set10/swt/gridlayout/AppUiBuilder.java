package set10.swt.gridlayout;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
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
		
		parent.setLayout(new FillLayout());
		Composite stretchPane=new Composite(parent, 0);
		
		
		GridLayout layout=new GridLayout();		
		layout.numColumns=5;
		layout.verticalSpacing=20;
		layout.horizontalSpacing=40;
		//layout.makeColumnsEqualWidth=true;
		stretchPane.setLayout(layout);
		
		addButtons(stretchPane, 25, "Button");		
		
	}

	private void addButtons(Composite parentPanel, int buttonCount, String nameBase) {
		for(int i=1;i<=buttonCount;i++) {
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
