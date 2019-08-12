import java.awt.EventQueue;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
public class AmountDetails {
protected static final Date Chooser = null;
private JFrame frame;
	private JTextField textNoP;
	private JTextField textNumberOfTickets;
    int tktno;
    private JTextField textEmail;
	private int Select;
	private int from;
	private String source;
	private String flightid;
	private String PassengerName;
	private String flightCharges;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmountDetails window = new AmountDetails(null,null);
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
	public AmountDetails(String src ,String dstn)
	{
		Container picker1 = null ;
		initialize(src,dstn);
		frame.setVisible(true);
		
	}

	
	

	public AmountDetails() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Initialize the contents of the frame.
	 * @param <ShowTicket>
	 * @param panel 
	 */
	private <ShowTicket> void initialize(String src,String destination) {
		frame = new JFrame("TicketDetails");
		frame.setForeground(Color.YELLOW);
		frame.setSize(650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel LBusNo = new JLabel("FlightId :");
		LBusNo.setBounds(80, 40, 150, 20);
		frame.getContentPane().add(LBusNo);
		
		JLabel LBustype = new JLabel("PassengerName :");
		LBustype.setBounds(80, 80, 150, 20);
		frame.getContentPane().add(LBustype);
	
		JLabel LSource = new JLabel("Source :");
		LSource.setBounds(80, 124, 150, 17);
		frame.getContentPane().add(LSource);
		
		JLabel LDestination = new JLabel("Destination :");
		LDestination.setBounds(80, 160, 150, 20);
		frame.getContentPane().add(LDestination);
		
		JLabel LFlightCharge = new JLabel("FlightCharge :");
		LFlightCharge.setBounds(80, 200, 150, 20);
		frame.getContentPane().add(LFlightCharge);
		
				
		JLabel L1FlightId = new JLabel("");
		L1FlightId.setBounds(350, 52, 200, 20);
		frame.getContentPane().add(L1FlightId);
		
		
		JLabel L1PassengerName = new JLabel("");
		L1PassengerName.setBounds(350, 80, 200, 20);
		frame.getContentPane().add(L1PassengerName);
		
		
		JLabel L1Source = new JLabel("");
		L1Source.setBounds(350, 124, 200, 20);
		frame.getContentPane().add(L1Source);
		
		
		JLabel L1Destination = new JLabel("");
		L1Destination.setBounds(350, 167, 200, 20);
		frame.getContentPane().add(L1Destination);
		
		JLabel L1FlightCharges = new JLabel("");
		L1FlightCharges.setBounds(350, 210, 200, 20);
		frame.getContentPane().add(L1FlightCharges);
		
		//JButton ConfirmButton = new JButton("Confirm");
		//ConfirmButton.setBounds(115, 499, 89, 23);
		//frame.getContentPane().add(ConfirmButton);
		
		//JXDatePicker picker = new JXDatePicker();
		//picker.setDate(Calendar.getInstance().getTime());
		//picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		//picker.setBounds(350, 404, 150, 20);
		//frame.getContentPane().add(picker);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","123");		

		Statement st = cn.createStatement();
		
		String Sql="Select * from Passengers where FlightId="+flightid+",PassengerName="+PassengerName+",source="+source+",destination="+destination+",FlightCharges="+flightCharges+"";
		ResultSet rs = st.executeQuery(Sql);
		if(rs.next())
		{
			System.out.println("searched success");
			L1FlightId.setText(rs.getString(1));
			
			L1PassengerName.setText(rs.getString(2));
			L1Source.setText(rs.getString(3));
			L1Destination.setText(rs.getString(4));
			L1FlightCharges.setText(rs.getString(5));
			System.out.println("after searched success");
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Route not found");
		}
		
		cn.close();
		}
		
		
		catch(ClassNotFoundException e1)
		{
			e1.printStackTrace();
		}
		
		
		
		catch(SQLException s) { 
		System.out.println(s);
		}
		
	}
	//public void setVisible(boolean b) {
		// TODO Auto-generated method stub
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
		
	//}
}


