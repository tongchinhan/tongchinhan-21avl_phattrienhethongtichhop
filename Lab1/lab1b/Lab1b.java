package lab1b;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Lab1b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n================ CHƯƠNG TRÌNH TỔNG HỢP LAB 1B ================");
            System.out.println("1. Bài 1: Các đối tượng hình học (HCN, HVuong, HTG)");
            System.out.println("2. Bài 2: Mảng số nguyên và các thao tác nâng cao");
            System.out.println("3. Bài 3, 4, 5: Quản lý sinh viên (Person, Student, Học bổng)");
            System.out.println("4. Bài 6: Kế thừa đa cấp và biến x riêng biệt");
            System.out.println("5. Bài 7: Giao diện Polygon và các đa giác");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn (0-5): ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    runBai1();
                    break;
                case 2:
                    runBai2(scanner);
                    break;
                case 3:
                    runBai3_4_5(scanner);
                    break;
                case 4:
                    runBai6();
                    break;
                case 5:
                    runBai7(scanner);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 5!");
            }
        } while (choice != 0);
        scanner.close();
    }

    // ================= BÀI 1 =================
    public static void runBai1() {
        System.out.println("\n--- CHẠY BÀI 1: CÁC ĐỐI TƯỢNG HÌNH HỌC ---");
        HCN hcn = new HCN(5, 3);
        HVuong hv = new HVuong(4);
        HTG htg = new HTG(3, 4, 5);

        hcn.xuatThongTin();
        hv.xuatThongTin();
        htg.xuatThongTin();
    }

    // ================= BÀI 2 =================
    public static void runBai2(Scanner scanner) {
        System.out.println("\n--- CHẠY BÀI 2: MẢNG SỐ NGUYÊN NÂNG CAO ---");
        MyArray ma = new MyArray(100);
        ma.nhapMang(scanner);
        ma.xuatMang();

        System.out.print("Nhập phần tử Y muốn thêm vào đầu: ");
        int yDau = Integer.parseInt(scanner.nextLine());
        ma.themDau(yDau);

        System.out.print("Nhập phần tử Y muốn thêm vào cuối: ");
        int yCuoi = Integer.parseInt(scanner.nextLine());
        ma.themCuoi(yCuoi);

        ma.xuatMang();

        ma.radixSort(true);
        System.out.println("Sau khi sắp xếp tăng dần bằng Radix Sort:");
        ma.xuatMang();

        System.out.print("Nhập phần tử B cần tìm kiếm (trong mảng đã sắp xếp): ");
        int b = Integer.parseInt(scanner.nextLine());
        int pos = ma.timKiemDaSapXep(b);
        if (pos != -1) {
            System.out.println("Tìm thấy phần tử " + b + " tại vị trí: " + pos);
        } else {
            System.out.println("Không tìm thấy phần tử " + b + " trong mảng.");
        }
    }

    // ================= BÀI 3, 4, 5 =================
    public static void runBai3_4_5(Scanner scanner) {
        System.out.println("\n--- CHẠY BÀI 3, 4, 5: QUẢN LÝ SINH VIÊN ---");
        List<Student> list = new ArrayList<>();

        System.out.print("Nhập số lượng sinh viên n = ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student s = new Student();
            s.inputInfo(scanner);
            list.add(s);
        }

        System.out.println("\n=== DANH SÁCH TẤT CẢ SINH VIÊN ===");
        for (Student s : list) {
            s.printInfo();
            System.out.println("----------------------------------");
        }

        if (!list.isEmpty()) {
            Student maxS = list.get(0);
            Student minS = list.get(0);

            for (Student s : list) {
                if (s.getDiemTB() > maxS.getDiemTB()) maxS = s;
                if (s.getDiemTB() < minS.getDiemTB()) minS = s;
            }

            System.out.println("\n-> Sinh viên có điểm TB cao nhất:");
            maxS.printInfo();

            System.out.println("\n-> Sinh viên có điểm TB thấp nhất:");
            minS.printInfo();
        }

        System.out.println("\n=== DANH SÁCH SINH VIÊN ĐẠT HỌC BỔNG (> 8.0) ===");
        boolean found = false;
        for (Student s : list) {
            if (s.hasScholarship()) {
                s.printInfo();
                System.out.println("----------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sinh viên nào đạt học bổng.");
        }
    }

    // ================= BÀI 6 =================
    public static void runBai6() {
        System.out.println("\n--- CHẠY BÀI 6: KẾ THỪA ĐA CẤP VÀ BIẾN X ---");
        CClass c = new CClass();
        System.out.println("Giá trị ban đầu:");
        c.showAllX();

        c.setXOfASpecific(999);
        System.out.println("\nSau khi gọi phương thức đặt x của A thành 999:");
        c.showAllX();
    }

    // ================= BÀI 7 =================
    public static void runBai7(Scanner scanner) {
        System.out.println("\n--- CHẠY BÀI 7: GIAO DIỆN POLYGON VÀ CÁC ĐA GIÁC ---");
        System.out.println("1. Tam giác thường");
        System.out.println("2. Tam giác cân");
        System.out.println("3. Tam giác đều");
        System.out.println("4. Hình chữ nhật");
        System.out.println("5. Hình vuông");
        System.out.println("6. Ngũ giác đều");
        System.out.println("7. Lục giác đều");
        System.out.println("8. Bát giác đều");
        System.out.print("Chọn loại đa giác muốn tạo (1-8): ");
        
        int choice = Integer.parseInt(scanner.nextLine());
        Polygon poly = null;

        switch (choice) {
            case 1:
                System.out.print("Nhập 3 cạnh a, b, c: ");
                poly = new TrianglePoly(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                scanner.nextLine();
                break;
            case 2:
                System.out.print("Nhập cạnh bên và cạnh đáy: ");
                poly = new IsoscelesTrianglePoly(scanner.nextDouble(), scanner.nextDouble());
                scanner.nextLine();
                break;
            case 3:
                System.out.print("Nhập cạnh tam giác đều: ");
                poly = new EquilateralTrianglePoly(Double.parseDouble(scanner.nextLine()));
                break;
            case 4:
                System.out.print("Nhập chiều dài và chiều rộng: ");
                poly = new RectanglePoly(scanner.nextDouble(), scanner.nextDouble());
                scanner.nextLine();
                break;
            case 5:
                System.out.print("Nhập cạnh hình vuông: ");
                poly = new SquarePoly(Double.parseDouble(scanner.nextLine()));
                break;
            case 6:
                System.out.print("Nhập cạnh ngũ giác đều: ");
                poly = new PentagonPoly(Double.parseDouble(scanner.nextLine()));
                break;
            case 7:
                System.out.print("Nhập cạnh lục giác đều: ");
                poly = new HexagonPoly(Double.parseDouble(scanner.nextLine()));
                break;
            case 8:
                System.out.print("Nhập cạnh bát giác đều: ");
                poly = new OctagonPoly(Double.parseDouble(scanner.nextLine()));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        if (poly != null) {
            System.out.println("\n--- KẾT QUẢ ĐA GIÁC ---");
            System.out.println("Chu vi: " + poly.perimeter());
            System.out.println("Diện tích: " + poly.area());
        }
    }
}

// ================= CÁC LỚP HỖ TRỢ CHO BÀI 1 =================
class HCN {
    protected double dai, rong;
    public HCN() { this.dai = 0; this.rong = 0; }
    public HCN(double dai, double rong) { this.dai = dai; this.rong = rong; }
    public double getDai() { return dai; }
    public void setDai(double dai) { this.dai = dai; }
    public double getRong() { return rong; }
    public void setRong(double rong) { this.rong = rong; }
    public double tinhChuVi() { return (dai + rong) * 2; }
    public double tinhDienTich() { return dai * rong; }
    public void xuatThongTin() {
        System.out.println("Hình Chữ Nhật [Dài: " + dai + ", Rộng: " + rong + ", Chu vi: " + tinhChuVi() + ", Diện tích: " + tinhDienTich() + "]");
    }
}

class HVuong extends HCN {
    public HVuong() { super(); }
    public HVuong(double canh) { super(canh, canh); }
    @Override
    public void xuatThongTin() {
        System.out.println("Hình Vuông [Cạnh: " + getDai() + ", Chu vi: " + tinhChuVi() + ", Diện tích: " + tinhDienTich() + "]");
    }
}

class HTG {
    private double a, b, c;
    public HTG() { this.a = 0; this.b = 0; this.c = 0; }
    public HTG(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            this.a = a; this.b = b; this.c = c;
        } else {
            this.a = 0; this.b = 0; this.c = 0;
        }
    }
    public double tinhChuVi() { return a + b + c; }
    public double tinhDienTich() {
        double p = tinhChuVi() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    public void xuatThongTin() {
        System.out.println("Tam Giác [Cạnh: " + a + ", " + b + ", " + c + ", Chu vi: " + tinhChuVi() + ", Diện tích: " + tinhDienTich() + "]");
    }
}

// ================= CÁC LỚP HỖ TRỢ CHO BÀI 2 =================
class MyArray {
    private int[] arr;
    private int n;

    public MyArray(int capacity) {
        arr = new int[capacity];
        n = 0;
    }

    public void nhapMang(Scanner scanner) {
        System.out.print("Nhập số lượng phần tử thực tế: ");
        n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    public void xuatMang() {
        System.out.print("Mảng hiện tại: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void themDau(int y) {
        if (n >= arr.length) arr = Arrays.copyOf(arr, arr.length + 1);
        for (int i = n; i > 0; i--) arr[i] = arr[i - 1];
        arr[0] = y;
        n++;
    }

    public void themCuoi(int y) {
        if (n >= arr.length) arr = Arrays.copyOf(arr, arr.length + 1);
        arr[n] = y;
        n++;
    }

    private int getMax() {
        int mx = arr[0];
        for (int i = 1; i < n; i++) if (arr[i] > mx) mx = arr[i];
        return mx;
    }

    private void countSort(int exp, boolean ascending) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
        if (ascending) {
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        } else {
            for (int i = 8; i >= 0; i--) count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public void radixSort(boolean ascending) {
        if (n <= 0) return;
        int m = getMax();
        for (int exp = 1; m / exp > 0; exp *= 10) countSort(exp, ascending);
    }

    public int timKiemDaSapXep(int b) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == b) return m;
            if (arr[m] < b) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}

// ================= CÁC LỚP HỖ TRỢ CHO BÀI 3, 4, 5 =================
class Person {
    private String ten, gioiTinh, ngaySinh, diaChi;
    public Person() {}
    public void inputInfo(Scanner scanner) {
        System.out.print("Nhập tên: "); ten = scanner.nextLine();
        System.out.print("Nhập giới tính: "); gioiTinh = scanner.nextLine();
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): "); ngaySinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: "); diaChi = scanner.nextLine();
    }
    public void printInfo() {
        System.out.println("Tên: " + ten + ", Giới tính: " + gioiTinh + ", Ngày sinh: " + ngaySinh + ", Địa chỉ: " + diaChi);
    }
}

class Student extends Person {
    private double diemTB;
    private String email;

    public double getDiemTB() { return diemTB; }

    @Override
    public void inputInfo(Scanner scanner) {
        super.inputInfo(scanner);
        while (true) {
            System.out.print("Nhập điểm trung bình (0.0 - 10.0): ");
            diemTB = Double.parseDouble(scanner.nextLine());
            if (diemTB >= 0.0 && diemTB <= 10.0) break;
            System.out.println("Điểm không hợp lệ, vui lòng nhập lại!");
        }
        while (true) {
            System.out.print("Nhập email (phải có '@' và không chứa khoảng trắng): ");
            email = scanner.nextLine().trim();
            if (email.contains("@") && !email.contains(" ")) break;
            System.out.println("Email không hợp lệ, vui lòng nhập lại!");
        }
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Điểm TB: " + diemTB + ", Email: " + email + ", Học bổng: " + (hasScholarship() ? "Có" : "Không"));
    }

    public boolean hasScholarship() {
        return diemTB > 8.0;
    }
}

// ================= CÁC LỚP HỖ TRỢ CHO BÀI 6 =================
class AClass {
    protected int x = 10;
    public void setXOfA(int x) { this.x = x; }
    public int getX() { return x; }
}

class BClass extends AClass {
    protected int x = 20;
}

class CClass extends BClass {
    protected int x = 30;
    public void setXOfASpecific(int value) {
        super.setXOfA(value);
    }
    public void showAllX() {
        System.out.println("Giá trị x của C: " + this.x);
        System.out.println("Giá trị x của B: " + super.x);
        System.out.println("Giá trị x của A (thông qua getter cha): " + super.getX());
    }
}

// ================= CÁC LỚP HỖ TRỢ CHO BÀI 7 =================
interface Polygon {
    double area();
    double perimeter();
}

class TrianglePoly implements Polygon {
    protected double a, b, c;
    public TrianglePoly(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
    public double perimeter() { return a + b + c; }
    public double area() {
        double p = perimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class IsoscelesTrianglePoly extends TrianglePoly {
    public IsoscelesTrianglePoly(double canhBen, double canhDay) { super(canhBen, canhBen, canhDay); }
}

class EquilateralTrianglePoly extends TrianglePoly {
    public EquilateralTrianglePoly(double canh) { super(canh, canh, canh); }
}

class RectanglePoly implements Polygon {
    protected double dai, rong;
    public RectanglePoly(double dai, double rong) { this.dai = dai; this.rong = rong; }
    public double perimeter() { return (dai + rong) * 2; }
    public double area() { return dai * rong; }
}

class SquarePoly extends RectanglePoly {
    public SquarePoly(double canh) { super(canh, canh); }
}

class PentagonPoly implements Polygon {
    private double canh;
    public PentagonPoly(double canh) { this.canh = canh; }
    public double perimeter() { return 5 * canh; }
    public double area() { return 1.72048 * canh * canh; }
}

class HexagonPoly implements Polygon {
    private double canh;
    public HexagonPoly(double canh) { this.canh = canh; }
    public double perimeter() { return 6 * canh; }
    public double area() { return (3 * Math.sqrt(3) / 2) * canh * canh; }
}

class OctagonPoly implements Polygon {
    private double canh;
    public OctagonPoly(double canh) { this.canh = canh; }
    public double perimeter() { return 8 * canh; }
    public double area() { return 2 * (1 + Math.sqrt(2)) * canh * canh; }
}