package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/book_store";
	private String jdbcUsername = "root";
	private String jdbcPassword = "123456789";

	private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
	private static final String INSERT_BOOK = "INSERT INTO books (tensach, tacgia, theloai, nxb, giatien, soluong) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_BOOK = "UPDATE books SET tensach=?, tacgia=?, theloai=?, nxb=?, giatien=?, soluong=? WHERE id=?";
	private static final String DELETE_BOOK = "DELETE FROM books WHERE id=?";

	public BookDAO() {
	}

	protected Connection getConnection() throws SQLException {
		Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return connection;
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tensach");
				String tacGia = rs.getString("tacgia");
				String theLoai = rs.getString("theloai");
				String nhaXuatBan = rs.getString("nxb");
				double giaTien = rs.getInt("giatien");
				int soLuong = rs.getInt("soluong");
				Book book = new Book(id, tenSach, tacGia, theLoai, nhaXuatBan, giaTien, soLuong);
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void addBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK)) {
            preparedStatement.setString(1, book.getTenSach());
            preparedStatement.setString(2, book.getTacGia());
            preparedStatement.setString(3, book.getTheLoai());
            preparedStatement.setString(4, book.getNhaXuatBan());
            preparedStatement.setDouble(5, book.getGiaTien());
            preparedStatement.setInt(6, book.getSoLuong());
            preparedStatement.executeUpdate();
              
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateBook(Book book) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
			preparedStatement.setString(1, book.getTenSach());
			preparedStatement.setString(2, book.getTacGia());
			preparedStatement.setString(3, book.getTheLoai());
			preparedStatement.setString(4, book.getNhaXuatBan());
			preparedStatement.setDouble(5, book.getGiaTien());
			preparedStatement.setInt(6, book.getSoLuong());
			preparedStatement.setInt(7, book.getId());
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Book updated successfully.");
			} else {
				System.out.println("No book found with the given id.");
			}
		} catch (SQLException e) {
			System.out.println("Error updating book: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
