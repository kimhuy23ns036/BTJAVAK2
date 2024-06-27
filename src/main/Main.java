package main;

import model.BookDAO;
import model.UserDAO;
import view.LoginView;
import controller.AdminController;
import controller.LoginController;

public class Main {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        UserDAO userDAO = new UserDAO();
        BookDAO bookDAO = new BookDAO();
        new LoginController(loginView, userDAO, bookDAO);
        loginView.setVisible(true);
//        BookDAO model = new BookDAO();
    }
}
