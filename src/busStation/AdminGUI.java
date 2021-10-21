package busStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGUI extends GuiLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGUI window = new AdminGUI();
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
	public AdminGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame("Admin Panel"));
		getFrame().setBounds(100, 100, 452, 224);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblID.setBounds(26, 16, 40, 27);
		frame.getContentPane().add(lblID);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAccountType.setBounds(26, 47, 145, 27);
		frame.getContentPane().add(lblAccountType);
		
		JLabel lblgetType = new JLabel("Admin");
		lblgetType.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblgetType.setBounds(172, 47, 97, 27);
		frame.getContentPane().add(lblgetType);
		
		JButton btnNewButton = new JButton("Check Bookings");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCheckBookings x=new AdminCheckBookings();
				x.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(26, 84, 387, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDeleteBookingsBy = new JButton("Delete Bookings by ID");
		btnDeleteBookingsBy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteBookingsBy.setBounds(26, 134, 387, 40);
		frame.getContentPane().add(btnDeleteBookingsBy);
		
		JLabel label = new JLabel(VerifyLogin.tempoID);
		label.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label.setBounds(65, 16, 97, 27);
		frame.getContentPane().add(label);
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
