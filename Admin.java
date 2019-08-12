import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setBackground(SystemColor.activeCaptionBorder);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("AIRLINE RESERVATION SYSTEM");
		setBounds(100, 100, 646, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminlogin = new JLabel("ADMINLOGIN");
		lblAdminlogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblAdminlogin.setBounds(208, 13, 129, 28);
		contentPane.add(lblAdminlogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUsername.setBounds(90, 69, 105, 16);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(227, 67, 210, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(90, 116, 105, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 114, 210, 22);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password =textField.getText();
				String username =passwordField.getText();
				if(password.contains("Chandhini")&&username.contains("1234")) {
					textField.setText(null);
					passwordField.setText(null);
					MenuTable mn=new MenuTable();
					mn.setVisible(true);
					//Menu.main(null);
					dispose();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
			}	
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLogin.setBounds(227, 413, 110, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(169, 169, 169));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\CHANDHINI\\Pictures\\Screenshots\\Screenshot (43).png"));
		lblNewLabel.setBounds(0, 13, 1060, 514);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		lblNewLabel.setLabelFor(label);
		label.setBounds(227, 88, 149, 16);
		contentPane.add(label);
		
		table = new JTable();
		table.setBounds(559, 127, 24, -38);
		contentPane.add(table);
		
		JLabel lblNewJgoodiesLabe = DefaultComponentFactory.getInstance().createLabel("New JGoodies labe");
		lblNewJgoodiesLabe.setBounds(85, 179, 110, -60);
		contentPane.add(lblNewJgoodiesLabe);
	}
}
