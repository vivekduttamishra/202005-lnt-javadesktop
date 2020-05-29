package set18.swt.taskmanager;





import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.MessageDialog;
import in.conceptarchitect.swt.UIBuilder;

public class TaskManagerMainScreen implements UIBuilder {

	ControlBuilder builder;
	
	String imageBasePath="C:\\MyWorks\\Corporate\\202005-lnt-javadesktop\\images\\";
	

	@Override
	public void build(Composite parent) {
		
		builder=new ControlBuilder(parent);
		parent.setSize(900,600);
		buildMenu(parent);
		//buildToolbar((Shell) parent);
		
	}


	private void buildToolbar(Shell shell) {
		
		
		
		
		
		
		// TODO Auto-generated method stub
		ToolBar toolBar=new ToolBar(shell, SWT.BORDER);
	
		ToolItem newTask=new ToolItem(toolBar, SWT.PUSH);
		//newTask.setText("+Task");
		newTask.setImage(image("add-icon2.jpg"));
		
		
		
		ToolItem removeTask=new ToolItem(toolBar, SWT.PUSH);
		removeTask.setImage(image("delete.jpg"));
		
		
		
		
		
		toolBar.pack();
		
	}


	private Image image(String name) {
		Display display=Display.getCurrent();
		Image image=new Image(display,imageBasePath+name);
		
		return image;
	}


	private void buildMenu(Composite parent) {
		// TODO Auto-generated method stub
		Shell shell=(Shell) parent;
		
		//STEP 1. menuBar can be connected only to a Shell
		//  It creates the large bar
		Menu menuBar=new Menu(shell,SWT.BAR);
		
		
		//STEP 2. create MenuItem to display on the MenuBar. 
		//This item MUST be MenuItem with CASCADE Design
		buildFileMenu(shell, menuBar);
		buildHelpMenu(shell, menuBar);
		
		
		//Final Step � Associate the menuBar as the menuBar of the shell
		shell.setMenuBar(menuBar);
		

		
		
		
	}


	private void buildHelpMenu(Shell shell, Menu menuBar) {
		// TODO Auto-generated method stub
		MenuItem barItem=new MenuItem(menuBar,SWT.CASCADE);
		barItem.setText("&Help");
		
		Menu helpMenu=new Menu(shell,SWT.DROP_DOWN);
		MenuItem helpManual= new MenuItem(helpMenu,SWT.PUSH);
		helpManual.setText("&Manual");
		
		MenuItem helpAbout=new MenuItem(helpMenu, SWT.PUSH);
		helpAbout.setText("&About");
		helpAbout.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				MessageDialog.info("About Todo Manager", "Todo Manager App\nVersion 1\n�conceptarchitect.in");
			}
		});
		
		
		barItem.setMenu(helpMenu);
		
		
		
		
	}


	private void buildFileMenu(Shell shell, Menu menuBar) {
		MenuItem menuBarFile= new MenuItem(menuBar, SWT.CASCADE);
		menuBarFile.setText("&File");
		
		//STEP 3. Menu need to have dropdown list of Menus		
		Menu menuFile=new Menu(shell, SWT.DROP_DOWN);
		MenuItem menuFileNew=new MenuItem(menuFile,SWT.CASCADE);
		menuFileNew.setText("&New");
		
		//-- New has sub Menu --
		Menu menuFileNewSubMenu=new Menu(shell,SWT.DROP_DOWN);
		MenuItem menuFileNewProject= new MenuItem(menuFileNewSubMenu, SWT.PUSH);
		menuFileNewProject.setText("&Project");
		MenuItem menuFileNewTask= new MenuItem(menuFileNewSubMenu, SWT.PUSH);
		menuFileNewTask.setText("&Task");
		
		menuFileNew.setMenu(menuFileNewSubMenu);
		
		
		
		MenuItem menuFileOpen=new MenuItem(menuFile,SWT.PUSH);
		menuFileOpen.setText("&Open");
		new MenuItem(menuFile, SWT.SEPARATOR); //no need to refer this component
		MenuItem menuFileSave=new MenuItem(menuFile,SWT.PUSH);
		menuFileSave.setText("&Save");
		
		
		MenuItem menuFileSaveAs=new MenuItem(menuFile,SWT.PUSH);
		menuFileSaveAs.setText("Save &As");
		
		MenuItem menuFileAutoSave=new MenuItem(menuFile,SWT.CHECK);
		menuFileAutoSave.setText("Auto Sa&ve");
		menuFileAutoSave.setSelection(true);
		menuFileAutoSave.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				System.out.println("Auto Save:"+menuFileAutoSave.getSelection());
			}
		});
		
		
		new MenuItem(menuFile, SWT.SEPARATOR); //no need to refer this component
		
		MenuItem menuFileExit=new MenuItem(menuFile,SWT.PUSH);
		menuFileExit.setText("E&xit");
		menuFileExit.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				Application.instance.getShell().dispose();
			}
		});
		
		//STEP 4. Associate this  Dropdown fileMenu with cascade file menu on the bar 
		menuBarFile.setMenu(menuFile);
	}

}
