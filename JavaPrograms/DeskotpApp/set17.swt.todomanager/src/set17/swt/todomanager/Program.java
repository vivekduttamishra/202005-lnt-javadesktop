package set17.swt.todomanager;

import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Application
				.instance
				.setTitle("Todo Manager")
				.build(new TodoMainScreen())
				//.packShell()
				.center()				
				.run();
		
	}

}
