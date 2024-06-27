package controller;

import view.AdminView;
import view.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import main.Main;
import model.Book;
import model.BookDAO;
import model.UserDAO;

public class AdminController {
	private AdminView view;
	private BookDAO bookDAO;

	public AdminController(AdminView view, BookDAO bookDAO) {
		this.view = view;
		this.bookDAO = bookDAO;
		
		loadTableData();

		this.view.getLammoiButton().addActionListener(e -> loadTableData());

		this.view.getThemButton().addActionListener(e -> addBook());

		this.view.getSuaButton().addActionListener(e -> updateBook());

		this.view.getXoaButton().addActionListener(e -> deleteBook());

		this.view.getDangXuatMenuItem().addActionListener(e -> logout());
	}

	public void loadTableData() {
		WorkerThread workerThread = new WorkerThread(view, bookDAO);
		workerThread.start();
	}

	private void addBook() {
		String tenSach = view.getTenSach();
		String tacGia = view.getTacGia();
		String giaTien = view.getGiaTien();
		String soLuong = view.getSoLuong();
		String theLoai = view.getTheLoai();
		String nxb = view.getNXB();

		if (tenSach.isEmpty() || tacGia.isEmpty() || giaTien.isEmpty() || soLuong.isEmpty() || theLoai.isEmpty()
				|| nxb.isEmpty()) {
			view.showMessage("Không được để trống!");
			return;
		}

		Book book = new Book(tenSach, tacGia, theLoai, nxb, Double.parseDouble(giaTien), Integer.parseInt(soLuong));
		bookDAO.addBook(book);
		loadTableData();
		view.showMessage("Thêm thành công!");
	}

	private void updateBook() {
		int selectedRow = view.getSelectedRow();
		if (selectedRow == -1) {
			view.showMessage("Chọn 1 hàng để sửa thông tin.");
			return;
		}

		int id = (int) view.getTableValueAt(selectedRow, 0);
		String tenSach = view.getTenSach();
		String tacGia = view.getTacGia();
		String giaTien = view.getGiaTien();
		String soLuong = view.getSoLuong();
		String theLoai = view.getTheLoai();
		String nxb = view.getNXB();

		if (tenSach.isEmpty() || tacGia.isEmpty() || giaTien.isEmpty() || soLuong.isEmpty() || theLoai.isEmpty()
				|| nxb.isEmpty()) {
			view.showMessage("Không được để trống!");
			return;
		}

		Book book = new Book(id, tenSach, tacGia, theLoai, nxb, Double.parseDouble(giaTien), Integer.parseInt(soLuong));
		bookDAO.updateBook(book);
		loadTableData();
		view.showMessage("Cập nhật thành công!");
	}

	private void deleteBook() {
		int selectedRow = view.getSelectedRow();
		if (selectedRow == -1) {
			view.showMessage("Chọn sách để xóa.");
			return;
		}

		int id = (int) view.getTableValueAt(selectedRow, 0);
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sách này?", "Delete",
				JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			bookDAO.deleteBook(id);
			loadTableData();
			view.showMessage("Xóa thành công!");
		}
	}

	private void logout() {
		int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?", "Logout",
				JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			view.dispose();
			LoginView loginView = new LoginView();
			UserDAO userDAO = new UserDAO();
			BookDAO bookDAO = new BookDAO();
			new LoginController(loginView, userDAO, bookDAO);
			loginView.setVisible(true);
		}
	}
}
