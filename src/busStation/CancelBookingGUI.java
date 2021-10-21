package busStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelBookingGUI {

	private JFrame frame;
	private int i=0;
	private int j=0;
	private int z=-1;
	private String CurrentBookings[][]=new String [100][6];
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBookingGUI window = new CancelBookingGUI();
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
	public CancelBookingGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblCancelBooking = new JLabel("Choose the Trip you Wish to cancel");
		lblCancelBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCancelBooking.setBounds(10, 11, 294, 30);
		getFrame().getContentPane().add(lblCancelBooking);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 53, 308, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 87, 308, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 121, 308, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(10, 155, 308, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 189, 308, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(10, 223, 308, 20);
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
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*try {

				      File inFile = new File("Trips.txt");

				      if (!inFile.isFile()) {
				        System.out.println("Parameter is not an existing file");
				        return;
				      }

				      //Construct the new file that will later be renamed to the original filename.
				      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

				      BufferedReader br = new BufferedReader(new FileReader("Trips.txt"));
				      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

				      String line = null;

				      //Read from the original file and write to the new
				      //unless content matches data to be removed.
				      while ((line = br.readLine()) != null) {

				        if (!line.trim().equals(textField.getText())) {

				          pw.println(line);
				          pw.flush();
				        }
				      }
				      pw.close();
				      br.close();

				      //Delete the original file
				      if (!inFile.delete()) {
				        System.out.println("Could not delete file");
				        return;
				      }

				      //Rename the new file to the filename the original file had.
				      if (!tempFile.renameTo(inFile))
				        System.out.println("Could not rename file");

				    }
				    catch (FileNotFoundException ex) {
				      ex.printStackTrace();
				    }
				    catch (IOException ex) {
				      ex.printStackTrace();
				    }*/
				  }
		});
		btnNewButton.setBounds(328, 52, 96, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(328, 86, 96, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.setBounds(328, 120, 96, 23);
		frame.getContentPane().add(btnCancel_1);
		
		JButton btnCancel_2 = new JButton("Cancel");
		btnCancel_2.setBounds(328, 154, 96, 23);
		frame.getContentPane().add(btnCancel_2);
		
		JButton btnCancel_3 = new JButton("Cancel");
		btnCancel_3.setBounds(328, 188, 96, 23);
		frame.getContentPane().add(btnCancel_3);
		
		JButton btnCancel_4 = new JButton("Cancel");
		btnCancel_4.setBounds(328, 222, 96, 23);
		frame.getContentPane().add(btnCancel_4);
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
