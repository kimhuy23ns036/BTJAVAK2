package model;

public class Book {
	private int id;
    private String tenSach;
    private String tacGia;
    private String theLoai;
    private String nhaXuatBan;
    private double giaTien;
    private int soLuong;
    
    

    public Book(String tenSach, String tacGia, String theLoai, String nhaXuatBan, double giaTien, int soLuong) {
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.theLoai = theLoai;
		this.nhaXuatBan = nhaXuatBan;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
	}

	public Book(int id, String tenSach, String tacGia, String theLoai, String nhaXuatBan, double giaTien, int soLuong) {
    	this.id = id;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.giaTien = giaTien;
        this.soLuong = soLuong;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
