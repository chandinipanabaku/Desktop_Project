import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private javax.swing.JTable jTable_Display_User1;
	protected Connection con;
	private JScrollPane jScrollPane1;
	private JLabel textField_8;
	//private JTextField textField_4;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
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
	public Reservation() {
		
	        initComponents();
	         Show_User1_In_JTable();
	         
	         
	         
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AIRLINE RESERVATION PROCESS");
		setBounds(100, 100, 1353, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSource = new JLabel("SOURCE");
		lblSource.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSource.setBounds(12, 13, 98, 16);
		contentPane.add(lblSource);
		
		
		JLabel lblDestination = new JLabel("DESTINATION");
		lblDestination.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDestination.setBounds(266, 13, 136, 16);
		contentPane.add(lblDestination);
		
		textField = new JTextField();
		textField.setBounds(936, 12, 178, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassengerid = new JLabel("PASSENGER_ID");
		lblPassengerid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassengerid.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPassengerid.setBounds(757, 11, 161, 22);
		contentPane.add(lblPassengerid);
		
		textField_1 = new JTextField();
		textField_1.setBounds(936, 53, 178, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassengername = new JLabel("PASSENGER_NAME");
		lblPassengername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassengername.setBounds(734, 46, 190, 25);
		contentPane.add(lblPassengername);
		
		textField_2 = new JTextField();
		textField_2.setBounds(936, 90, 178, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFathersname = new JLabel("FATHERS_NAME");
		lblFathersname.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFathersname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFathersname.setBounds(740, 87, 178, 24);
		contentPane.add(lblFathersname);
		
		textField_3 = new JTextField();
		textField_3.setBounds(936, 140, 178, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("PHONE_NUMBER");
		lblPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPhonenumber.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPhonenumber.setBounds(740, 139, 161, 22);
		contentPane.add(lblPhonenumber);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(757, 184, 136, 35);
		contentPane.add(lblAddress);
		
		textField_5 = new JTextField();
		textField_5.setBounds(936, 183, 178, 81);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDateofjourney = new JLabel("DATE_OF_JOURNEY");
		lblDateofjourney.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDateofjourney.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDateofjourney.setBounds(716, 286, 190, 22);
		contentPane.add(lblDateofjourney);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox_2.setBounds(936, 285, 67, 25);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_3.setBounds(1004, 285, 67, 25);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "2000", "2001", "2015", "2016", "2017", "2018", "2019"}));
		comboBox_4.setBounds(1070, 285, 67, 25);
		contentPane.add(comboBox_4);
		
		JLabel lblFlightid = new JLabel("FLIGHT_ID");
		lblFlightid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFlightid.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFlightid.setBounds(757, 331, 105, 22);
		contentPane.add(lblFlightid);
		
		textField_6 = new JTextField();
		textField_6.setBounds(936, 332, 178, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(936, 381, 178, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnBook = new JButton("BOOK");
		
		
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
					PreparedStatement ps=con.prepareStatement("insert into Passenger(Passenger_Id,Passenger_name,Phone_Number,Address,Flight_Id,Flight_Charges) values(?,?,?,?,?,?)");
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
						JOptionPane.showMessageDialog(null,"inserted successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"inserted  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				
				}
			});
		
		btnBook.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBook.setBounds(852, 469, 97, 25);
		contentPane.add(btnBook);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 0, 56, 16);
		contentPane.add(label);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch.setBounds(1182, 29, 118, 25);
		contentPane.add(btnSearch);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnView.setBounds(587, 11, 97, 25);
		contentPane.add(btnView);
		
		JLabel lblFLightcharges = new JLabel("Flight_Charges");
		lblFLightcharges.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFLightcharges.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblFLightcharges.setBounds(740, 381, 166, 22);
		contentPane.add(lblFLightcharges);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 12, 149, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(414, 11, 141, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
	
		jTable_Display_User1.setModel(new javax.swing.table.DefaultTableModel(
	             new Object [][] {

	             },
	             new String [] {
	                  "Source", "Destination"
	             }
	         ));
	         jTable_Display_User1.addMouseListener(new java.awt.event.MouseAdapter() {
	             public void mouseClicked(java.awt.event.MouseEvent evt) {
	                 jTable_Display_UsersMouseClicked(evt);
	             }
	         });
	         jScrollPane1.setViewportView(jTable_Display_User1);
			}
	private void initComponents() {
		// TODO Auto-generated method stub
		
	}

	private void Show_User1_In_JTable() {
		// TODO Auto-generated method stub
		
	}

	public Connection getConnection()
    {
        Connection con;
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	public ArrayList<User1> getUsersList()
    {
        ArrayList<User1> usersList = new ArrayList<User1>();
        Connection connection = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("select * from User1");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ps.setString(1,textField.getText());
		try {
			ps.setString(3,textField_2.getText());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ps.setString(5,textField_4.getText());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			int i=ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        
        String query = "SELECT * FROM  User1 ";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User1 user;
            while(rs.next())
            {
                user = new User1(rs.getString("Source"),rs.getString("Destination"));
                usersList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }
   
 
    public void Show_Users_In_JTable()
    {
        ArrayList<User1> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_User1.getModel();
        Object[] row = new Object[2];
        for(int i = 0; i < list.size(); i++)
        {
            //row[0] = list.get(i).getFlight_id();       //.getFlight_ID();
            //row[1] = list.get(i).getFlight_name();
            row[2] = list.get(i).getSource();
            //row[3] = list.get(i).getDeparture();
            row[4] = list.get(i).getDestination();
            //row[5] = list.get(i).getArrived_Time();
            //row[6] = list.get(i).getFlight_class();
            //row[7] = list.get(i).getFlight_charges();
            //row[8] = list.get(i).getSeats();


            
            
            model.addRow(row);
        }
     }
         
    // Execute The Insert Update And Delete Querys
    public void executeSQlQuery(String query, String message)
    {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
                // refresh jtable data
                DefaultTableModel model = (DefaultTableModel)jTable_Display_User1.getModel();
                model.setRowCount(0);
                Show_Users_In_JTable();
                
                JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
            }else{
                JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {                                                  
        // Get The Index Of The Slected Row 
         int i = jTable_Display_User1.getSelectedRow();

         TableModel model = jTable_Display_User1.getModel();
         
          // Display Slected Row In JTexteFields
        // textField.setText(model.getValueAt(i,0).toString());
         //textField_1.setText(model.getValueAt(i,1).toString());
         textField_2.setText(model.getValueAt(i,2).toString());
        // textField_3.setText(model.getValueAt(i,3).toString());
         textField_4.setText(model.getValueAt(i,4).toString());
         //textField_5.setText(model.getValueAt(i,5).toString());
         //textField_6.setText(model.getValueAt(i,6).toString());
         //textField_7.setText(model.getValueAt(i,7).toString());
         //textField_8.setText(model.getValueAt(i,8).toString());

         

     }    
		}

	//private void executeSQlQuery(String query, String string) {
		// TODO Auto-generated method stub
		
	//}

