package swt22.jface.taskmanager.ui;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;

import in.conceptarchitect.taskmanager.ProjectManager;
import swt22.jface.taskmanager.support.ProjectManagerBuilder;
import swt22.jface.taskmanager.support.TaskTableDetailsProvider;

public class TaskTableWindow {

	protected Shell shell;
	private Table table;
	private TableColumn tblclmnTaskId;
	private TableColumn tblclmnTask;
	private TableColumn tblclmnStatus;
	private TableColumn tblclmnSubTasks;
	private TableColumn tblclmnNotesCount;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TaskTableWindow window = new TaskTableWindow();
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

	ProjectManager manager=ProjectManagerBuilder.getProjectManager();
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(705, 479);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(1, false));
		
		Label lblTaskList = new Label(shell, SWT.CENTER);
		lblTaskList.setFont(SWTResourceManager.getFont("Segoe Print", 20, SWT.BOLD));
		lblTaskList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblTaskList.setText("Task List");
		
		//1. TableViewer is a wrapper over the table. When we create a JFace TableViewer it contains a SWT Table
		//   NOTE: We don't add TableViewer to Shell (as it may look from the syntax). We add underlying table to the Shell
		//         Parameter passed to TableViewer is internally passed to the Table
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		
		//2. We can get the Table from the Table Viewer
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		//3. Table is the UI element and should be added to the Shell
		//   TableViewer is like an invisible controller
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		tblclmnTaskId = new TableColumn(table, SWT.NONE);
		tblclmnTaskId.setWidth(100);
		tblclmnTaskId.setText("Task Id");
		
		tblclmnTask = new TableColumn(table, SWT.NONE);
		tblclmnTask.setWidth(235);
		tblclmnTask.setText("Task");
		
		tblclmnStatus = new TableColumn(table, SWT.NONE);
		tblclmnStatus.setWidth(100);
		tblclmnStatus.setText("Status");
		
		tblclmnSubTasks = new TableColumn(table, SWT.NONE);
		tblclmnSubTasks.setWidth(100);
		tblclmnSubTasks.setText("Sub Tasks");
		
		tblclmnNotesCount = new TableColumn(table, SWT.NONE);
		tblclmnNotesCount.setWidth(109);
		tblclmnNotesCount.setText("Notes Count");
		
		
		
		//Important Table Viewer Elements
		//You can set label and content provider to power the table
		TaskTableDetailsProvider provider=new TaskTableDetailsProvider();
		
		tableViewer.setContentProvider(provider);  // is a input to the TableViewer
		tableViewer.setLabelProvider(provider);    // value provider for the Table
		
		
		//Now Feed the data
		tableViewer.setInput(manager.getTasks());
		
		//tableViewer.setLabelProvider(labelProvider); //the value
		//tableViewer.setContentProvider(provider); //who will provide actual data for the table
		
		

	}

}
