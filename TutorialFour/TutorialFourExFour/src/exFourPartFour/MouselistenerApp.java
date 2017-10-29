package exFourPartFour;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class MouselistenerApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouselistenerApp window = new MouselistenerApp();
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
	public MouselistenerApp() {
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
		
		JButton btnMoveMe = new JButton("Move me...");
		btnMoveMe.setBounds(6, 80, 112, 29);
		frame.getContentPane().add(btnMoveMe);
		
		JLabel lblCoordinates = new JLabel("Coordiantes:");
		lblCoordinates.setBounds(27, 213, 288, 16);
		frame.getContentPane().add(lblCoordinates);
		
		JRadioButton rdbtMove = new JRadioButton("RB Move");
		rdbtMove.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xCoord = e.getX()+ rdbtMove.getX();
				int yCoord = e.getY() + rdbtMove.getY();
				lblCoordinates.setText("Radio Button (x,y):" + xCoord +" "+ yCoord);
				rdbtMove.setBounds(xCoord, yCoord, 288, 16);
			
			}
		});
		rdbtMove.setBounds(6, 6, 141, 23);
		frame.getContentPane().add(rdbtMove);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/Alex/Documents/University/Year 5/Introduction_to_Programming/TutorialFour/TutorialFourExFour/src/Images/55.jpg"));
		lblNewLabel.setBounds(229, 6, 202, 114);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xCoord = e.getX()+ lblNewLabel.getX();
				int yCoord = e.getY() + lblNewLabel.getY();
				lblCoordinates.setText("Image (x,y):" + xCoord +" "+ yCoord);
				lblNewLabel.setBounds(xCoord, yCoord, 202, 114);
			}
		});
	
		
		btnMoveMe.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xCoord = e.getX()+ btnMoveMe.getX();
				int yCoord = e.getY() + btnMoveMe.getY();
				lblCoordinates.setText("Button (x,y):" + xCoord +" "+ yCoord);
				btnMoveMe.setBounds(xCoord, yCoord, 112, 29);
			}
		});
	}
}
