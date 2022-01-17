package baxsm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 2491633462155546045L;
	private JPanel contentPane;
	private JTextField id_field;
	private JLabel name_label;
	private JTextField name_field;
	private JTextField age_field;
	private JLabel age_label;
	private JTextField dob_field;
	private JLabel dob_label;
	private JTextField address_field;
	private JLabel address_label;
	private JTextField email_field;
	private JLabel email_label;
	private JTextField contact_field;
	private JLabel contact_label;
	private JTextField education_field;
	private JLabel education_label;
	private JTextField job_post_field;
	private JLabel job_post_label;
	private JTextField salary_field;
	private JLabel salary_label;
	private JTextField join_date_field;
	private JLabel join_date_label;
	private JButton submitButton;
	private JButton cancelButton;
	private Connection connection = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddEmployee() {
		connection = DatabaseConnection.dbconn();
		setResizable(false);
		setMinimumSize(new Dimension(600, 600));
		setMaximumSize(new Dimension(600, 600));
		setTitle("EMS - Add Employee");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/ems_icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Employee");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 564, 34);
		contentPane.add(lblNewLabel);
		
		JLabel id_label = new JLabel("ID");
		id_label.setHorizontalAlignment(SwingConstants.CENTER);
		id_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		id_label.setBounds(32, 95, 55, 18);
		contentPane.add(id_label);
		
		id_field = new JTextField();
		id_field.setDisabledTextColor(new Color(255, 255, 255));
		id_field.setEditable(false);
		id_field.setHorizontalAlignment(SwingConstants.CENTER);
		id_field.setBounds(87, 85, 195, 34);
		id_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(id_field);
		id_field.setColumns(10);
		
		name_label = new JLabel("Name");
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		name_label.setBounds(315, 95, 55, 18);
		contentPane.add(name_label);
		
		name_field = new JTextField();
		name_field.setHorizontalAlignment(SwingConstants.CENTER);
		name_field.setColumns(10);
		name_field.setBounds(370, 85, 195, 34);
		name_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(name_field);
		
		age_field = new JTextField();
		age_field.setHorizontalAlignment(SwingConstants.CENTER);
		age_field.setColumns(10);
		age_field.setBounds(87, 141, 195, 34);
		age_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(age_field);
		
		age_label = new JLabel("Age");
		age_label.setHorizontalAlignment(SwingConstants.CENTER);
		age_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		age_label.setBounds(32, 151, 55, 18);
		contentPane.add(age_label);
		
		dob_field = new JTextField();
		dob_field.setHorizontalAlignment(SwingConstants.CENTER);
		dob_field.setColumns(10);
		dob_field.setBounds(370, 141, 195, 34);
		dob_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(dob_field);
		
		dob_label = new JLabel("DOB");
		dob_label.setHorizontalAlignment(SwingConstants.CENTER);
		dob_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		dob_label.setBounds(315, 151, 55, 18);
		contentPane.add(dob_label);
		
		address_field = new JTextField();
		address_field.setHorizontalAlignment(SwingConstants.CENTER);
		address_field.setColumns(10);
		address_field.setBounds(87, 195, 195, 34);
		address_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(address_field);
		
		address_label = new JLabel("Address");
		address_label.setHorizontalAlignment(SwingConstants.CENTER);
		address_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		address_label.setBounds(32, 205, 55, 18);
		contentPane.add(address_label);
		
		email_field = new JTextField();
		email_field.setHorizontalAlignment(SwingConstants.CENTER);
		email_field.setColumns(10);
		email_field.setBounds(370, 195, 195, 34);
		email_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(email_field);
		
		email_label = new JLabel("Email");
		email_label.setHorizontalAlignment(SwingConstants.CENTER);
		email_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		email_label.setBounds(315, 205, 55, 18);
		contentPane.add(email_label);
		
		contact_field = new JTextField();
		contact_field.setHorizontalAlignment(SwingConstants.CENTER);
		contact_field.setColumns(10);
		contact_field.setBounds(87, 250, 195, 34);
		contact_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(contact_field);
		
		contact_label = new JLabel("Contact #");
		contact_label.setHorizontalAlignment(SwingConstants.CENTER);
		contact_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		contact_label.setBounds(21, 260, 66, 18);
		contentPane.add(contact_label);
		
		education_field = new JTextField();
		education_field.setHorizontalAlignment(SwingConstants.CENTER);
		education_field.setColumns(10);
		education_field.setBounds(370, 250, 195, 34);
		education_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(education_field);
		
		education_label = new JLabel("Education");
		education_label.setHorizontalAlignment(SwingConstants.CENTER);
		education_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		education_label.setBounds(304, 260, 66, 18);
		contentPane.add(education_label);
		
		job_post_field = new JTextField();
		job_post_field.setHorizontalAlignment(SwingConstants.CENTER);
		job_post_field.setColumns(10);
		job_post_field.setBounds(87, 304, 195, 34);
		job_post_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(job_post_field);
		
		job_post_label = new JLabel("Job Post");
		job_post_label.setHorizontalAlignment(SwingConstants.CENTER);
		job_post_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		job_post_label.setBounds(21, 314, 66, 18);
		contentPane.add(job_post_label);
		
		salary_field = new JTextField();
		salary_field.setHorizontalAlignment(SwingConstants.CENTER);
		salary_field.setColumns(10);
		salary_field.setBounds(370, 304, 195, 34);
		salary_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(salary_field);
		
		salary_label = new JLabel("Salary");
		salary_label.setHorizontalAlignment(SwingConstants.CENTER);
		salary_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		salary_label.setBounds(315, 314, 55, 18);
		contentPane.add(salary_label);
		
		join_date_field = new JTextField();
		join_date_field.setHorizontalAlignment(SwingConstants.CENTER);
		join_date_field.setColumns(10);
		join_date_field.setBounds(87, 357, 195, 34);
		join_date_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(join_date_field);
		
		join_date_label = new JLabel("Join Date");
		join_date_label.setHorizontalAlignment(SwingConstants.CENTER);
		join_date_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		join_date_label.setBounds(21, 367, 66, 18);
		contentPane.add(join_date_label);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cancelButton.setFocusPainted(false);
		cancelButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		cancelButton.setBackground(new Color(72, 61, 139));
		cancelButton.setBounds(304, 464, 260, 44);
		contentPane.add(cancelButton);
		
		submitButton = new JButton("SUBMIT");
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if data is valid or not and then add data to database
				if (validate_data() == 0) {
					try {
						String id = id_field.getText();
						String name = name_field.getText();
						int age = Integer.valueOf(age_field.getText());
						String dob = dob_field.getText();
						String address = address_field.getText();
						String email = email_field.getText();
						String contact_number = contact_field.getText();
						String education = education_field.getText();
						String job_post = job_post_field.getText();
						int salary = Integer.valueOf(salary_field.getText());
						String join_date = join_date_field.getText();
						String query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, id);
						statement.setString(2, name);
						statement.setInt(3, age);
						statement.setString(4, dob);
						statement.setString(5, address);
						statement.setString(6, email);
						statement.setString(7, contact_number);
						statement.setString(8, education);
						statement.setString(9, job_post);
						statement.setInt(10, salary);
						statement.setString(11, join_date);
		                statement.executeUpdate();
		                dispose();
		                JOptionPane.showMessageDialog(null, "Employee is added to the database!");
		                AddEmployee addEmployee = new AddEmployee();
		                addEmployee.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}	
				}
				
			}
		});
		submitButton.setIcon(new ImageIcon(AddEmployee.class.getResource("/images/add_icon.png")));
		submitButton.setForeground(Color.WHITE);
		submitButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		submitButton.setFocusPainted(false);
		submitButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		submitButton.setBackground(new Color(72, 61, 139));
		submitButton.setBounds(21, 464, 260, 44);
		contentPane.add(submitButton);
		
		String uniqueID = UUID.randomUUID().toString();
		id_field.setText(uniqueID.substring(0, 5));
	}
	
	public int validate_data() {
		if(name_field.getText().equals("")) {
			name_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			name_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(age_field.getText().equals("")) {
			age_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			age_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(dob_field.getText().equals("")) {
			dob_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			dob_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(address_field.getText().equals("")) {
			address_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			address_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(email_field.getText().equals("")) {
			email_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			email_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(contact_field.getText().equals("")) {
			contact_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			contact_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(education_field.getText().equals("")) {
			education_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			education_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(job_post_field.getText().equals("")) {
			job_post_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			job_post_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(salary_field.getText().equals("")) {
			salary_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			salary_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		if(join_date_field.getText().equals("")) {
			join_date_field.setBorder((BorderFactory.createLineBorder(Color.red)));
			return 1;
		}
		else {
			join_date_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		}
		return 0;
	}
}
