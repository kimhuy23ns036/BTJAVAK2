package view;

import javax.swing.*;

public class SellerView extends JFrame {
    public SellerView(String username) {
        setTitle("Seller View - " + username);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome Seller: " + username);
        add(welcomeLabel);
    }
}
