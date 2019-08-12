import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class LoginPage extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
				public void close(){
					 
					 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
					 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
					 
					 }
	

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setBounds(203, 21, 71, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(77, 77, 63, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(77, 126, 63, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(170, 74, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 123, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password =textField.getText();
				String username =passwordField.getText();
				if(password.contains("venkatesh")&&username.contains("1234")) {
					//textField.setText(null);
					//passwordField.setText(null);
					//Menu mn=new Menu();
					//mn.setVisible(true);
					//Menu.main(null);
					close();
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
			}
		});
		btnLogin.setBounds(170, 205, 89, 23);
		contentPane.add(btnLogin);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 168, 402, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 52, 402, 2);
		contentPane.add(separator_1);
	}
}


