package set20.jface.fontsandcolors;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class FontsAndColorTest {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FontsAndColorTest window = new FontsAndColorTest();
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
		shell.setSize(796, 422);
		shell.setText("SWT Application");
		FillLayout fl_shell = new FillLayout(SWT.VERTICAL);
		fl_shell.spacing = 20;
		fl_shell.marginWidth = 40;
		fl_shell.marginHeight = 40;
		shell.setLayout(fl_shell);
		
		Button swtButton = new Button(shell, SWT.NONE);
		swtButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shell, "Welcome to Window Builder", "This is a SWT Button\nCreated Using Window Builder");
			}
		});
		swtButton.setImage(SWTResourceManager.getImage(FontsAndColorTest.class, "/set20/jface/fontsandcolors/images/exit3.jpg"));
		swtButton.setFont(SWTResourceManager.getFont("Chiller", 23, SWT.BOLD));
		swtButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		swtButton.setBackground(SWTResourceManager.getColor(0,0,0));
		swtButton.setText("Styled Using SWT");
		
		//JFace has a builtin Resource Manager
		
		LocalResourceManager  resourceManager=new LocalResourceManager(JFaceResources.getResources(), shell);
		
		
		Button jfaceButton = new Button(shell, SWT.NONE);
		jfaceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openQuestion(shell, "Welcome to JFace", "Dow You Like JFace Resource Manager");
			}
		});
		
		jfaceButton.setForeground(resourceManager.createColor(new RGB(255, 255, 255)));
		jfaceButton.setBackground(resourceManager.createColor(new RGB(0, 0, 0)));
		ImageDescriptor descriptor= ImageDescriptor.createFromFile(getClass(), "/set20/jface/fontsandcolors/images/exit3.jpg");
		jfaceButton.setImage(resourceManager.createImage(descriptor));
		Font font=resourceManager.createFont(FontDescriptor.createFrom("Chiller", 23, SWT.BOLD|SWT.ITALIC));
		jfaceButton.setFont(font);
		
		
		jfaceButton.setText("Styled Using JFace");
		

	}

}
