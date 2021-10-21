package busStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class CurrentBookingsGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int i=0;
	private int j=0;
	private int z=-1;
	private String CurrentBookings[][]=new String [100][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentBookingsGUI window = new CurrentBookingsGUI();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrentBookingsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 418, 332);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTypecityvehiclewayThenStops = new JLabel("Type,City,Vehicle,Way then Stops are Shown Respectively");
		lblTypecityvehiclewayThenStops.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypecityvehiclewayThenStops.setBounds(10, 11, 368, 20);
		frame.getContentPane().add(lblTypecityvehiclewayThenStops);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(10, 37, 368, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 77, 368, 29);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 117, 368, 29);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 157, 368, 29);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 196, 368, 29);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 236, 368, 29);
		frame.getContentPane().add(textField_5);
		try {
			Scanner x=new Scanner(new File("Trips.txt"));
			x.useDelimiter("[,\n]");
			while (x.hasNext())
			{
				CurrentBookings[i][0]=x.next();
				CurrentBookings[i][1]=x.next();
				CurrentBookings[i][2]=x.next();
				CurrentBookings[i][3]=x.next();
				CurrentBookings[i][4]=x.next();
				CurrentBookings[i][5]=x.next();
				i++;
				}
			i--;
		x.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
	for(j=0;j<=i;j++) {
		if (CurrentBookings[j][0].equals(VerifyLogin.ID)){
			z++;
			if (z==0)
			textField.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z==1)
				textField_1.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z==2)
				textField_2.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z==3)
				textField_3.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z==4)
				textField_4.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z==5)
				textField_5.setText(CurrentBookings[j][0]+","+CurrentBookings[j][1]+","+CurrentBookings[j][2]+","+CurrentBookings[j][3]+","+CurrentBookings[j][4]+","+CurrentBookings[j][5]);
			if (z>=6) {
				JOptionPane.showMessageDialog(null,"You have more than 6 trips booked,Displaying oldest booked trips","Too Many Trips",JOptionPane.INFORMATION_MESSAGE);
				break;
		}}
		
	}
	}
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
