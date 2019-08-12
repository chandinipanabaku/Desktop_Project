import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class HomePage extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AIRLINE RESERVATION SYSTEM");
		setBounds(100, 100, 641, 515);
		getContentPane().setLayout(null);
		
		JLabel lblWelcomeToAirlines = new JLabel("WELCOME TO AIRLINES");
		lblWelcomeToAirlines.setBackground(new Color(0, 0, 0));
		lblWelcomeToAirlines.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblWelcomeToAirlines.setBounds(247, 183, 318, 34);
		getContentPane().add(lblWelcomeToAirlines);
		
		JButton btnAdminlogin = new JButton("ADMINLOGIN");
		btnAdminlogin.setBackground(Color.WHITE);
		btnAdminlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a=new Admin();
				a.setVisible(true);
			}
		});
		btnAdminlogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdminlogin.setBounds(300, 256, 171, 40);
		getContentPane().add(btnAdminlogin);
		
		JLabel label = new JLabel("New label");
		label.setBackground(Color.BLACK);
		label.setIcon(new ImageIcon("C:\\Users\\CHANDHINI\\Pictures\\Screenshots\\Screenshot (41).png"));
		label.setBounds(-139, 0, 922, 474);
		getContentPane().add(label);
	}
}
