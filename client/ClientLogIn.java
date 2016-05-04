package client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientLogIn extends JFrame{
	JLabel lbl_id, lbl_pw;
	JTextField tf_id, tf_pw;
	JButton btn_login, btn_signup;

	public ClientLogIn() {
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150);
		JPanel p_main = new JPanel();
		p_main.setLayout(new BorderLayout());

		JPanel p_center = new JPanel();
		JPanel p_id = new JPanel();
		lbl_id = new JLabel("ID");
		tf_id = new JTextField(10);
		p_id.add(lbl_id); p_id.add(tf_id);		
		JPanel p_pw = new JPanel();
		lbl_pw = new JLabel("PW");
		tf_pw = new JTextField(10);
		p_pw.add(lbl_pw); p_pw.add(tf_pw);
		p_center.add(p_id);	p_center.add(p_pw);
		add(p_center, BorderLayout.CENTER);
		
		JPanel p_south = new JPanel();
		btn_login = new JButton("LOGIN");
		btn_signup = new JButton("SIGN UP");
		p_south.add(btn_login); p_south.add(btn_signup);
		add(p_south, BorderLayout.SOUTH);
		
		setVisible(true);
	}//constructor
	
}//class
