import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JMenuBar;

public class MenuTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTable frame = new MenuTable();
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
	public MenuTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("AIR TRAVEL FORUM");
		this.isBackgroundSet();
		setBounds(100, 100, 842, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFlight = new JButton("Flight");
		btnFlight.setBackground(UIManager.getColor("Button.highlight"));
		btnFlight.setForeground(Color.BLACK);
		btnFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingJtable st=new SwingJtable();
				st.setVisible(true);
				dispose();
				
			}
		});
		btnFlight.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		btnFlight.setBounds(87, 200, 192, 49);
		contentPane.add(btnFlight);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(40, -62, 299, 57);
		contentPane.add(menuBar);
		
		JButton btnReservation = new JButton("Reservation");
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReservationPage r=new ReservationPage();
				r.setVisible(true);
				dispose();
			}
		});
		btnReservation.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnReservation.setBounds(107, 311, 192, 49);
		contentPane.add(btnReservation);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\CHANDHINI\\Pictures\\Screenshots\\Screenshot (39).png"));
		label.setBounds(-12, 13, 836, 413);
		contentPane.add(label);
	}
}
