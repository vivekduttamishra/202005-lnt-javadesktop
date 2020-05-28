package in.conceptarchitect.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;





public class ControlBuilder {
	
	Composite parent;
	Control control;

	public ControlBuilder(Composite parent) {
		super();
		this.parent = parent;
	}
	
	
	
	public ControlBuilder button(String text, int style) {
		Button b=new Button(parent, style);
		b.setText(text);
		control=b;
		
		return this;
	}
	
	public ControlBuilder button(String text) {
		return button(text,SWT.PUSH);
	}
	
	public ControlBuilder checkBox(String text) {
		return button(text,SWT.CHECK);
	}
	public ControlBuilder radioButton(String text) {
		return button(text,SWT.RADIO);
	}
	 
	
	public ControlBuilder label(String text) {
		Label l=new Label(parent, SWT.LEFT);
		l.setText(text);
		control=l;
		return this;
		
	}
	
	public ControlBuilder text() {
		Text text=new Text(parent,SWT.LEFT|SWT.BORDER);
		control=text;
		return this;
	}
	
	
	
	public ControlBuilder setLayoutData(Object data) {
		control.setLayoutData(data);
		return this;
	}
	
	public ControlBuilder foreground(int r,int g, int b) {
		Color color= new Color(Application.instance.getDisplay(), r,g,b );
		control.setForeground(color);
		return this;
	}
	
	public ControlBuilder background(int r,int g, int b) {
		Color color= new Color(Application.instance.getDisplay(), r,g,b );
		control.setBackground(color);
		return this;
	}
	
	public <E>  E  get(Class<E> type){
		return (E) control;
	}
	
	
	

}
