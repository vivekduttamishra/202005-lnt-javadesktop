package set18.swt.taskmanager;

import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Application
				.instance
				.setTitle("Task Manager -- (New Project)")
				.build(new TaskManagerMainScreen())
				//.packShell()
				
				.center()				
				.run();
		
	}

}
