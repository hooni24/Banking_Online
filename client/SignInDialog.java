package client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SignInDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	public SignInDialog() {
		setBounds(100, 100, 384, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lbl_name = new JLabel("\uC774\uB984");
			contentPanel.add(lbl_name);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(25);
		}
		{
			JLabel lbl_jumin = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
			contentPanel.add(lbl_jumin);
		}
		{
			textField_1 = new JTextField();
			contentPanel.add(textField_1);
			textField_1.setColumns(25);
		}
		{
			JLabel lbl_address = new JLabel("\uC8FC\uC18C");
			contentPanel.add(lbl_address);
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2);
			textField_2.setColumns(28);
		}
		{
			JLabel lbl_id = new JLabel("ID");
			contentPanel.add(lbl_id);
		}
		{
			textField_3 = new JTextField();
			contentPanel.add(textField_3);
			textField_3.setColumns(25);
		}
		{
			JLabel lbl_pw = new JLabel("Password");
			contentPanel.add(lbl_pw);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setColumns(25);
			contentPanel.add(passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
