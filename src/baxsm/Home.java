package baxsm;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 5177117176840665914L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setMinimumSize(new Dimension(920, 460));
		setMaximumSize(new Dimension(920, 460));
		setTitle("EMS - Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/ems_icon.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel logout_button = new JLabel("");
		logout_button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		
		logout_button.setIcon(new ImageIcon(Home.class.getResource("/images/exit_icon.png")));
		logout_button.setBounds(10, 373, 60, 37);
		contentPane.add(logout_button);
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setSelected(true);
		btnNewButton.setSelectedIcon(null);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBorder(new LineBorder(new Color(25, 25, 112), 1, true));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBounds(0, 163, 242, 37);
		contentPane.add(btnNewButton);
		
		JLabel divider = new JLabel("__________________");
		divider.setHorizontalAlignment(SwingConstants.CENTER);
		divider.setFont(new Font("Calibri", Font.BOLD, 14));
		divider.setForeground(Color.WHITE);
		divider.setBounds(0, 124, 242, 14);
		contentPane.add(divider);
		
		JLabel ems_name = new JLabel("EMS");
		ems_name.setHorizontalAlignment(SwingConstants.CENTER);
		ems_name.setForeground(Color.WHITE);
		ems_name.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		ems_name.setBounds(0, 102, 242, 25);
		contentPane.add(ems_name);
		
		JLabel ems_logo_icon = new JLabel("");
		ems_logo_icon.setHorizontalAlignment(SwingConstants.CENTER);
		ems_logo_icon.setIcon(new ImageIcon(Home.class.getResource("/images/ems_icon.png")));
		ems_logo_icon.setBounds(0, 27, 242, 64);
		contentPane.add(ems_logo_icon);
		
		JLabel left_banner = new JLabel("");
		left_banner.setIcon(new ImageIcon(Home.class.getResource("/images/login_bg.png")));
		left_banner.setBounds(0, 0, 242, 421);
		contentPane.add(left_banner);
		
		JButton addButton = new JButton("Add Employee");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee addEmployee = new AddEmployee();
				addEmployee.setVisible(true);
			}
		});
		addButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		addButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		addButton.setForeground(new Color(255, 255, 255));
		addButton.setBackground(new Color(72, 61, 139));
		addButton.setFocusPainted(false);
		addButton.setIcon(new ImageIcon(Home.class.getResource("/images/add_icon.png")));
		addButton.setBounds(280, 124, 260, 44);
		contentPane.add(addButton);
		
		JButton removeButton = new JButton("Remove Employee");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveEmployee removeEmployee = new RemoveEmployee();
				removeEmployee.setVisible(true);
			}
		});
		removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeButton.setIcon(new ImageIcon(Home.class.getResource("/images/remove_icon.png")));
		removeButton.setForeground(Color.WHITE);
		removeButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		removeButton.setFocusPainted(false);
		removeButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		removeButton.setBackground(new Color(72, 61, 139));
		removeButton.setBounds(608, 124, 260, 44);
		contentPane.add(removeButton);
		
		JButton updateButton = new JButton("Update Employee");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateEmployee updateEmployee = new UpdateEmployee();
				updateEmployee.setVisible(true);
			}
		});
		updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateButton.setIcon(new ImageIcon(Home.class.getResource("/images/update_icon.png")));
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		updateButton.setFocusPainted(false);
		updateButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		updateButton.setBackground(new Color(72, 61, 139));
		updateButton.setBounds(280, 205, 260, 44);
		contentPane.add(updateButton);
		
		JButton viewButton = new JButton("View Employee");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployee viewEmployee = new ViewEmployee();
				viewEmployee.setVisible(true);
			}
		});
		viewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewButton.setIcon(new ImageIcon(Home.class.getResource("/images/export_icon.png")));
		viewButton.setForeground(Color.WHITE);
		viewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		viewButton.setFocusPainted(false);
		viewButton.setBorder(new LineBorder(new Color(123, 104, 238), 1, true));
		viewButton.setBackground(new Color(72, 61, 139));
		viewButton.setBounds(608, 205, 260, 44);
		contentPane.add(viewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(242, -11, 4, 442);
		contentPane.add(btnNewButton_1);
	}
}
