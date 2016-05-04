package client;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientLogIn extends JFrame implements Runnable, ActionListener{
	private JLabel lbl_id, lbl_pw;
	private JTextField tf_id, tf_pw;
	private JButton btn_login, btn_signup;
	private Socket client;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ClientLogIn() {
		try {
			client = new Socket("localhost", 6060);
			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
		btn_login.addActionListener(this);
		btn_signup = new JButton("SIGN UP");
		btn_signup.addActionListener(this);
		p_south.add(btn_login); p_south.add(btn_signup);
		add(p_south, BorderLayout.SOUTH);
		
		setVisible(true);
	}//constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btn_signup){
																//여기 다이얼로그로 회원가입창 구현 해야 함
		}
		
	}

	@Override
	public void run() {
		
	}//run()
	
}//class
