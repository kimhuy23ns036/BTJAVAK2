package controller;

import model.BookDAO;
import model.User;
import model.UserDAO;
import view.AdminView;
import view.LoginView;
import view.SellerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
	private LoginView loginView;
	private UserDAO userDAO;
	private BookDAO bookDAO;

	public LoginController(LoginView loginView, UserDAO userDAO, BookDAO bookDAO) {
		this.loginView = loginView;
		this.userDAO = userDAO;
		this.bookDAO = bookDAO;

		this.loginView.getLoginButton().addActionListener(e -> {
			String username = loginView.getUsername();
			String password = loginView.getPassword();

			User user = userDAO.validateUser(username, password);
			if (user != null) {
				loginView.showMessage("Login successful!");
				loginView.setVisible(false);
				if (user.getRole().equalsIgnoreCase("admin")) {
					AdminView adminView = new AdminView(user.getUsername());
					adminView.setVisible(true);
					AdminController adminController = new AdminController(adminView, bookDAO);
					adminController.loadTableData();
				} else if (user.getRole().equalsIgnoreCase("seller")) {
					SellerView sellerView = new SellerView(user.getUsername());
					sellerView.setVisible(true);
				}
			} else {
				loginView.showMessage("Invalid username or password");
			}
		});
	}
}
