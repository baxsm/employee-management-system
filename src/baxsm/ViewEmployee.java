package baxsm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.text.DocumentException;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewEmployee extends JFrame {

	private static final long serialVersionUID = 2842798972114583192L;
	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JTextField nameField;
	private JTable table;
	private Connection connection;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee frame = new ViewEmployee();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewEmployee() {
		connection = DatabaseConnection.dbconn();
		setMinimumSize(new Dimension(920, 460));
		setMaximumSize(new Dimension(920, 460));
		setTitle("EMS - View Employee");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/ems_icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Employee");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 884, 34);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 127, 828, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox<String>();
		comboBox.setVisible(false);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFocusTraversalKeysEnabled(false);
		comboBox.setFocusable(false);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(232, 371, 215, 34);
		comboBox.addItem("Excel");
		comboBox.addItem("PDF");
		contentPane.add(comboBox);
		
		JButton exportButton = new JButton("EXPORT");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = comboBox.getSelectedItem().toString();
				if (item == "Excel") {
					ExportExcel.export(table);
					JOptionPane.showMessageDialog(null, "Data is exported to Excel File");
				}
				else if (item == "PDF") {
					try {
						ExportPDF.export(table);
						JOptionPane.showMessageDialog(null, "Data is exported to PDF File");
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1);
					} catch (DocumentException e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		exportButton.setVisible(false);
		exportButton.setIcon(new ImageIcon(ViewEmployee.class.getResource("/images/export_icon.png")));
		exportButton.setBounds(523, 366, 260, 44);
		exportButton.setForeground(Color.WHITE);
		exportButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		exportButton.setFocusPainted(false);
		exportButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		exportButton.setBackground(new Color(72, 61, 139));
		contentPane.add(exportButton);
		
		JButton searchButton = new JButton("SEARCH");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				if (name.length() > 0) {
					if (name.equals("*")) {
						try {
							String query = "SELECT * FROM employee";
							PreparedStatement statement = connection.prepareStatement(query);
							ResultSet resultSet = statement.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(resultSet));
							exportButton.setVisible(true);
							comboBox.setVisible(true);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					}
					else {
						try {
							String myquery = "SELECT id FROM employee WHERE name=?";
							PreparedStatement statement1 = connection.prepareStatement(myquery);
							statement1.setString(1, name);
			                ResultSet results = statement1.executeQuery();
							if(!results.next()) {
								JOptionPane.showMessageDialog(null, "Can't find the employee");
							}
							else {
								String query = "SELECT * FROM employee where name=?";
								PreparedStatement statement = connection.prepareStatement(query);
								statement.setString(1, name);
								ResultSet resultSet = statement.executeQuery();
								table.setModel(DbUtils.resultSetToTableModel(resultSet));
								exportButton.setVisible(true);
								comboBox.setVisible(true);
							}
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					}
				}
			}
		});
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		searchButton.setFocusPainted(false);
		searchButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		searchButton.setBackground(new Color(72, 61, 139));
		searchButton.setBounds(523, 72, 260, 44);
		contentPane.add(searchButton);
		
		nameField = new JTextField();
		nameField.setText("*");
		nameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setBounds(248, 81, 199, 27);
		contentPane.add(nameField);
		nameField.setColumns(10);
	}
}
