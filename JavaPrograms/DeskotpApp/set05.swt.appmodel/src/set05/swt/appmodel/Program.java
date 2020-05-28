package set05.swt.appmodel;

import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application
			.instance
			.setTitle("My SWT Application")
			.build(new AppUiBuilder())
			.center()
			.run();
		
	}

}
