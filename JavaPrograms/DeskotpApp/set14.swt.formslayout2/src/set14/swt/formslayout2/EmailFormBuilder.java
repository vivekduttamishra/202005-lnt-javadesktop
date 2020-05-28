package set14.swt.formslayout2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.Form;
import in.conceptarchitect.swt.UIBuilder;

public class EmailFormBuilder implements UIBuilder {

	@Override
	public void build(Composite parent) {
		// TODO Auto-generated method stub

		
		FormLayout layout=new FormLayout();
		parent.setLayout(layout);
		
		ControlBuilder builder=new ControlBuilder(parent);
		
		
		Label fromLabel = builder.label("From").get(Label.class);
		Text fromTextBox = builder.textField().get(Text.class);
		
		Label toLabel = builder.label("To").get(Label.class);
		Text toTextBox = builder.textField().get(Text.class);
		
		Label subjectLabel = builder.label("Subject").get(Label.class);
		Text subjectTextBox = builder.textField().get(Text.class);
		
		
		Label messageLabel = builder.label("Message").get(Label.class);
		Text messageTextBox = builder.textArea().get(Text.class);
		
		Button sendCopyCheckBox= builder.checkBox("Send Me A Copy").get(Button.class);
		sendCopyCheckBox.setSelection(true); //check box is by default checked.
		
		Button sendButton=builder.button("Send").get(Button.class);
		
		
		Form.data().left(5).top(5).applyTo(fromLabel);		
		Form.data(200,20).left(fromLabel,10).top(5).right(50).applyTo(fromTextBox);
		
		
		Form.data().left(5).top(fromLabel,20).applyTo(toLabel);
		Form.data(200,20)  .left(fromTextBox,0,SWT.LEFT).right(50).top(fromLabel,20).applyTo(toTextBox);
		
		
		Form.data().left(5).top(toLabel,20).applyTo(subjectLabel);
		Form.data(200,20).left(subjectLabel,15).right(70).top(toTextBox,20).applyTo(subjectTextBox);
		
		Form.data().left(5).top(subjectLabel,20).applyTo(messageLabel);
		Form.data().left(5).top(messageLabel,10).right(95).bottom(85).applyTo(messageTextBox);
		
		
		Form.data(200,40).right(messageTextBox,0,SWT.RIGHT).top(messageTextBox,20).bottom(98).applyTo(sendButton);
		Form.data().left(5).top(messageTextBox,20).applyTo(sendCopyCheckBox);
				
		
		fromTextBox.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				Text source=(Text) e.getSource();
				messageTextBox.setText("From :"+source.getText());
			}
		});
		
		
		sendCopyCheckBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				fromTextBox.setEnabled(sendCopyCheckBox.getSelection());
			}
		});
		
		
		
	}

}
