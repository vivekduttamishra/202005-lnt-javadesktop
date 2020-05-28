package set13.swt.formslayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.UIBuilder;

public class EmailFormBuilder implements UIBuilder {

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub
		
		System.out.println("Building the Email Form..."+parent);
//		RowLayout layout=new RowLayout(SWT.VERTICAL);
//		layout.marginLeft=20;
//		layout.marginTop=20;
//		layout.spacing=20;
		
		
		FormLayout layout=new FormLayout();
		parent.setLayout(layout);
		
		
		//parent.setLayoutData(layout);
		
		ControlBuilder builder=new ControlBuilder(parent);
		
		
		Label fromLabel = builder.label("From").get(Label.class);
		Text fromTextBox = builder.text().get(Text.class);
		
		Label toLabel = builder.label("To").get(Label.class);
		Text toTextBox = builder.text().get(Text.class);
		
		Label subjectLabel = builder.label("Subject").get(Label.class);
		Text subjectTextBox = builder.text().get(Text.class);
		
		
		Label messageLabel = builder.label("Message").get(Label.class);
		Text messageTextBox = builder.text().get(Text.class);
		
		Button sendCopyCheckBox= builder.checkBox("Send Me A Copy").get(Button.class);
		
		Button sendButton=builder.button("Send").get(Button.class);
		
		
		
		//Let us arrange the control in FormLayout
		FormData fromLabelData=new FormData();
		fromLabelData.left=new FormAttachment(5); //10% from left border
		fromLabelData.top=new FormAttachment(5);   //5% from top border
		fromLabel.setLayoutData(fromLabelData);
		
		
		FormData fromTextBoxData=new FormData(200,20);
		fromTextBoxData.left=new FormAttachment(fromLabel, 10);  //a gap of 10% between label end and textbox start
		fromTextBoxData.top=new FormAttachment(5);
		fromTextBoxData.right=new FormAttachment(50); //60% gap
		fromTextBox.setLayoutData(fromTextBoxData);
		
		
		FormData sendButtonData=new FormData(250,50);
		sendButtonData.right=new FormAttachment(98);
		sendButtonData.bottom=new FormAttachment(98);
		sendButton.setLayoutData(sendButtonData);
		
		
				
		
		
		
				
				
		
	}

}
