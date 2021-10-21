package busStation;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuiLogin {

	private JFrame frame;
	private JFrame frmLoginSystem;
	private JTextField txtUsername;
	private ButtonGroup bg1 = new ButtonGroup();
	private JPasswordField txtPw;
	private String Username;
	private String Password;
	VerifyLogin x=new VerifyLogin();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin window = new GuiLogin();
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
	public GuiLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
        private void initialize() {
		frame = new JFrame("Bus station Login");
		frame.setFont(new Font("Agency FB", Font.BOLD, 20));
		frame.setBounds(100, 100, 444, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblUsername.setBounds(30, 91, 95, 27);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblPw.setBounds(30, 126, 95, 27);
		frame.getContentPane().add(lblPw);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(124, 94, 145, 28);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JRadioButton rdbtnPas = new JRadioButton("Passenger");
		rdbtnPas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnPas.setBounds(285, 93, 115, 25);
		frame.getContentPane().add(rdbtnPas);
		bg1.add(rdbtnPas);
		
		JRadioButton rdbtnEmp = new JRadioButton("Employee");
		rdbtnEmp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnEmp.setBounds(285, 128, 127, 25);
		frame.getContentPane().add(rdbtnEmp);
		bg1.add(rdbtnEmp);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUsername(txtUsername.getText());
				setPassword(txtPw.getText());
				if (rdbtnEmp.isSelected() || rdbtnPas.isSelected()) {  
					if(rdbtnPas.isSelected() && x.Verifylogin(getUsername(), getPassword(), "Passengers.txt")){            
					txtUsername.setText(null);
					txtPw.setText(null);
					JOptionPane.showMessageDialog(null,"Welcome"+" "+x.getID(),"Login Success",JOptionPane.INFORMATION_MESSAGE);
					GuiPas Passenger=new GuiPas();
					Passenger.getFrame().setVisible(true);
				}
	                 else if(rdbtnEmp.isSelected() && x.VerifyEmp(getUsername(), getPassword(), "Employee.txt")){            
	 					txtUsername.setText(null);
	 					txtPw.setText(null);
	 					JOptionPane.showMessageDialog(null,"Welcome"+" "+x.getLEVEL(),"Login Success",JOptionPane.INFORMATION_MESSAGE);
	 					if (x.getLEVEL().trim().equals("Admin")) {
	 					AdminGUI Admin=new AdminGUI();
	 					Admin.getFrame().setVisible(true);}
	 					else {
	 						DriverGUI Driver=new DriverGUI();
	 						Driver.getFrame().setVisible(true);
	 					}
	 				}
				else {JOptionPane.showMessageDialog(null,"Invalid Username or Password","Login Error",JOptionPane.ERROR_MESSAGE);
				txtUsername.setText(null);
				txtPw.setText(null);}}
				else {JOptionPane.showMessageDialog(null,"Please Check Either Passenger or Employee","Login Error",JOptionPane.ERROR_MESSAGE);}
				}});
		btnLogin.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnLogin.setBounds(40, 194, 95, 28);
		frame.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText("");
				txtPw.setText("");
			}
		});
		btnClear.setFont(new Font("Agency FB", Font.PLAIN, 20));
		btnClear.setBounds(161, 194, 95, 28);
		frame.getContentPane().add(btnClear);
		
		JLabel Log_IN_Label = new JLabel("Please Enter Username and Password");
		Log_IN_Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Log_IN_Label.setBounds(42, 11, 358, 39);
		frame.getContentPane().add(Log_IN_Label);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginSystem= new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem,"Confirm if you want to exit","Bus Station",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {	
					System.exit(0);
				}
						
			}
		});
		btnExit.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnExit.setBounds(282, 194, 95, 28);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 175, 352, 8);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 68, 352, 2);
		frame.getContentPane().add(separator_1);
		
		txtPw = new JPasswordField();
		txtPw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) 
				btnLogin.doClick();
			}
		});
		txtPw.setBounds(124, 126, 145, 28);
		frame.getContentPane().add(txtPw);
		
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
}
