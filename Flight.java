import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Flight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnAddflight;
	private JButton btnUpdateflight;
	private JButton btnDeleteflight;
	private JButton btnExit;
	private JLabel lblArrivaltime;
	private JTextField textField_8;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Flight frame = new Flight();
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
	public Flight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AIRLINE RESERVATION SYSTEM");
		setBounds(100, 100, 1143, 734);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFlightdetails = new JLabel("FLIGHT_DETAILS");
		lblFlightdetails.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblFlightdetails.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightdetails.setBounds(232, 13, 190, 31);
		contentPane.add(lblFlightdetails);
		
		JLabel lblFlightid = new JLabel("Flight_ID");
		lblFlightid.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFlightid.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightid.setBounds(23, 75, 97, 20);
		contentPane.add(lblFlightid);
		
		textField = new JTextField();
		textField.setBounds(164, 74, 190, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFlightname = new JLabel("Flight_Name");
		lblFlightname.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFlightname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightname.setBounds(25, 116, 116, 20);
		contentPane.add(lblFlightname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 115, 190, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblSource.setBounds(25, 151, 84, 26);
		contentPane.add(lblSource);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 155, 190, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDeparture.setBounds(25, 190, 84, 25);
		contentPane.add(lblDeparture);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 193, 190, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblFlightclass = new JLabel("Flight_Class");
		lblFlightclass.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFlightclass.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightclass.setBounds(25, 228, 116, 20);
		contentPane.add(lblFlightclass);
		
		textField_4 = new JTextField();
		textField_4.setBounds(164, 227, 190, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFlightcharges = new JLabel("Flight_Charges");
		lblFlightcharges.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFlightcharges.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightcharges.setBounds(25, 268, 134, 20);
		contentPane.add(lblFlightcharges);
		
		textField_5 = new JTextField();
		textField_5.setBounds(164, 267, 190, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblSeats.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSeats.setBounds(25, 312, 116, 20);
		contentPane.add(lblSeats);
		
		textField_6 = new JTextField();
		textField_6.setBounds(164, 311, 190, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDestination.setBounds(421, 68, 109, 31);
		contentPane.add(lblDestination);
		
		textField_7 = new JTextField();
		textField_7.setBounds(542, 74, 130, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		btnAddflight = new JButton("ADDFlight");
		btnAddflight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					PreparedStatement ps=con.prepareStatement("insert into FlightDetails(Flight_ID,Flight_Name,Source,Departure,Flight_Class,Flight_Charges,Seats,Destination,Arrival_Time)values(?,?,?,?,?,?,?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
					ps.setString(6,textField_5.getText());
					ps.setString(7,textField_6.getText());
					ps.setString(8,textField_7.getText());
					ps.setString(9,textField_8.getText());
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"insert successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"insert not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				
				}
		
			
		});
		btnAddflight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAddflight.setBounds(12, 359, 129, 25);
		contentPane.add(btnAddflight);
		
		btnUpdateflight = new JButton("UPDATEFlight");
		btnUpdateflight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					PreparedStatement ps=con.prepareStatement("update FlightDetails set Flight_ID=?,Flight_Name=?,Source=?,Departure=?,Flight_Class=?,Flight_Charges=?,Seats=?,Destination=? where Arrival_Time=?");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
					ps.setString(6,textField_5.getText());
					ps.setString(7,textField_6.getText());
					ps.setString(8,textField_7.getText());
					ps.setString(9,textField_8.getText());
						
					int i=ps.executeUpdate();
					
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"updated successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"updated  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				

				
			}
			
		});
		btnUpdateflight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdateflight.setBounds(104, 415, 184, 25);
		contentPane.add(btnUpdateflight);
		
		btnDeleteflight = new JButton("DELETEFlight");
		btnDeleteflight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					
					PreparedStatement ps=con.prepareStatement("delete from FlightDetails where Flight_Name=?");
							
					ps.setString(2,textField_1.getText());
					//ps.setString(3,textField_2.getText());
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"deleted successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"deleted not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				

				
			}
	
			
		});
		btnDeleteflight.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDeleteflight.setBounds(271, 356, 167, 31);
		contentPane.add(btnDeleteflight);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(435, 415, 97, 25);
		contentPane.add(btnExit);
		
		lblArrivaltime = new JLabel("Arrival_Time");
		lblArrivaltime.setVerticalAlignment(SwingConstants.BOTTOM);
		lblArrivaltime.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblArrivaltime.setBounds(405, 116, 125, 20);
		contentPane.add(lblArrivaltime);
		
		textField_8 = new JTextField();
		textField_8.setBounds(552, 116, 130, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\CHANDHINI\\Pictures\\Screenshots\\Screenshot (52).png"));
		label.setBounds(609, 164, 530, 390);
		contentPane.add(label);
	}

}
