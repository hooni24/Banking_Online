package server;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class ServerGUI extends JFrame {
	private JPanel p_main;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public ServerGUI() {
		setTitle("Banking Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(618,600);
				
						p_main = new JPanel();
						getContentPane().add(p_main);
						p_main.setLayout(new BorderLayout(0, 0));
						
						JPanel p_upper = new JPanel();
						p_upper.setPreferredSize(new Dimension(10, 140));
						p_main.add(p_upper, BorderLayout.NORTH);
						p_upper.setLayout(new BorderLayout(0, 0));
						
						JPanel p_upper_west = new JPanel();
						p_upper_west.setPreferredSize(new Dimension(120, 10));
						p_upper.add(p_upper_west, BorderLayout.WEST);
						p_upper_west.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						
						JButton btn_open = new JButton("Server Open");
						p_upper_west.add(btn_open);
						
						JButton btn_showall = new JButton("\uACE0\uAC1D\uC870\uD68C");
						p_upper_west.add(btn_showall);
						
						JPanel p_upper_center = new JPanel();
						p_upper.add(p_upper_center, BorderLayout.CENTER);
						p_upper_center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
						
						JLabel lbl_name = new JLabel("\uC774\uB984");
						lbl_name.setFont(new Font("굴림", Font.PLAIN, 30));
						p_upper_center.add(lbl_name);
						
						textField = new JTextField();
						textField.setPreferredSize(new Dimension(6, 30));
						textField.setEditable(false);
						p_upper_center.add(textField);
						textField.setColumns(30);
						
						JLabel lbl_jumin = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
						lbl_jumin.setFont(new Font("굴림", Font.PLAIN, 30));
						p_upper_center.add(lbl_jumin);
						
						textField_1 = new JTextField();
						textField_1.setPreferredSize(new Dimension(6, 30));
						textField_1.setEditable(false);
						p_upper_center.add(textField_1);
						textField_1.setColumns(30);
						
						JLabel lbl_address = new JLabel("\uC8FC\uC18C");
						lbl_address.setFont(new Font("굴림", Font.PLAIN, 30));
						p_upper_center.add(lbl_address);
						
						textField_2 = new JTextField();
						textField_2.setPreferredSize(new Dimension(6, 30));
						textField_2.setEditable(false);
						p_upper_center.add(textField_2);
						textField_2.setColumns(30);
						
						JPanel p_lower = new JPanel();
						p_main.add(p_lower, BorderLayout.CENTER);
						p_lower.setLayout(new GridLayout(1, 0, 0, 0));
						
						JScrollPane sp_table = new JScrollPane();
						p_lower.add(sp_table);
						
						table = new JTable();
						sp_table.setViewportView(table);
		
		setVisible(true);
	}//constructor
	
	public static void main(String[] args) {
		new ServerGUI();
	}//main

}//class
