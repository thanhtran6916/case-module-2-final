package view.person.manage;

import model.peson.Manage;
import view.error.Error;

public class StaffMenu {
    public static void run(Manage manage) {
        int choose;
        do {
            menuStaff();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 4);
            switch (choose) {
                case 1:
                    AdminMenu.showSellerRegister();
                    break;
                case 2:
                    AdminMenu.addSeller();
                    break;
                case 3:
                    AdminMenu.removeSeller();
                    break;
            }
        } while (choose != 4);
    }

    public static void menuStaff() {
        System.out.println("------------Nhân viên------------");
        System.out.println("1. Hiển thị người đăng ký bán hàng trên hệ thống");
        System.out.println("2. Thêm người bán hàng");
        System.out.println("3. Xóa người bán hàng");
        System.out.println("4. Thoát");
        System.out.println("Nhập lựa chọn");
    }
}
