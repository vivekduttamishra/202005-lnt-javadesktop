package set13.swt.formslayout;

import org.eclipse.swt.widgets.Shell;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Application
			.instance
			.setTitle("Email Composer")
			.build(new EmailFormBuilder())
			.run();
	}

}
