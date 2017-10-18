package elvinos.java;

import javax.annotation.PostConstruct;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class PlaygroundPart {
	private Text txtFantastic;
	@PostConstruct
	public void createControls(Composite parent) {
		
		Button btnNewButton = new Button(parent, SWT.NONE);
		btnNewButton.setText("New Button");
		
	}

}
