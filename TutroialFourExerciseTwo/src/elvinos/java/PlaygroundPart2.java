package elvinos.java;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class PlaygroundPart2 {
	private Text txtLabel;
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		
		Label lblThisIsSome = new Label(parent, SWT.NONE);
		lblThisIsSome.setText("This is some text");
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.setText("New button");
		new Label(parent, SWT.NONE);
		
		Button btnNewButton_1 = new Button(parent, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		btnNewButton_1.setText("New Button");
		
		txtLabel = new Text(parent, SWT.BORDER);
		txtLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		txtLabel.setText("Label 2");
		new Label(parent, SWT.NONE);
		
	}

}