package exFourPartThree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FocusListenerApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FocusListenerApp window = new FocusListenerApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FocusListenerApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 346, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOutputLabel = new JLabel("Output Label");
		lblOutputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutputLabel.setBounds(28, 171, 288, 101);
		frame.getContentPane().add(lblOutputLabel);
		
		JButton btnPressMe = new JButton("Press Me...");
		btnPressMe.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblOutputLabel.setText("Focus 1!");
			}
		});
		btnPressMe.setBounds(0, 6, 345, 75);
		frame.getContentPane().add(btnPressMe);
		
		JButton btnOtherButton = new JButton("Then Press Me...");
		btnOtherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOutputLabel.setText("Focus 2!");
			}
		});
		btnOtherButton.setBounds(0, 93, 345, 71);
		frame.getContentPane().add(btnOtherButton);
		

	}
}
