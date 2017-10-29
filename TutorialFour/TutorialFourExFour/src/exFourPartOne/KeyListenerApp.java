package exFourPartOne;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerApp {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KeyListenerApp window = new KeyListenerApp();
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
	public KeyListenerApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTyped = new JLabel("");
		lblTyped.setBounds(6, 76, 415, 16);
		frame.getContentPane().add(lblTyped);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char letter = e.getKeyChar();
				String letterStr = String.valueOf(letter);
				String currentLabel = lblTyped.getText();
				lblTyped.setText(currentLabel + letterStr);
			}
		});
		textField.setBounds(155, 130, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
