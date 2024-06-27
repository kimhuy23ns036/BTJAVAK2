package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
		String adminPassword = "admin123";
		String sellerPassword = "seller123";
		
		String hashedAdminPassword = hashPassword(adminPassword);
		String hashedSellerPassword = hashPassword(sellerPassword);
		
		System.out.println("Hashed Admin Password: " + hashedAdminPassword);
		System.out.println("Hashed Seller Password: " + hashedSellerPassword);
	}
}
