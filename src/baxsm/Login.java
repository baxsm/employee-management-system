package baxsm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	private static final long serialVersionUID = -4695890766635056626L;
	private JPanel contentPane;
	private JTextField username_field;
	private JPasswordField password_field;
	private Connection connection = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					//frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
		connection = DatabaseConnection.dbconn();
	}
	
	private void initialize() {
		setMinimumSize(new Dimension(920, 460));
		setMaximumSize(new Dimension(920, 460));
		setTitle("EMS - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/ems_icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/ems_icon.png")));
		lblNewLabel_1.setBounds(192, 103, 96, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel arid_no_1 = new JLabel("18-ARID-3040");
		arid_no_1.setForeground(Color.WHITE);
		arid_no_1.setFont(new Font("Calibri", Font.BOLD, 14));
		arid_no_1.setBackground(Color.WHITE);
		arid_no_1.setBounds(123, 320, 103, 14);
		contentPane.add(arid_no_1);
		
		JLabel name_1 = new JLabel("Sheikh Babar Ali");
		name_1.setBackground(Color.WHITE);
		name_1.setForeground(Color.WHITE);
		name_1.setFont(new Font("Calibri", Font.BOLD, 14));
		name_1.setBounds(10, 320, 103, 14);
		contentPane.add(name_1);
		
		JLabel ems_name = new JLabel("Employee Management System");
		ems_name.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		ems_name.setBackground(Color.WHITE);
		ems_name.setForeground(Color.WHITE);
		ems_name.setBounds(84, 181, 315, 30);
		contentPane.add(ems_name);
		
		JLabel name_2 = new JLabel("Osama Malik");
		name_2.setForeground(Color.WHITE);
		name_2.setFont(new Font("Calibri", Font.BOLD, 14));
		name_2.setBackground(Color.WHITE);
		name_2.setBounds(10, 341, 103, 14);
		contentPane.add(name_2);
		
		JLabel name_3 = new JLabel("Adnan Hafeez");
		name_3.setForeground(Color.WHITE);
		name_3.setFont(new Font("Calibri", Font.BOLD, 14));
		name_3.setBackground(Color.WHITE);
		name_3.setBounds(10, 360, 103, 18);
		contentPane.add(name_3);
		
		JLabel arid_no_2 = new JLabel("18-ARID-3034");
		arid_no_2.setForeground(Color.WHITE);
		arid_no_2.setFont(new Font("Calibri", Font.BOLD, 14));
		arid_no_2.setBackground(Color.WHITE);
		arid_no_2.setBounds(123, 339, 103, 14);
		contentPane.add(arid_no_2);
		
		JLabel arid_no_3 = new JLabel("18-ARID-2998");
		arid_no_3.setForeground(Color.WHITE);
		arid_no_3.setFont(new Font("Calibri", Font.BOLD, 14));
		arid_no_3.setBackground(Color.WHITE);
		arid_no_3.setBounds(123, 360, 103, 14);
		contentPane.add(arid_no_3);
		
		JLabel left_background = new JLabel("");
		left_background.setBackground(Color.BLUE);
		left_background.setForeground(Color.BLUE);
		left_background.setIcon(new ImageIcon(Login.class.getResource("/images/login_bg.png")));
		left_background.setBounds(0, 0, 497, 421);
		contentPane.add(left_background);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(550, 110, 77, 30);
		contentPane.add(lblNewLabel);
		
		username_field = new JTextField();
		username_field.setHorizontalAlignment(SwingConstants.CENTER);
		username_field.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		username_field.setFont(new Font("Calibri", Font.PLAIN, 16));
		username_field.setBounds(593, 137, 246, 30);
		contentPane.add(username_field);
		username_field.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setBounds(550, 178, 77, 30);
		contentPane.add(lblPassword);
		
		password_field = new JPasswordField();
		password_field.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		password_field.setHorizontalAlignment(SwingConstants.CENTER);
		password_field.setFont(new Font("Calibri", Font.PLAIN, 14));
		password_field.setDisabledTextColor(new Color(0, 0, 255));
		password_field.setBounds(593, 205, 246, 30);
		contentPane.add(password_field);
		
		JLabel error_label = new JLabel("");
		error_label.setHorizontalAlignment(SwingConstants.CENTER);
		error_label.setForeground(new Color(255, 0, 0));
		error_label.setFont(new Font("Calibri", Font.PLAIN, 12));
		error_label.setBounds(593, 85, 246, 14);
		contentPane.add(error_label);
		
		JButton login_button = new JButton("LOGIN");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = username_field.getText();
				String password = new String(password_field.getPassword());
				if(username.length() != 0 && password.length() != 0) {
					try {
						String myquery = "SELECT username, password FROM admin WHERE username=? AND password=?";
						PreparedStatement statement = connection.prepareStatement(myquery);
						statement.setString(1, username);
						statement.setString(2, password);
		                ResultSet resultSet = statement.executeQuery();
		                if(resultSet.next()) {
		                	dispose();
		                	Home home = new Home();
		                	home.setVisible(true);
		                	}
		                else {
		                	error_label.setText("Wrong Credentials!!");;
		                	}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}	
				}
			}
		});
		login_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login_button.setFocusPainted(false);
		login_button.setBackground(new Color(51, 0, 153));
		login_button.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		login_button.setForeground(new Color(255, 255, 255));
		login_button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		login_button.setBounds(593, 267, 246, 30);
		contentPane.add(login_button);
	}
}
