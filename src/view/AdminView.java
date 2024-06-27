package view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
    private JTextField tensachField;
    private JTextField tacgiaField;
    private JTextField giatienField;
    private JTextField soluongField;
    private JComboBox<String> theloaiCB;
    private JComboBox<String> nxbCB;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton themButton;
    private JButton suaButton;
    private JButton xoaButton;
    private JButton lammoiButton;
    private JMenuBar menuBar;
    private JMenu heThongMenu;
    private JMenuItem dangXuatMenuItem;

    public AdminView(String username) {
        setTitle("Admin - " + username);
        setBounds(100, 100, 1060, 690);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("QUẢN LÝ SÁCH");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(350, 10, 346, 66);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(10, 80, 1026, 141);
        add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Tên sách");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(61, 10, 122, 30);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Tác giả");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(61, 50, 122, 30);
        panel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Nhà xuất bản");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_2.setBounds(542, 10, 160, 30);
        panel.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Giá tiền");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_3.setBounds(542, 50, 100, 30);
        panel.add(lblNewLabel_1_3);

        tensachField = new JTextField();
        tensachField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tensachField.setBounds(227, 10, 200, 30);
        panel.add(tensachField);
        tensachField.setColumns(10);

        JLabel lblNewLabel_1_1_1 = new JLabel("Thể loại");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(61, 90, 122, 30);
        panel.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("Số lượng");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1_1_2.setBounds(542, 90, 122, 30);
        panel.add(lblNewLabel_1_1_2);

        tacgiaField = new JTextField();
        tacgiaField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        tacgiaField.setColumns(10);
        tacgiaField.setBounds(227, 50, 200, 30);
        panel.add(tacgiaField);

        giatienField = new JTextField();
        giatienField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        giatienField.setColumns(10);
        giatienField.setBounds(721, 50, 200, 30);
        panel.add(giatienField);

        soluongField = new JTextField();
        soluongField.setFont(new Font("Tahoma", Font.PLAIN, 17));
        soluongField.setColumns(10);
        soluongField.setBounds(721, 90, 200, 30);
        panel.add(soluongField);

        theloaiCB = new JComboBox<>();
        theloaiCB.setFont(new Font("Tahoma", Font.PLAIN, 17));
        theloaiCB.setModel(new DefaultComboBoxModel<>(new String[]{"Tiểu thuyết", "Thơ ca", "Truyện ngắn", "Tài chính", "Khoa học tự nhiên", "Khoa học xã hội", "Marketing", "Lập trình", "Lịch sử Việt Nam", "Sách giáo khoa", "Truyện tranh", "Truyện cổ tích"}));
        theloaiCB.setBounds(227, 91, 200, 30);
        panel.add(theloaiCB);

        nxbCB = new JComboBox<>();
        nxbCB.setModel(new DefaultComboBoxModel<>(new String[]{"Kim Đồng", "Nhà xuất bản Giáo dục Việt Nam", "Nhà xuất bản Trẻ", "Nhà xuất bản Lao Động", "Nhà xuất bản Văn học"}));
        nxbCB.setFont(new Font("Tahoma", Font.PLAIN, 17));
        nxbCB.setBounds(721, 10, 200, 30);
        panel.add(nxbCB);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 231, 1026, 323);
        add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 80, 1026, 141);
        add(scrollPane);
        panel_1.add(new JScrollPane(table), BorderLayout.CENTER);

        JLabel lblNewLabel_2 = new JLabel("DANH SÁCH");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel_1.add(lblNewLabel_2, BorderLayout.NORTH);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 564, 1026, 59);
        add(panel_2);
        panel_2.setLayout(null);

        themButton = new JButton("Thêm");
        themButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        themButton.setBounds(67, 10, 150, 39);
        panel_2.add(themButton);

        suaButton = new JButton("Sửa");
        suaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        suaButton.setBounds(312, 10, 150, 39);
        panel_2.add(suaButton);

        xoaButton = new JButton("Xóa");
        xoaButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        xoaButton.setBounds(577, 10, 150, 39);
        panel_2.add(xoaButton);

        lammoiButton = new JButton("Làm mới");
        lammoiButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lammoiButton.setBounds(819, 10, 150, 39);
        panel_2.add(lammoiButton);
        
        table.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    int selectedRow = table.getSelectedRow();
                    tensachField.setText(table.getValueAt(selectedRow, 1).toString());
                    tacgiaField.setText(table.getValueAt(selectedRow, 2).toString());
                    theloaiCB.setSelectedItem(table.getValueAt(selectedRow, 3).toString());
                    nxbCB.setSelectedItem(table.getValueAt(selectedRow, 4).toString());
                    giatienField.setText(table.getValueAt(selectedRow, 5).toString());
                    soluongField.setText(table.getValueAt(selectedRow, 6).toString());
                }
            }
        });
        
        menuBar = new JMenuBar();
        heThongMenu = new JMenu("Hệ thống");
        dangXuatMenuItem = new JMenuItem("Đăng xuất");
        heThongMenu.add(dangXuatMenuItem);
        menuBar.add(heThongMenu);
        setJMenuBar(menuBar);
    }

    public String getTenSach() {
        return tensachField.getText();
    }

    public String getTacGia() {
        return tacgiaField.getText();
    }

    public String getGiaTien() {
        return giatienField.getText();
    }

    public String getSoLuong() {
        return soluongField.getText();
    }

    public String getTheLoai() {
        return (String) theloaiCB.getSelectedItem();
    }

    public String getNXB() {
        return (String) nxbCB.getSelectedItem();
    }

    public JButton getThemButton() {
        return themButton;
    }

    public JButton getSuaButton() {
        return suaButton;
    }

    public JButton getXoaButton() {
        return xoaButton;
    }

    public JButton getLammoiButton() {
        return lammoiButton;
    }
    
    public void setTableData(Object[][] data, String[] columnNames) {
        tableModel = new DefaultTableModel(data, columnNames);
        table.setModel(tableModel);
    }
    
    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    public Object getTableValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public JMenuItem getDangXuatMenuItem() {
        return dangXuatMenuItem;
    }
}
