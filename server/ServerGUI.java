package server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ServerGUI extends JFrame implements ActionListener, Runnable {
	private JPanel p_main;
	private JTable table;
	private JTextField tf_name;
	private JTextField tf_jumin;
	private JTextField tf_address;
	private JButton btn_showall, btn_open;
	private JLabel lbl_name, lbl_address;

	public ServerGUI() {
		setTitle("Banking Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(618, 600);

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

		btn_open = new JButton("Server Open");
		btn_open.addActionListener(this);
		p_upper_west.add(btn_open);

		btn_showall = new JButton("\uACE0\uAC1D\uC870\uD68C");
		p_upper_west.add(btn_showall);

		JPanel p_upper_center = new JPanel();
		p_upper.add(p_upper_center, BorderLayout.CENTER);
		p_upper_center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lbl_name = new JLabel("\uC774\uB984");
		lbl_name.setFont(new Font("굴림", Font.PLAIN, 30));
		p_upper_center.add(lbl_name);

		tf_name = new JTextField();
		tf_name.setPreferredSize(new Dimension(6, 30));
		tf_name.setEditable(false);
		p_upper_center.add(tf_name);
		tf_name.setColumns(30);

		JLabel lbl_jumin = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		lbl_jumin.setFont(new Font("굴림", Font.PLAIN, 30));
		p_upper_center.add(lbl_jumin);

		tf_jumin = new JTextField();
		tf_jumin.setPreferredSize(new Dimension(6, 30));
		tf_jumin.setEditable(false);
		p_upper_center.add(tf_jumin);
		tf_jumin.setColumns(30);

		lbl_address = new JLabel("\uC8FC\uC18C");
		lbl_address.setFont(new Font("굴림", Font.PLAIN, 30));
		p_upper_center.add(lbl_address);

		tf_address = new JTextField();
		tf_address.setPreferredSize(new Dimension(6, 30));
		tf_address.setEditable(false);
		p_upper_center.add(tf_address);
		tf_address.setColumns(30);

		JPanel p_lower = new JPanel();
		p_main.add(p_lower, BorderLayout.CENTER);
		p_lower.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane sp_table = new JScrollPane();
		p_lower.add(sp_table);

		table = new JTable();
		sp_table.setViewportView(table);

		setVisible(true);
	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btn_open){
			new Thread(this).start();
			btn_open.setEnabled(false);
		}//if btn_open
	}//actionPerformed()

	@Override
	public void run() {
		try {
			ServerSocket server = new ServerSocket(6060);
			System.out.println("서버생성");
			while(true){
				Socket client = server.accept();
				System.out.println("접속." + client.getInetAddress());
				new Thread(new ServerThread(client)).start();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}//t-c
	}//run()
	
}// class
