package controller;

import model.Book;
import model.BookDAO;
import view.AdminView;

import java.util.List;

public class WorkerThread extends Thread {
    private AdminView view;
    private BookDAO bookDAO;

    public WorkerThread(AdminView view, BookDAO bookDAO) {
        this.view = view;
        this.bookDAO = bookDAO;
    }

    @Override
    public void run() {
        // Load data from database
        List<Book> books = bookDAO.getAllBooks();
        String[] columnNames = {"ID", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Giá tiền", "Số lượng"};
        Object[][] data = new Object[books.size()][7];

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.getId();
            data[i][1] = book.getTenSach();
            data[i][2] = book.getTacGia();
            data[i][3] = book.getTheLoai();
            data[i][4] = book.getNhaXuatBan();
            data[i][5] = book.getGiaTien();
            data[i][6] = book.getSoLuong();
        }

        // Update UI on the Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(() -> {
            view.setTableData(data, columnNames);
//            view.showMessage("Data loaded successfully!");
        });
    }
}
