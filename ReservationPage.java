import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class ReservationPage extends JFrame {
	//private static final ReservationPage AmountDetails = null;
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
					ReservationPage frame = new ReservationPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReservationPage() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1338, 601);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 23));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Chennai", "Hyderabad", "Singapore", "Kuwait"}));
		comboBox.setBounds(148, 15, 166, 32);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Mumbai", "Bombay", "Goa", "Ooty"}));
		comboBox_1.setBounds(516, 20, 153, 32);
		getContentPane().add(comboBox_1);
		
		JButton btnView = new JButton("VIEW");
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnView.setBounds(713, 22, 97, 25);
		getContentPane().add(btnView);
		
		JLabel lblPassenger_Id = new JLabel("Passenger Id");
		lblPassenger_Id.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassenger_Id.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblPassenger_Id.setBounds(862, 17, 131, 25);
		getContentPane().add(lblPassenger_Id);
		
		textField = new JTextField();
		textField.setBounds(1060, 13, 216, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassengername = new JLabel("Passenger_Name");
		lblPassengername.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblPassengername.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassengername.setBounds(862, 64, 195, 25);
		getContentPane().add(lblPassengername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1060, 61, 216, 34);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("Phone_Number");
		lblPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblPhonenumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhonenumber.setBounds(862, 112, 166, 25);
		getContentPane().add(lblPhonenumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1060, 108, 216, 36);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel labelAddress = new JLabel("");
		labelAddress.setBounds(734, 149, 56, 16);
		getContentPane().add(labelAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblAddress.setBounds(885, 216, 143, 16);
		getContentPane().add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1060, 179, 216, 133);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFlightid = new JLabel("Flight_Id");
		lblFlightid.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblFlightid.setBounds(862, 336, 131, 25);
		getContentPane().add(lblFlightid);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1060, 335, 216, 32);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFlightcharges = new JLabel("Flight_Charges");
		lblFlightcharges.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightcharges.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblFlightcharges.setBounds(862, 402, 143, 25);
		getContentPane().add(lblFlightcharges);
		
		textField_5 = new JTextField();
		textField_5.setBounds(1060, 398, 216, 36);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblDestination.setBounds(357, 20, 136, 27);
		getContentPane().add(lblDestination);
		
		JLabel label = new JLabel("");
		label.setBounds(33, 21, 56, 16);
		getContentPane().add(label);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblSource.setBounds(33, 21, 118, 16);
		getContentPane().add(lblSource);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			 
		
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					PreparedStatement ps=con.prepareStatement("insert into Passengers(Passenger_Id,Passenger_name,Phone_Number,Address,Flight_Id,Flight_Charges) values(?,?,?,?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
					ps.setString(6,textField_5.getText());

					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"Booked successfully");
						//dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Booked  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				
				}
			});
		
		

			
		
		btnBook.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnBook.setBounds(885, 478, 112, 30);
		getContentPane().add(btnBook);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			private Window frame;

			public void actionPerformed(ActionEvent e) {
				AmountDetails.main(new String[] {});
frame.dispose();
			
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnExit.setBounds(1098, 478, 97, 30);
		getContentPane().add(btnExit);
	}
}
