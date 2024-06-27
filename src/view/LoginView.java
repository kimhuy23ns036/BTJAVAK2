package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        initializeUI();
    }

    private void initializeUI() {
    	setTitle("Login");
        setBounds(100, 100, 600, 288);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(154, 10, 277, 56);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(53, 76, 210, 45);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(53, 131, 210, 45);
		add(lblNewLabel_1_2);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		usernameField.setBounds(294, 85, 240, 30);
		add(usernameField);
		usernameField.setColumns(10);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loginButton.setBounds(226, 199, 134, 33);
		add(loginButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(294, 137, 240, 30);
		add(passwordField);

        add(panel);
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void showMessage(String message) {
    	JOptionPane.showMessageDialog(this, message);
    }
}
