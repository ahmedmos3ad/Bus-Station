package busStation;

import java.awt.EventQueue;
import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class ExternalTripGUI extends GuiLogin{

	private JFrame frame;
	private ButtonGroup bg1 = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private ButtonGroup bg3 = new ButtonGroup();
    private ButtonGroup bg4 = new ButtonGroup();
    static String city="",vehicle="",way="",type="External",stops="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExternalTripGUI window = new ExternalTripGUI();
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
	public ExternalTripGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 395, 436);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(174, 36, 1, 1);
		getFrame().getContentPane().add(desktopPane);
		
		JLabel lblDestination = new JLabel("DESTINATION");
		lblDestination.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDestination.setBounds(12, 7, 132, 20);
		getFrame().getContentPane().add(lblDestination);
		
		JLabel lblMethod = new JLabel("VEHICLE");
		lblMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMethod.setBounds(12, 127, 132, 20);
		getFrame().getContentPane().add(lblMethod);
		
		JLabel lblType = new JLabel("TYPE");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblType.setBounds(12, 206, 132, 20);
		getFrame().getContentPane().add(lblType);
		
		JRadioButton rdbtnLibya = new JRadioButton("Benghazi, Libya");
		rdbtnLibya.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLibya.setBounds(22, 37, 167, 25);
		getFrame().getContentPane().add(rdbtnLibya);
		
		JRadioButton rdbtnSudan = new JRadioButton("Khartoom, Sudan");
		rdbtnSudan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnSudan.setBounds(202, 37, 154, 25);
		getFrame().getContentPane().add(rdbtnSudan);
		
		JRadioButton rdbtnKSA = new JRadioButton("Mecca, KSA");
		rdbtnKSA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnKSA.setBounds(22, 73, 142, 25);
		getFrame().getContentPane().add(rdbtnKSA);
		
		JRadioButton rdbtnBus = new JRadioButton("Bus");
		rdbtnBus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnBus.setBounds(22, 159, 97, 25);
		getFrame().getContentPane().add(rdbtnBus);
		
		JRadioButton rdbtnMinibus = new JRadioButton("Minibus");
		rdbtnMinibus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMinibus.setBounds(123, 159, 97, 25);
		getFrame().getContentPane().add(rdbtnMinibus);
		
		JRadioButton rdbtnLimousine = new JRadioButton("Limousine");
		rdbtnLimousine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnLimousine.setBounds(248, 159, 108, 25);
		getFrame().getContentPane().add(rdbtnLimousine);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One way");
		rdbtnOneWay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnOneWay.setBounds(22, 240, 93, 25);
		getFrame().getContentPane().add(rdbtnOneWay);
		
		JRadioButton rdbtnRoundTrip = new JRadioButton("Round trip");
		rdbtnRoundTrip.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnRoundTrip.setBounds(125, 240, 127, 25);
		getFrame().getContentPane().add(rdbtnRoundTrip);
		bg1.add(rdbtnLibya);
		bg1.add(rdbtnSudan);
		bg1.add(rdbtnKSA);
		bg2.add(rdbtnBus);
		bg2.add(rdbtnMinibus);
		bg2.add(rdbtnLimousine);
		bg3.add(rdbtnOneWay);
		bg3.add(rdbtnRoundTrip);
		
		JLabel lblStops = new JLabel("Stops");
		lblStops.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStops.setBounds(10, 282, 132, 20);
		getFrame().getContentPane().add(lblStops);
		
		JRadioButton rdbtnZero = new JRadioButton("Zero");
		bg4.add(rdbtnZero);
		rdbtnZero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnZero.setBounds(22, 310, 93, 25);
		getFrame().getContentPane().add(rdbtnZero);
		
		JRadioButton rdbtnOne = new JRadioButton("One");
		bg4.add(rdbtnOne);
		rdbtnOne.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnOne.setBounds(125, 309, 93, 25);
		getFrame().getContentPane().add(rdbtnOne);
		
		JRadioButton rdbtnTwo = new JRadioButton("Two");
		bg4.add(rdbtnTwo);
		rdbtnTwo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnTwo.setBounds(248, 310, 93, 25);
		getFrame().getContentPane().add(rdbtnTwo);
		
		JButton btnNewButton = new JButton("BOOK!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((rdbtnLibya.isSelected() || rdbtnSudan.isSelected() || rdbtnKSA.isSelected()) && (rdbtnBus.isSelected() || rdbtnMinibus.isSelected()
								|| rdbtnLimousine.isSelected()) && (rdbtnOneWay.isSelected() || rdbtnRoundTrip.isSelected()) 
						        && (rdbtnOne.isSelected() || rdbtnTwo.isSelected() || rdbtnZero.isSelected())) {
				if (rdbtnLibya.isSelected()) {city="Bengazi";}
				if (rdbtnSudan.isSelected()) {city="Khartoom";}
				if (rdbtnKSA.isSelected()) {city="Mecca";}
				if (rdbtnBus.isSelected()) {vehicle="Bus";}
				if (rdbtnMinibus.isSelected()) {vehicle="Minibus";}
				if (rdbtnLimousine.isSelected()) {vehicle="Limousine";}
				if (rdbtnOneWay.isSelected()) {way="OneWay";}
				if (rdbtnRoundTrip.isSelected()) {way="RoundTrip";}
				if (rdbtnZero.isSelected()) {stops="Zero";}
				if (rdbtnOne.isSelected()) {stops="One";}
				if (rdbtnTwo.isSelected()) {stops="Two";}
				ExternalTicketDetailsGUI whatever=new ExternalTicketDetailsGUI ();
				whatever.getFrame().setVisible(true);
				try { 
					BufferedWriter writer;
					writer = new BufferedWriter(new FileWriter("Trips.txt", true));
					writer.newLine();
					writer.append(x.getID());
					writer.append(',');
					writer.append(type);
					writer.append(',');
					writer.append(city);
					writer.append(',');
					writer.append(vehicle);
					writer.append(',');
					writer.append(way);
					writer.append(',');
					writer.append(stops);
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		else JOptionPane.showMessageDialog(null,"Please make sure City,Vehicle,Way and Stops are selected","Booking Error",JOptionPane.ERROR_MESSAGE);
        }});
			
		
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(100, 344, 167, 42);
		getFrame().getContentPane().add(btnNewButton);
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

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the vehicle
	 */
	public String getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the way
	 */
	public String getWay() {
		return way;
	}

	/**
	 * @param way the way to set
	 */
	public void setWay(String way) {
		this.way = way;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the stops
	 */
	public String getStops() {
		return stops;
	}

	/**
	 * @param stops the stops to set
	 */
	public void setStops(String stops) {
		this.stops = stops;
	}
}
