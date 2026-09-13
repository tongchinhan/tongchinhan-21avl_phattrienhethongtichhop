public class Main {

    public static void main(String[] args) {

        SanPham sp1 = new SanPham(
                "SP01",
                "Laptop",
                15000000,
                10);

        SanPham sp2 = new SanPham(
                "SP02",
                "Chuot",
                500000,
                20);

        System.out.println("===== SAN PHAM 1 BAN DAU =====");

        sp1.hienThiThongTin();

        System.out.println("\n===== SAN PHAM 2 BAN DAU =====");

        sp2.hienThiThongTin();

        System.out.println("\n===== NHAP THEM HANG =====");

        sp1.nhapHang(5);

        sp1.hienThiThongTin();

        System.out.println("\n===== BAN HANG =====");

        sp1.banHang(3);

        sp1.hienThiThongTin();

        System.out.println("\n===== THU BAN QUA TON KHO =====");

        sp1.banHang(100);

        sp1.hienThiThongTin();
        SinhVien sv1 = new SinhVien(
                "Nguyen Van An",
                2004,
                "Can Tho",
                "SV001",
                "Cong nghe thong tin",
                8.8);

        SinhVien sv2 = new SinhVien(
                "Tran Thi Binh",
                2005,
                "Ho Chi Minh",
                "SV002",
                "Ke toan",
                7.5);

        GiangVien gv1 = new GiangVien(
                "Nguyen Van Minh",
                1985,
                "Can Tho",
                "GV001",
                "Lap trinh Java",
                5000000,
                2.5);

        GiangVien gv2 = new GiangVien(
                "Tran Thi Hoa",
                1988,
                "Ho Chi Minh",
                "GV002",
                "Co so du lieu",
                6000000,
                2.2);

        System.out.println("========== SINH VIEN 1 ==========");

        sv1.hienThiThongTin();

        System.out.println("\n========== SINH VIEN 2 ==========");

        sv2.hienThiThongTin();

        System.out.println("\n========== GIANG VIEN 1 ==========");

        gv1.hienThiThongTin();

        System.out.println("\n========== GIANG VIEN 2 ==========");

        gv2.hienThiThongTin();
    }
}