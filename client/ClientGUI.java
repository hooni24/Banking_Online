package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;

public class ClientGUI extends JFrame{
	JLabel lbl_welcome, lbl_acclist, lbl_accno, lbl_balance;
	JList list_acclist;
	JTextField tf_accno, tf_balance;
	JButton btn_deposit, btn_withdraw, btn_showall, btn_transfer, btn_newacc, btn_delacc, btn_update, btn_leave;
	
	public ClientGUI() {
		setTitle("Banking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		
		JPanel p_main = new JPanel();
		p_main.setLayout(new GridLayout(1, 2));
		JPanel p_left = new JPanel();
		p_left.setLayout(new BorderLayout());
		lbl_welcome = new JLabel("Welcome"); lbl_welcome.setFont(new Font("gulim", Font.BOLD, 40));
		p_left.add(lbl_welcome, BorderLayout.NORTH);
		list_acclist = new JList();
		p_left.add(list_acclist, BorderLayout.CENTER);
		p_main.add(p_left);
		
		JPanel p_right = new JPanel();
		p_right.setLayout(new BorderLayout());
		JPanel p_right_north = new JPanel();
		p_right_north.setPreferredSize(new Dimension(10, 80));
		JPanel p_right_center = new JPanel();
		GridLayout gl_p_right_center = new GridLayout(3, 3);
		p_right_center.setLayout(gl_p_right_center);
		lbl_accno = new JLabel("Account Num"); lbl_accno.setFont(new Font("gulim", Font.PLAIN, 30));
		tf_accno = new JTextField(10);
		tf_accno.setEditable(false);
		tf_accno.setPreferredSize(new Dimension(0, 30));
		p_right_north.add(lbl_accno); p_right_north.add(tf_accno);
		lbl_balance = new JLabel("Balance");lbl_balance.setFont(new Font("gulim", Font.PLAIN, 30));
		tf_balance = new JTextField(17);
		tf_balance.setEditable(false);
		tf_balance.setPreferredSize(new Dimension(0, 30));
		p_right_north.add(lbl_balance); p_right_north.add(tf_balance);
		btn_deposit = new JButton("입금");
		btn_withdraw = new JButton("출금");
		btn_showall = new JButton("조회");
		btn_transfer = new JButton("이체");
		btn_newacc = new JButton("신규");
		btn_delacc = new JButton("해지");
		btn_update = new JButton("수정");
		btn_leave = new JButton("탈퇴");
		p_right_center.add(btn_deposit);	p_right_center.add(btn_withdraw);	p_right_center.add(btn_showall);	p_right_center.add(btn_transfer);
		p_right_center.add(btn_newacc);	p_right_center.add(btn_delacc);	p_right_center.add(btn_update);	p_right_center.add(btn_leave);
		p_right.add(p_right_north, BorderLayout.NORTH);
		p_right.add(p_right_center, BorderLayout.CENTER);
		p_main.add(p_right);
		
		getContentPane().add(p_main);
		setVisible(true);
	}//constructor

}//class

