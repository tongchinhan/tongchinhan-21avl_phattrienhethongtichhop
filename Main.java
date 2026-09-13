import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

class Animal {

    protected String name;
    protected double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void hienThi() {
        System.out.println("Ten: " + name);
        System.out.println("Can nang: " + weight + " kg");
    }
}

class Lion extends Animal {

    private double eat;

    public Lion(String name, double weight, double eat) {
        super(name, weight);
        this.eat = eat;
    }

    public void hienThiLion() {
        hienThi();
        System.out.println("Thuc an moi ngay: " + eat + " kg");
    }
}

class Snake extends Animal {

    private double length;

    public Snake(String name, double weight, double length) {
        super(name, weight);
        this.length = length;
    }

    public void hienThiSnake() {
        hienThi();
        System.out.println("Chieu dai: " + length + " m");
    }
}

class Monkey extends Animal {

    private String favoriteFood;

    public Monkey(String name, double weight, String favoriteFood) {
        super(name, weight);
        this.favoriteFood = favoriteFood;
    }

    public void hienThiMonkey() {
        hienThi();
        System.out.println("Thuc an yeu thich: " + favoriteFood);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Hello World");
            System.out.println("2. Nhap ten");
            System.out.println("3. Tinh tong A + B");
            System.out.println("4. Kiem tra chan le");
            System.out.println("5. Nhap thang");
            System.out.println("6. Quan ly dong vat");
            System.out.println("7. Xoa File");
            System.out.println("8. Xoa Folder");
            System.out.println("9. Tim kiem File");
            System.out.println("10. Copy File");
            System.out.println("11. Ghi File nhi phan");
            System.out.println("12. Doc File nhi phan");
            System.out.println("13. Doc va ghi File anh");
            System.out.println("0. Thoat");
            System.out.println("==========================");

            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            switch (chon) {

                case 1:
                    bai1();
                    break;

                case 2:
                    bai2();
                    break;
                case 3:
                    bai3();
                    break;
                case 4:
                    bai4();
                    break;
                case 5:
                    bai5();
                    break;

                case 6:
                    bai6();
                    break;
                case 7:
                    bai7();
                    break;
                case 8:
                    bai8();
                    break;
                case 9:
                    bai9();
                    break;
                case 10:
                    bai10();
                    break;
                case 11:
                    bai11();
                    break;
                case 12:
                    bai12();
                    break;
                case 13:
                    bai13();
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();

    }

    public static void bai1() {
        System.out.println("Hello world!");

    }

    public static void bai2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten cua ban: ");
        String ten = sc.nextLine();
        System.out.print("Hi,Im " + ten);

    }

    public static void bai3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        System.out.print("Nhap b: ");
        int b = sc.nextInt();
        int tong = a + b;
        System.out.print("Tong la : " + tong);

    }

    public static void bai4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a: ");
        int a = sc.nextInt();
        if (a % 2 == 0) {
            System.out.println(a + "la so chan");

        } else {
            System.out.println(a + " la so le!");
        }
    }

    public static void bai5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap thang: ");
        int thang = sc.nextInt();
        switch (thang) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("May");
                break;
            case 8:
                System.out.println("July");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("September");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.print("Khong co thang hop le!");

        }
    }

    public static void bai6() {

        Lion lion = new Lion("Simba", 180, 8);
        Snake snake = new Snake("Python", 20, 4.5);
        Monkey monkey = new Monkey("Kiki", 15, "Chuoi");

        System.out.println("===== LION =====");
        lion.hienThiLion();

        System.out.println("\n===== SNAKE =====");
        snake.hienThiSnake();

        System.out.println("\n===== MONKEY =====");
        monkey.hienThiMonkey();
    }

    public static void bai7() {

        File file = new File("data/test.txt");

        if (file.exists()) {

            if (file.delete()) {
                System.out.println("Xoa file thanh cong");
            } else {
                System.out.println("Xoa file that bai");
            }

        } else {
            System.out.println("File khong ton tai");
        }
    }

    public static void bai8() {

        File folder = new File("data/test");

        if (folder.exists()) {

            xoaFolder(folder);

            System.out.println("Xoa folder thanh cong");

        } else {
            System.out.println("Folder khong ton tai");
        }
    }

    public static void xoaFolder(File folder) {

        File[] files = folder.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isDirectory()) {
                    xoaFolder(file);
                } else {
                    file.delete();
                }
            }
        }

        folder.delete();
    }

    public static void bai9() {

        File folder = new File("data");

        if (folder.exists()) {
            timFile(folder);
        } else {
            System.out.println("Folder khong ton tai");
        }
    }

    public static void timFile(File folder) {

        File[] files = folder.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isDirectory()) {

                    timFile(file);

                } else {

                    if (file.getName().endsWith(".txt")) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void bai10() {

        try {

            Path source = Paths.get("data/test.txt");
            Path destination = Paths.get("data/test_copy.txt");

            Files.copy(
                    source,
                    destination,
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Copy file thanh cong");

        } catch (IOException e) {

            System.out.println("Loi: " + e.getMessage());
        }
    }

    public static void bai11() {

        try {

            DataOutputStream dos = new DataOutputStream(
                    new FileOutputStream("data/data.bin"));

            dos.writeInt(100);
            dos.writeDouble(15.5);
            dos.writeUTF("Hello Java");

            dos.close();

            System.out.println("Ghi file nhi phan thanh cong");

        } catch (IOException e) {

            System.out.println("Loi: " + e.getMessage());
        }
    }

    public static void bai12() {

        try {

            DataInputStream dis = new DataInputStream(
                    new FileInputStream("data/data.bin"));

            int a = dis.readInt();
            double b = dis.readDouble();
            String c = dis.readUTF();

            dis.close();

            System.out.println("So nguyen: " + a);
            System.out.println("So thuc: " + b);
            System.out.println("Chuoi: " + c);

        } catch (IOException e) {

            System.out.println("Loi: " + e.getMessage());
        }
    }

    public static void bai13() {

        try {

            Path source = Paths.get("data/anh.jpg");
            Path destination = Paths.get("data/anh_copy.jpg");

            byte[] data = Files.readAllBytes(source);

            Files.write(destination, data);

            System.out.println("Doc va ghi file anh thanh cong");

        } catch (IOException e) {

            System.out.println("Loi: " + e.getMessage());
        }
    }
}
