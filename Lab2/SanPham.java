public class SanPham {

    // Khai báo các thuộc tính private
    private String maSP;
    private String tenSP;
    private double donGia;
    private int soLuong;

    public SanPham(String maSP, String tenSP, double donGia, int soLuong) {

        this.maSP = maSP;

        this.tenSP = tenSP;

        this.donGia = donGia;

        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double tinhThanhTien() {

        return donGia * soLuong;
    }

    // Nhập thêm hàng
    public void nhapHang(int soLuongNhap) {

        if (soLuongNhap > 0) {

            soLuong = soLuong + soLuongNhap;

        } else {

            System.out.println("So luong nhap phai lon hon 0!");
        }
    }

    // Bán hàng
    public boolean banHang(int soLuongBan) {

        if (soLuongBan <= 0) {

            System.out.println("So luong ban phai lon hon 0!");

            return false;
        }

        if (soLuongBan > soLuong) {

            System.out.println("Khong du hang de ban!");

            return false;
        }

        soLuong = soLuong - soLuongBan;

        System.out.println("Ban hang thanh cong!");

        return true;
    }

    public void hienThiThongTin() {

        System.out.println("Ma SP: " + maSP);
        System.out.println("Ten SP: " + tenSP);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + tinhThanhTien());
    }
}