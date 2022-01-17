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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextArea;

public class RemoveEmployee extends JFrame {

	private static final long serialVersionUID = -1139576615674166862L;
	private JPanel contentPane;
	private JLabel name_label;
	private JTextField name_field;
	private JButton removeButton;
	private JButton cancelButton;
	private JButton searchButton;
	private JTextArea textArea;
	private Connection connection = null;
	private String id = "0";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee frame = new RemoveEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RemoveEmployee() {
		connection = DatabaseConnection.dbconn();
		setResizable(false);
		setMinimumSize(new Dimension(600, 600));
		setMaximumSize(new Dimension(600, 600));
		setTitle("EMS - Remove Employee");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/ems_icon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Employee");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 564, 34);
		contentPane.add(lblNewLabel);
		
		name_label = new JLabel("Name");
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		name_label.setBounds(32, 119, 55, 18);
		contentPane.add(name_label);
		
		name_field = new JTextField();
		name_field.setHorizontalAlignment(SwingConstants.CENTER);
		name_field.setColumns(10);
		name_field.setBounds(95, 109, 195, 34);
		name_field.setBorder((BorderFactory.createLineBorder(Color.GRAY)));
		contentPane.add(name_field);
		
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
		
		removeButton = new JButton("REMOVE");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id != "0") {
					try {
						String myquery = "SELECT id FROM employee WHERE id=?";
						PreparedStatement statement = connection.prepareStatement(myquery);
						statement.setString(1, id);
		                ResultSet resultSet = statement.executeQuery();
						if(!resultSet.next()) {
							JOptionPane.showMessageDialog(null, "Can't find the employee to remove");
						}
						else {
							String query = "DELETE FROM employee WHERE id=?";
							PreparedStatement statement2 = connection.prepareStatement(query);
							statement2.setString(1, id);
							statement2.executeUpdate();
			                dispose();
			                JOptionPane.showMessageDialog(null, "Employee is removed from the database!");
			                RemoveEmployee removeEmployee = new RemoveEmployee();
			                removeEmployee.setVisible(true);
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeButton.setIcon(new ImageIcon(AddEmployee.class.getResource("/images/remove_icon.png")));
		removeButton.setForeground(Color.WHITE);
		removeButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		removeButton.setFocusPainted(false);
		removeButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		removeButton.setBackground(new Color(72, 61, 139));
		removeButton.setBounds(21, 464, 260, 44);
		removeButton.setVisible(false);
		contentPane.add(removeButton);
		
		searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_field.getText();
				if (name.length() > 0) {
					try {
						String query = "SELECT * FROM employee where name=?";
						PreparedStatement statement = connection.prepareStatement(query);
						statement.setString(1, name);
						ResultSet resultSet = statement.executeQuery();
						if(resultSet.next()) {
							id = resultSet.getString("id");
							String data = "";
							data += "ID : " + resultSet.getString("id") + "\n";
							data += "Name : " + resultSet.getString("name") + "\n";
							data += "Age : " + resultSet.getString("age") + "\n";
							data += "DOB : " + resultSet.getString("dob") + "\n";
							data += "Address : " + resultSet.getString("address") + "\n";
							data += "Email : " + resultSet.getString("email") + "\n";
							data += "Contact # : " + resultSet.getString("contact_number") + "\n";
							data += "Education : " + resultSet.getString("education") + "\n";
							data += "Job Post : " + resultSet.getString("job_post") + "\n";
							data += "Salary : " + resultSet.getString("salary") + "\n";
							data += "Join Date : " + resultSet.getString("join_date") + "\n";
							textArea.setText(data);
			                removeButton.setVisible(true);
						}
						else {
							textArea.setText("");
							removeButton.setVisible(false);
							id = "0";
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
					
			}
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		searchButton.setFocusPainted(false);
		searchButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		searchButton.setBackground(new Color(72, 61, 139));
		searchButton.setBounds(324, 109, 229, 34);
		contentPane.add(searchButton);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textArea.setBounds(32, 170, 521, 225);
		contentPane.add(textArea);

	}
}
