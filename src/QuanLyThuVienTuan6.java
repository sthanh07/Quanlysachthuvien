import java.util.ArrayList;
import java.util.Scanner;

/**
 * BÀI THỰC HÀNH TUẦN 6: MẢNG VÀ DANH SÁCH (LIST) TRONG JAVA
 * Nâng cấp từ Bài thực hành Tuần 5 sang sử dụng Mảng 1 chiều và ArrayList:
 * - Bài 1: Mảng int[] soLuong cho 5 cuốn sách (Hiển thị, tính tổng, tìm max)
 * - Bài 2: ArrayList<String> lưu mã sách (Thêm, hiển thị, tìm, xóa mã sách)
 * - Bài 3: ArrayList<String> danhSachSach lưu thông tin sách (Thêm, hiển thị, tìm, xóa, sửa)
 * - Bài 4: Menu hoàn chỉnh 8 chức năng (1. Thêm sách, 2. Hiển thị sách, 3. Tìm sách,
 *          4. Xóa sách, 5. Sửa sách, 6. Tính tổng số lượng, 7. Tính tổng giá trị, 8. Thoát)
 *          + Tùy chọn chạy Bài 1 & Bài 2 để kiểm tra riêng.
 */
public class QuanLyThuVienTuan6 {

    // Bài 3 & Bài 4: ArrayList<String> danhSachSach
    // Mỗi phần tử lưu chuỗi định dạng: "MaSach | TenSach | SoLuong | DonGia"
    private static ArrayList<String> danhSachSach = new ArrayList<>();

    // Bài 2: ArrayList<String> lưu mã sách
    private static ArrayList<String> dsMaSach = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luaChon;

        // Bài 4: Xây dựng menu hoàn chỉnh từ 1 đến 8 (kèm lựa chọn 9, 10 để chạy Bài 1, Bài 2)
        do {
            System.out.println("\n================ MENU QUẢN LÝ THƯ VIỆN (TUẦN 6) ================");
            System.out.println("1. Thêm sách (ArrayList<String> danhSachSach)");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng sách");
            System.out.println("7. Tính tổng giá trị sách");
            System.out.println("8. Thoát");
            System.out.println("----------------------------------------------------------------");
            System.out.println("9. [Bài 1] Mảng int[] soLuong (5 cuốn sách: hiển thị, tổng, max)");
            System.out.println("10.[Bài 2] Quản lý ArrayList<String> mã sách (thêm, hiển thị, tìm, xóa)");
            System.out.println("================================================================");
            System.out.print("Mời bạn chọn chức năng (1-10): ");

            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ (1-10): ");
                sc.next();
            }
            luaChon = sc.nextInt();
            sc.nextLine(); // Xóa bộ đệm dòng

            switch (luaChon) {
                case 1:
                    themSach(sc);
                    break;
                case 2:
                    hienThiSach();
                    break;
                case 3:
                    timSach(sc);
                    break;
                case 4:
                    xoaSach(sc);
                    break;
                case 5:
                    suaSach(sc);
                    break;
                case 6:
                    tinhTongSoLuong();
                    break;
                case 7:
                    tinhTongGiaTri();
                    break;
                case 8:
                    System.out.println("Đã thoát chương trình Quản lý Thư viện Tuần 6. Tạm biệt!");
                    break;
                case 9:
                    bai1MangSoLuong(sc);
                    break;
                case 10:
                    bai2QuanLyMaSach(sc);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 10.");
            }
        } while (luaChon != 8);

        sc.close();
    }

    // =========================================================================
    // BÀI 1: Tạo mảng int[] soLuong cho 5 cuốn sách (Hiển thị, tính tổng, tìm max)
    // =========================================================================
    public static void bai1MangSoLuong(Scanner sc) {
        int[] soLuong = new int[5];
        System.out.println("\n--- BÀI 1: NHẬP SỐ LƯỢNG CỦA 5 CUỐN SÁCH ---");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print("Nhập số lượng cuốn sách thứ " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                System.out.print("Vui lòng nhập số nguyên hợp lệ: ");
                sc.next();
            }
            soLuong[i] = sc.nextInt();
        }
        sc.nextLine();

        // Hiển thị số lượng, tính tổng, tìm số lượng lớn nhất
        int tong = 0;
        int max = soLuong[0];
        System.out.print("Số lượng 5 cuốn sách vừa nhập: ");
        for (int i = 0; i < soLuong.length; i++) {
            System.out.print(soLuong[i] + (i < soLuong.length - 1 ? ", " : "\n"));
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tổng số lượng 5 cuốn sách: " + tong);
        System.out.println("Số lượng lớn nhất: " + max);
    }

    // =========================================================================
    // BÀI 2: Sử dụng ArrayList<String> để lưu mã sách (Thêm, hiển thị, tìm, xóa)
    // =========================================================================
    public static void bai2QuanLyMaSach(Scanner sc) {
        int chon;
        do {
            System.out.println("\n--- BÀI 2: QUẢN LÝ MÃ SÁCH (ArrayList<String>) ---");
            System.out.println("1. Thêm mã sách (add)");
            System.out.println("2. Hiển thị danh sách mã sách (get, size)");
            System.out.println("3. Tìm mã sách (contains / indexOf)");
            System.out.println("4. Xóa mã sách (remove)");
            System.out.println("0. Quay lại Menu chính");
            System.out.print("Chọn thao tác (0-4): ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Nhập lại (0-4): ");
            }
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã sách cần thêm: ");
                    String maMoi = sc.nextLine().trim();
                    dsMaSach.add(maMoi);
                    System.out.println("-> Đã thêm mã sách: " + maMoi);
                    break;
                case 2:
                    System.out.println("Danh sách mã sách (" + dsMaSach.size() + " mã): " + dsMaSach);
                    break;
                case 3:
                    System.out.print("Nhập mã sách cần tìm: ");
                    String maTim = sc.nextLine().trim();
                    if (dsMaSach.contains(maTim)) {
                        System.out.println("-> Tìm thấy mã '" + maTim + "' tại vị trí index = " + dsMaSach.indexOf(maTim));
                    } else {
                        System.out.println("-> Không tìm thấy mã sách '" + maTim + "'");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    String maXoa = sc.nextLine().trim();
                    if (dsMaSach.remove(maXoa)) {
                        System.out.println("-> Đã xóa mã sách: " + maXoa);
                    } else {
                        System.out.println("-> Mã sách không tồn tại để xóa!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }

    // =========================================================================
    // BÀI 3 & BÀI 4: Quản lý ArrayList<String> danhSachSach và Menu 8 chức năng
    // Định dạng mỗi phần tử String: "MaSach|TenSach|SoLuong|DonGia"
    // =========================================================================

    // 1. Thêm sách
    public static void themSach(Scanner sc) {
        System.out.println("\n--- 1. THÊM SÁCH MỚI ---");
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine().trim();

        // Kiểm tra trùng mã sách
        if (timViTriTheoMa(maSach) != -1) {
            System.out.println("-> Mã sách '" + maSach + "' đã tồn tại! Vui lòng dùng chức năng Sửa sách.");
            return;
        }

        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine().trim();

        System.out.print("Nhập số lượng: ");
        while (!sc.hasNextInt()) {
            System.out.print("Số lượng phải là số nguyên! Nhập lại: ");
            sc.next();
        }
        int soLuong = sc.nextInt();

        System.out.print("Nhập đơn giá (VNĐ): ");
        while (!sc.hasNextDouble()) {
            System.out.print("Đơn giá phải là số! Nhập lại: ");
            sc.next();
        }
        double donGia = sc.nextDouble();
        sc.nextLine();

        String thongTinSach = maSach + "|" + tenSach + "|" + soLuong + "|" + donGia;
        danhSachSach.add(thongTinSach);
        dsMaSach.add(maSach);
        System.out.println("-> Đã thêm sách thành công vào danhSachSach!");
    }

    // 2. Hiển thị sách
    public static void hienThiSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Danh sách sách hiện đang trống!");
            return;
        }
        System.out.println("\n-------------------- DANH SÁCH SÁCH TRONG THƯ VIỆN --------------------");
        System.out.printf("%-10s | %-25s | %-10s | %-15s | %-15s%n",
                "Mã Sách", "Tên Sách", "Số Lượng", "Đơn Giá", "Thành Tiền");
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            String ma = parts[0];
            String ten = parts[1];
            int sl = Integer.parseInt(parts[2]);
            double gia = Double.parseDouble(parts[3]);
            System.out.printf("%-10s | %-25s | %-10d | %,-15.0f | %,-15.0f%n",
                    ma, ten, sl, gia, sl * gia);
        }
    }

    // 3. Tìm sách
    public static void timSach(Scanner sc) {
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Danh sách sách đang trống!");
            return;
        }
        System.out.print("Nhập mã sách hoặc từ khóa tên sách cần tìm: ");
        String tuKhoa = sc.nextLine().trim().toLowerCase();
        boolean timThay = false;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String thongTin = danhSachSach.get(i);
            String[] parts = thongTin.split("\\|");
            if (parts[0].toLowerCase().contains(tuKhoa) || parts[1].toLowerCase().contains(tuKhoa)) {
                System.out.printf("-> [Vị trí %d] Mã: %s | Tên: %s | Số lượng: %s | Đơn giá: %,.0f VNĐ%n",
                        i, parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("-> Không tìm thấy cuốn sách nào khớp với từ khóa: " + tuKhoa);
        }
    }

    // 4. Xóa sách
    public static void xoaSach(Scanner sc) {
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Danh sách sách đang trống!");
            return;
        }
        System.out.print("Nhập mã sách cần xóa: ");
        String maXoa = sc.nextLine().trim();
        int index = timViTriTheoMa(maXoa);

        if (index != -1) {
            String daXoa = danhSachSach.remove(index);
            dsMaSach.remove(maXoa);
            System.out.println("-> Đã xóa sách: " + daXoa.replace("|", " - "));
        } else {
            System.out.println("-> Không tìm thấy sách có mã: " + maXoa);
        }
    }

    // 5. Sửa sách
    public static void suaSach(Scanner sc) {
        if (danhSachSach.isEmpty()) {
            System.out.println("-> Danh sách sách đang trống!");
            return;
        }
        System.out.print("Nhập mã sách cần sửa: ");
        String maSua = sc.nextLine().trim();
        int index = timViTriTheoMa(maSua);

        if (index == -1) {
            System.out.println("-> Không tìm thấy sách có mã: " + maSua);
            return;
        }

        System.out.println("Thông tin hiện tại: " + danhSachSach.get(index).replace("|", " | "));
        System.out.print("Nhập tên sách mới: ");
        String tenMoi = sc.nextLine().trim();

        System.out.print("Nhập số lượng mới: ");
        while (!sc.hasNextInt()) {
            System.out.print("Số lượng phải là số nguyên! Nhập lại: ");
            sc.next();
        }
        int soLuongMoi = sc.nextInt();

        System.out.print("Nhập đơn giá mới (VNĐ): ");
        while (!sc.hasNextDouble()) {
            System.out.print("Đơn giá phải là số! Nhập lại: ");
            sc.next();
        }
        double donGiaMoi = sc.nextDouble();
        sc.nextLine();

        String thongTinMoi = maSua + "|" + tenMoi + "|" + soLuongMoi + "|" + donGiaMoi;
        danhSachSach.set(index, thongTinMoi);
        System.out.println("-> Đã cập nhật thông tin sách có mã '" + maSua + "' thành công!");
    }

    // 6. Tính tổng số lượng
    public static void tinhTongSoLuong() {
        int tongSoLuong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            tongSoLuong += Integer.parseInt(parts[2]);
        }
        System.out.println("-> Tổng số lượng sách hiện có trong thư viện: " + tongSoLuong + " cuốn");
    }

    // 7. Tính tổng giá trị
    public static void tinhTongGiaTri() {
        double tongGiaTri = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            int soLuong = Integer.parseInt(parts[2]);
            double donGia = Double.parseDouble(parts[3]);
            tongGiaTri += soLuong * donGia;
        }
        System.out.printf("-> Tổng giá trị sách trong thư viện: %,.0f VNĐ%n", tongGiaTri);
    }

    // Hàm phụ trợ: Tìm vị trí index của sách trong ArrayList theo mã sách
    private static int timViTriTheoMa(String maSach) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] parts = danhSachSach.get(i).split("\\|");
            if (parts[0].equalsIgnoreCase(maSach)) {
                return i;
            }
        }
        return -1;
    }
}