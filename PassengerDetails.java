import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class PassengerDetails extends JFrame {

	private JPanel contentPane;
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
					
					
					
					
					
					
					PassengerDetails frame = new PassengerDetails();
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
	public PassengerDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AIR TRAVEL FORUM");
		setBounds(100, 100, 742, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassengerdetails = new JLabel("PassengerDetails");
		lblPassengerdetails.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblPassengerdetails.setBounds(188, -20, 295, 77);
		contentPane.add(lblPassengerdetails);
		
		JLabel lblPASSENGER_ID = new JLabel("PASSENGER_ID");
		lblPASSENGER_ID.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPASSENGER_ID.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPASSENGER_ID.setBounds(36, 54, 159, 31);
		contentPane.add(lblPASSENGER_ID);
		
		JLabel lblFIRST_Name = new JLabel("FIRST_NAME");
		lblFIRST_Name.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFIRST_Name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblFIRST_Name.setBounds(36, 98, 159, 16);
		contentPane.add(lblFIRST_Name);
		
		textField = new JTextField();
		textField.setBounds(218, 63, 203, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 96, 203, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLAST_Name = new JLabel("LAST_NAME");
		lblLAST_Name.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLAST_Name.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLAST_Name.setBounds(36, 127, 141, 31);
		contentPane.add(lblLAST_Name);
		
		textField_2 = new JTextField();
		textField_2.setBounds(218, 136, 203, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail_Id = new JLabel("EMAIL_ID");
		lblEmail_Id.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEmail_Id.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEmail_Id.setBounds(46, 166, 114, 27);
		contentPane.add(lblEmail_Id);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 171, 203, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddress.setBounds(36, 206, 95, 60);
		contentPane.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setBounds(218, 206, 203, 97);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblContact_No = new JLabel("CONTACT_NO");
		lblContact_No.setVerticalAlignment(SwingConstants.BOTTOM);
		lblContact_No.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblContact_No.setBounds(36, 331, 124, 27);
		contentPane.add(lblContact_No);
		
		textField_5 = new JTextField();
		textField_5.setBounds(218, 332, 203, 35);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
	PreparedStatement ps=con.prepareStatement("insert into PassengerDetails(PASSENGER_ID,FIRST_NAME,LAST_NAME,EMAIL_ID,ADDRESS,CONTACT_NO)values(?,?,?,?,?,?)");
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
						JOptionPane.showMessageDialog(null,"insert successfully");
						dispose();
					}
					else
				{
						JOptionPane.showMessageDialog(null,"insert  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				
				//return status;

				
				
				}	
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBounds(556, 95, 131, 25);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
PreparedStatement ps=con.prepareStatement("update PassengerDetails set PASSENGER_ID=?,FIRST_NAME=?,LAST_NAME=?,EMAIL_ID=?,ADDRESS=?where CONTACT_NO=?");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
					ps.setString(6,textField_5.getText());

					int i=ps.executeUpdate();
					//con.close();
					if(i>0)
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
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBounds(556, 163, 131, 25);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					
					PreparedStatement ps=con.prepareStatement("delete from PassengerDetails where Passenger_ID=?");
							
					ps.setString(1,textField.getText());
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
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBounds(556, 235, 131, 27);
		
		contentPane.add(btnDelete);
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTable mt=new MenuTable();
				mt.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(556, 310, 131, 25);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\CHANDHINI\\Pictures\\Screenshots\\Screenshot (49).png"));
		label.setBounds(26, -90, 968, 646);
		contentPane.add(label);
	}
}
