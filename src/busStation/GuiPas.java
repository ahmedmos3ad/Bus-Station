package busStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiPas extends GuiLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPas window = new GuiPas();
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
	public GuiPas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 270);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JButton btnNewExternal = new JButton("Book an External trip");
		btnNewExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExternalTripGUI External= new ExternalTripGUI();
				External.getFrame().setVisible(true);
			}
		});
		btnNewExternal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewExternal.setBounds(12, 69, 408, 43);
		getFrame().getContentPane().add(btnNewExternal);
		
		JButton btnCheckCurrentTickets = new JButton("Check current bookings");
		btnCheckCurrentTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrentBookingsGUI currentBookings = new CurrentBookingsGUI();
				currentBookings.getFrame().setVisible(true);
			}
		});
		btnCheckCurrentTickets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckCurrentTickets.setBounds(12, 123, 408, 43);
		getFrame().getContentPane().add(btnCheckCurrentTickets);
		
		JButton btnCancelABooking = new JButton("Cancel a booking");
		btnCancelABooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBookingGUI cancelBookings = new CancelBookingGUI();
				cancelBookings.getFrame().setVisible(true);
			}
		});
		btnCancelABooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelABooking.setBounds(12, 177, 408, 43);
		getFrame().getContentPane().add(btnCancelABooking);
		
		JButton btnNewInternal = new JButton("Book an Internal trip");
		btnNewInternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InternalTripGUI Internal= new InternalTripGUI();
				Internal.getFrame().setVisible(true);
			}
		});
		btnNewInternal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewInternal.setBounds(12, 13, 408, 43);
		getFrame().getContentPane().add(btnNewInternal);
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
