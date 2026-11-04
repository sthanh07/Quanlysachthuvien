import java.util.Scanner;

/**
 * BÀI THỰC HÀNH TUẦN 5: CÂU LỆNH LẶP TRONG JAVA
 * Chương trình Quản lý Thư viện tích hợp:
 * - Bài 1: Nhập n sách bằng vòng lặp (for / while)
 * - Bài 2: Tính tổng số lượng và tổng giá trị sách
 * - Bài 3: Menu lặp liên tục đến khi chọn Thoát (do-while)
 * - Bài 4: Tìm sách theo mã bằng vòng lặp
 */
public class QuanLyThuVienTuan5 {

    // Lưu trữ danh sách sách đã nhập (sử dụng mảng tĩnh cho phạm vi Tuần 5)
    private static final int MAX_SACH = 100;
    private static String[] dsMaSach = new String[MAX_SACH];
    private static String[] dsTenSach = new String[MAX_SACH];
    private static int[] dsSoLuong = new int[MAX_SACH];
    private static double[] dsDonGia = new double[MAX_SACH];
    private static int soSachHienTai = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChon;

        // Bài 3: Menu lặp liên tục bằng do-while đến khi chọn Thoát (0)
        do {
            System.out.println("\n================ MENU QUẢN LÝ THƯ VIỆN (TUẦN 5) ================");
            System.out.println("1. Bài 1: Nhập n cuốn sách mới (vòng lặp for & while)");
            System.out.println("2. Hiển thị danh sách sách đã nhập");
            System.out.println("3. Bài 2: Tính tổng số lượng và tổng giá trị sách");
            System.out.println("4. Bài 4: Tìm kiếm sách theo mã sách");
            System.out.println("0. Bài 3: Thoát chương trình");
            System.out.println("================================================================");
            System.out.print("Mời bạn chọn chức năng (0-4): ");

            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập một số nguyên hợp lệ (0-4): ");
                sc.next();
            }
            luaChon = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm dòng

            switch (luaChon) {
                case 1:
                    nhapNSach(sc);
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    tinhTongSoLuongVaGiaTri();
                    break;
                case 4:
                    timSachTheoMa(sc);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý Thư viện Tuần 5. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 4.");
            }
        } while (luaChon != 0);

        sc.close();
    }

    /**
     * Bài 1: Nhập n sách bằng vòng lặp
     */
    public static void nhapNSach(Scanner sc) {
        int n;
        // Sử dụng vòng lặp while để kiểm tra điều kiện số lượng sách n > 0
        while (true) {
            System.out.print("Nhập số lượng đầu sách cần thêm (n > 0): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n > 0 && soSachHienTai + n <= MAX_SACH) {
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Số lượng không hợp lệ! Vui lòng nhập số nguyên dương.");
        }

        // Sử dụng vòng lặp for để nhập thông tin từng cuốn sách
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin sách thứ " + (i + 1) + " ---");
            System.out.print("Mã sách: ");
            dsMaSach[soSachHienTai] = sc.nextLine().trim();

            System.out.print("Tên sách: ");
            dsTenSach[soSachHienTai] = sc.nextLine().trim();

            // Kiểm tra số lượng cuốn >= 0 bằng vòng lặp while
            int soLuong;
            while (true) {
                System.out.print("Số lượng: ");
                if (sc.hasNextInt()) {
                    soLuong = sc.nextInt();
                    if (soLuong >= 0) {
                        sc.nextLine();
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Số lượng phải >= 0!");
            }
            dsSoLuong[soSachHienTai] = soLuong;

            // Kiểm tra đơn giá >= 0 bằng vòng lặp while
            double donGia;
            while (true) {
                System.out.print("Đơn giá (VNĐ): ");
                if (sc.hasNextDouble()) {
                    donGia = sc.nextDouble();
                    if (donGia >= 0) {
                        sc.nextLine();
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Đơn giá phải >= 0!");
            }
            dsDonGia[soSachHienTai] = donGia;

            soSachHienTai++;
        }
        System.out.println("-> Đã nhập thành công " + n + " đầu sách!");
    }

    /**
     * Hiển thị danh sách các cuốn sách hiện có
     */
    public static void hienThiDanhSach() {
        if (soSachHienTai == 0) {
            System.out.println("Thư viện hiện chưa có sách nào!");
            return;
        }
        System.out.println("\n-------------------- DANH SÁCH SÁCH TRONG THƯ VIỆN --------------------");
        System.out.printf("%-10s | %-25s | %-10s | %-15s | %-15s%n",
                "Mã Sách", "Tên Sách", "Số Lượng", "Đơn Giá", "Thành Tiền");
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < soSachHienTai; i++) {
            double thanhTien = dsSoLuong[i] * dsDonGia[i];
            System.out.printf("%-10s | %-25s | %-10d | %,-15.0f | %,-15.0f%n",
                    dsMaSach[i], dsTenSach[i], dsSoLuong[i], dsDonGia[i], thanhTien);
        }
    }

    /**
     * Bài 2: Tính tổng số lượng và tổng giá trị sách bằng vòng lặp
     */
    public static void tinhTongSoLuongVaGiaTri() {
        if (soSachHienTai == 0) {
            System.out.println("Thư viện chưa có sách để thống kê!");
            return;
        }

        int tongSoLuong = 0;
        double tongGiaTri = 0;

        for (int i = 0; i < soSachHienTai; i++) {
            tongSoLuong += dsSoLuong[i];
            tongGiaTri += dsSoLuong[i] * dsDonGia[i];
        }

        System.out.println("\n--- KẾT QUẢ THỐNG KÊ (BÀI 2) ---");
        System.out.println("Tổng số đầu sách: " + soSachHienTai);
        System.out.println("Tổng số lượng sách: " + tongSoLuong + " cuốn");
        System.out.printf("Tổng giá trị sách: %,.0f VNĐ%n", tongGiaTri);
    }

    /**
     * Bài 4: Tìm sách theo mã bằng vòng lặp
     */
    public static void timSachTheoMa(Scanner sc) {
        if (soSachHienTai == 0) {
            System.out.println("Thư viện chưa có sách nào để tìm kiếm!");
            return;
        }

        System.out.print("Nhập mã sách cần tìm: ");
        String maCanTim = sc.nextLine().trim();
        boolean timThay = false;

        for (int i = 0; i < soSachHienTai; i++) {
            if (dsMaSach[i].equalsIgnoreCase(maCanTim)) {
                System.out.println("\n-> Đã tìm thấy sách tại vị trí thứ " + (i + 1) + ":");
                System.out.println("   Mã sách  : " + dsMaSach[i]);
                System.out.println("   Tên sách : " + dsTenSach[i]);
                System.out.println("   Số lượng : " + dsSoLuong[i]);
                System.out.printf("   Đơn giá  : %,.0f VNĐ%n", dsDonGia[i]);
                System.out.printf("   Giá trị  : %,.0f VNĐ%n", dsSoLuong[i] * dsDonGia[i]);
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("-> Không tìm thấy sách có mã: " + maCanTim);
        }
    }
}