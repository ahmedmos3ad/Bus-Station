package busStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TicketDetailsGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	InternalTripGUI IT = new InternalTripGUI();
	private JTextField textField_6;
	private JTextField textField_7;
	private String CityDetails[][]=new String[9][3];
	private int i=0;
	private int j=0;
	private JLabel lblDistance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketDetailsGUI window = new TicketDetailsGUI();
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
	public TicketDetailsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 413);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblId.setBounds(10, 10, 43, 27);
		getFrame().getContentPane().add(lblId);
		
		JLabel lblDestination = new JLabel("City:");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDestination.setBounds(10, 51, 58, 27);
		getFrame().getContentPane().add(lblDestination);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblVehicle.setBounds(10, 89, 81, 27);
		getFrame().getContentPane().add(lblVehicle);
		
		JLabel lblWay = new JLabel("Way:");
		lblWay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblWay.setBounds(10, 126, 72, 27);
		getFrame().getContentPane().add(lblWay);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblType.setBounds(10, 164, 72, 27);
		getFrame().getContentPane().add(lblType);
		
		JLabel lblStops = new JLabel("Stops:");
		lblStops.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStops.setBounds(10, 202, 72, 27);
		getFrame().getContentPane().add(lblStops);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(154, 325, 130, 38);
		getFrame().getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setBounds(154, 10, 251, 27);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(154, 52, 251, 27);
		getFrame().getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(154, 89, 251, 27);
		getFrame().getContentPane().add(textField_2);
		textField_2.setText(IT.getVehicle());
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(154, 126, 251, 27);
		getFrame().getContentPane().add(textField_3);
		textField_3.setText(IT.getWay());
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(154, 165, 251, 27);
		getFrame().getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(154, 202, 251, 27);
		getFrame().getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(154, 240, 251, 27);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(154, 278, 251, 27);
		frame.getContentPane().add(textField_7);
		
		try {
			Scanner x=new Scanner(new File("CityDetails.txt"));
			x.useDelimiter("[,\n]");
			while (x.hasNext())
			{   //city
				CityDetails[i][0]=x.next();
				//distance
				CityDetails[i][1]=x.next();
				//price
				CityDetails[i][2]=x.next();
				i++;
				}
			i--;
		x.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		if(IT.getType().trim().equals("Internal")) {
		textField.setText(VerifyLogin.ID);
		textField_1.setText(InternalTripGUI.city);
		textField_2.setText(InternalTripGUI.vehicle);
		textField_3.setText(InternalTripGUI.way);
		textField_4.setText(InternalTripGUI.type);
		textField_5.setText(InternalTripGUI.stops);
		for(j=0;j<=i;j++) {
			if(CityDetails[0][0].trim().equals(IT.getCity())) {
			textField_6.setText(CityDetails[0][2]+""+"L.E");
			textField_7.setText(CityDetails[0][1]+""+"K.M");}
			if(CityDetails[1][0].trim().equals(IT.getCity())) {
				textField_6.setText(CityDetails[1][2]+""+"L.E");
				textField_7.setText(CityDetails[1][1]+""+"K.M");}
			if(CityDetails[2][0].trim().equals(IT.getCity())) {
				textField_6.setText(CityDetails[2][2]+""+"L.E");
				textField_7.setText(CityDetails[2][1]+""+"K.M");}
			if(CityDetails[3][0].trim().equals(IT.getCity())) {
				textField_6.setText(CityDetails[3][2]+""+"L.E");
				textField_7.setText(CityDetails[3][1]+""+"K.M");}
			if(CityDetails[4][0].trim().equals(IT.getCity())) {
				textField_6.setText(CityDetails[4][2]+""+"L.E");
				textField_7.setText(CityDetails[4][1]+""+"K.M");}
			if(CityDetails[5][0].trim().equals(IT.getCity())) {
				textField_6.setText(CityDetails[5][2]+""+"L.E");
				textField_7.setText(CityDetails[5][1]+""+"K.M");}
		}}
		
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPrice.setBounds(10, 240, 72, 27);
		frame.getContentPane().add(lblPrice);
		
		lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDistance.setBounds(10, 278, 99, 27);
		frame.getContentPane().add(lblDistance);
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
	}
}
