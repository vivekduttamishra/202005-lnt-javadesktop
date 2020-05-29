package set19.rcp.helloworld;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class HelloWorldWindow {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorldWindow window = new HelloWorldWindow();
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
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		
		TabItem tbtmBasic = new TabItem(tabFolder, SWT.NONE);
		tbtmBasic.setText("Basic");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmBasic.setControl(composite);
		composite.setLayout(new GridLayout(3, false));
		
		Label lblTask = new Label(composite, SWT.NONE);
		lblTask.setText("Task");
		new Label(composite, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 200;
		text.setLayoutData(gd_text);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("New Label");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		TabItem tabItem_1 = new TabItem(tabFolder, SWT.NONE);
		tabItem_1.setText("New Item");
		
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("New Item");
		
		TabItem tbtmSubTasks = new TabItem(tabFolder, SWT.NONE);
		tbtmSubTasks.setText("Sub Tasks");
		
		TabItem tbtmNotes = new TabItem(tabFolder, SWT.NONE);
		tbtmNotes.setText("Notes");

	}
}
