package set15.swt.formslayout3;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import in.conceptarchitect.swt.Application;
import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.Form;
import in.conceptarchitect.swt.UIBuilder;





public class EmailFormBuilder implements UIBuilder {
	
	boolean dirtyFlag=false; //true means unsaved data!

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		
		FormLayout layout=new FormLayout();
		parent.setLayout(layout);
		
		ControlBuilder builder=new ControlBuilder(parent);
		
		
		//<—————  Create the controls ————>
		Label fromLabel = builder.label("From").get(Label.class);
		Text fromTextBox = builder.textField().get(Text.class);
		
		Label toLabel = builder.label("To").get(Label.class);
		//Text toTextBox = builder.textField().get(Text.class);
		
//		Combo toEmailList =new Combo(parent, SWT.DROP_DOWN);
//		toEmailList.add("admin@conceptarchitect.in");
//		toEmailList.add("hr@conceptarchitect.in");
//		toEmailList.add("sales@conceptarchitect.in");
//		toEmailList.select(1);
		
		Combo toEmailList= builder
								.combo(1,"admin@conceptarchitect.in","hr@conceptarchitect","sales@conceptarchitect.in")
								.get(Combo.class);
		
		
		
		Label subjectLabel = builder.label("Subject").get(Label.class);
		//Text subjectTextBox = builder.textField().get(Text.class);
		
		Combo subjectCombo = builder.combo("Feedback","Sales Update","Escalation").get(Combo.class);
		
		
		Label messageLabel = builder.label("Message").get(Label.class);
		Text messageTextBox = builder.textArea().get(Text.class);
		
		Button sendCopyCheckBox= builder.checkBox("Send Me A Copy").get(Button.class);
		sendCopyCheckBox.setSelection(true); //check box is by default checked.
		
		Button sendButton=builder.button("Send").get(Button.class);
		
		
		
		//<—————  Set the Layout ————>
		Form.data().left(5).top(5).applyTo(fromLabel);		
		Form.data(200,20).left(fromLabel,10).top(5).right(50).applyTo(fromTextBox);
		
		
		Form.data().left(5).top(fromLabel,20).applyTo(toLabel);
		Form.data(200,20)  .left(fromTextBox,0,SWT.LEFT).right(50).top(fromLabel,20).applyTo(toEmailList);
		
		
		Form.data().left(5).top(toLabel,20).applyTo(subjectLabel);
		Form.data(200,20).left(subjectLabel,15).right(70).top(toEmailList,20).applyTo(subjectCombo);
		
		Form.data().left(5).top(subjectLabel,20).applyTo(messageLabel);
		Form.data().left(5).top(messageLabel,10).right(95).bottom(85).applyTo(messageTextBox);
		
		
		Form.data(200,40).right(messageTextBox,0,SWT.RIGHT).top(messageTextBox,20).bottom(98).applyTo(sendButton);
		Form.data().left(5).top(messageTextBox,20).applyTo(sendCopyCheckBox);
				
		
		
		//<—————  Set the Layout ————>
		
		Listener modificationListener= new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				dirtyFlag=true;
				Shell shell=Application.instance.getShell();
				String title=shell.getText();
				if(!title.endsWith("*"))
					shell.setText(title+"*");
				
			}
		};
		
	
		//when input change, raise the dirty flag
		fromTextBox.addListener(SWT.Modify, modificationListener);
		toEmailList.addListener(SWT.Modify, modificationListener);
		subjectCombo.addListener(SWT.Modify, modificationListener);
		messageTextBox.addListener(SWT.Modify, modificationListener);
		sendCopyCheckBox.addListener(SWT.Selection, modificationListener);
		
		
		//add windowClosing
		parent.addListener(SWT.Close, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				// TODO Auto-generated method stub
				int answer=0;
				if(dirtyFlag) {
					
					answer=showConfirmationBox("Unsaved Data Warning", "You have unsaved data. Save It Now?");
				}
				
				if(answer==SWT.YES)
					System.out.println("saving the data...");
				
				//what if I don't want to close window
				e.doit= !dirtyFlag  || answer!=SWT.CANCEL; //close only if directFlag is not set
			}
		});
		
		
		sendButton.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				System.out.println("sending message...");
				String from=fromTextBox.getText();
				String to=  toEmailList.getText();
				String subject=subjectCombo.getText();
				String message= messageTextBox.getText();
				boolean selfCopy=sendCopyCheckBox.getSelection();
				
				System.out.printf("Sending message from %s to %s\n",from,to);
				System.out.println("Subject:"+subject);
				System.out.append("Message is :"+message);
				if(selfCopy)
					System.out.println("Sending a CC to "+from);
				
				dirtyFlag=false; //mail is sent. so don't worry. nothing is unsaved
				Shell shell=Application.instance.getShell();
				String title=shell.getText();
				if(title.endsWith("*")) {
					title=title.substring(0,title.length()-1);
					shell.setText(title);
				}
				
			}
		});
		
		
		
		
	}
	
	
	int showConfirmationBox(String title, String message) {
		MessageBox confirmBox=new MessageBox(Application.instance.getShell(), SWT.ICON_QUESTION|SWT.YES|SWT.NO|SWT.CANCEL);
		confirmBox.setText(title);
		confirmBox.setMessage(message);
		return confirmBox.open();
	}
	
	

}
