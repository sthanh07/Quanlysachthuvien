
import java.util.Scanner;
import java.time.Year;

public class QuanLySachTuan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap thong tin sach
        System.out.print("Nhap ma sach: ");
        String maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap don gia: ");
        double donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        // Bai 1: Kiem tra tinh hop le
        int namHienTai = Year.now().getValue();

        boolean giaHopLe = donGia > 0;
        boolean soLuongHopLe = soLuong >= 0;
        boolean namHopLe = namXuatBan > 0
                && namXuatBan <= namHienTai;

        System.out.println("\n===== BAI 1: KIEM TRA DU LIEU =====");

        System.out.println("Gia hop le: " + giaHopLe);
        System.out.println("So luong hop le: " + soLuongHopLe);
        System.out.println("Nam xuat ban hop le: " + namHopLe);

        if (giaHopLe && soLuongHopLe && namHopLe) {
            System.out.println("Thong tin sach hop le.");
        } else {
            System.out.println("Thong tin sach khong hop le.");
        }

        // Bai 2: Phan loai gia sach
        System.out.println("\n===== BAI 2: PHAN LOAI GIA =====");

        if (donGia <= 0) {
            System.out.println("Gia sach khong hop le.");
        } else if (donGia < 50000) {
            System.out.println("Sach gia thap.");
        } else if (donGia < 100000) {
            System.out.println("Sach gia trung binh.");
        } else if (donGia <= 200000) {
            System.out.println("Sach gia cao.");
        } else {
            System.out.println("Sach gia dac biet.");
        }

        // Bai 3: Phan loai ton kho
        System.out.println("\n===== BAI 3: PHAN LOAI TON KHO =====");

        if (soLuong < 0) {
            System.out.println("So luong khong hop le.");
        } else if (soLuong == 0) {
            System.out.println("Het sach.");
        } else if (soLuong <= 5) {
            System.out.println("Sach sap het.");
        } else if (soLuong <= 20) {
            System.out.println("Sach con it.");
        } else {
            System.out.println("Sach con nhieu.");
        }

        // Bai 4: Chon loai sach bang switch
        System.out.println("\n===== BAI 4: LOAI SACH =====");

        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");

        System.out.print("Chon loai sach (1-4): ");
        int loaiSach = Integer.parseInt(sc.nextLine());

        switch (loaiSach) {
            case 1:
                System.out.println("Loai sach: Sach giao khoa");
                break;
            case 2:
                System.out.println("Loai sach: Sach tham khao");
                break;
            case 3:
                System.out.println("Loai sach: Sach chuyen nganh");
                break;
            case 4:
                System.out.println("Loai sach: Sach khac");
                break;
            default:
                System.out.println("Lua chon khong hop le.");
        }

        sc.close();
    }
}
