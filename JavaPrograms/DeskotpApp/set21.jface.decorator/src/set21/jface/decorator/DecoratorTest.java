package set21.jface.decorator;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DecoratorTest {

	protected Shell shell;
	private Text text;
	private Button addDecorationButton;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DecoratorTest window = new DecoratorTest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		RowLayout rl_shell = new RowLayout(SWT.HORIZONTAL);
		rl_shell.justify = true;
		shell.setLayout(rl_shell);
		
		text = new Text(shell, SWT.BORDER);
		
		ControlDecoration controlDecoration = new ControlDecoration(text, SWT.LEFT | SWT.TOP);
		
		
		
		//Image decorationImage=FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage();
		LocalResourceManager  resourceManager=new LocalResourceManager(JFaceResources.getResources(), shell);
		ImageDescriptor descriptor= ImageDescriptor.createFromFile(getClass(), "/set21/jface/decorator/images/checkit.png");
		
		
		Image warningImage= FieldDecorationRegistry.getDefault()
								.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
								.getImage();
		

		Image requiredImage= FieldDecorationRegistry.getDefault()
								.getFieldDecoration(FieldDecorationRegistry.DEC_REQUIRED)
								.getImage();
		
		
		Image decorationImage=resourceManager.createImage(descriptor);
		
		controlDecoration.setDescriptionText("This Field is Mandatory");
		controlDecoration.setImage(requiredImage);
		
		
		addDecorationButton = new Button(shell, SWT.NONE);
		addDecorationButton.setText("Validate");
		addDecorationButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String value=text.getText();
				if(value==null|| value.equals("")) {
					controlDecoration.setImage(warningImage);
					controlDecoration.setDescriptionText("You should fill this field");
				}else {
					
				
					controlDecoration.setImage(decorationImage);
					controlDecoration.setDescriptionText("We are Good to God");
				}
			}
		});
		

	}
}
