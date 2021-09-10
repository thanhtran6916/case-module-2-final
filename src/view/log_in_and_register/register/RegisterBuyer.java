package view.log_in_and_register.register;

import model.account.Account;
import model.peson.Buyer;
import view.error.Error;


import static view.Constant.*;

public class RegisterBuyer {
    public static void run() {
        int choose;
        Buyer buyer = inputBuyer();
        if (Register.checkAccount(buyer)) return;
        System.out.println("Kiểm tra lại thông tin tài khoản");
        System.out.println(buyer);
        menu();
        choose = Error.inputMismatchError();
        Error.selectionInputError(choose, 1, 3);
        do {
            switch (choose) {
                case 1:
                    people.add(buyer);
                    break;
                case 2:
                    run();
                    break;
            }
        } while (choose != 1 && choose != 3);
    }

    public static Buyer inputBuyer() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        boolean checkPhoneNumber;
        String phoneNumber = "";
        do {
            System.out.println("Nhập số điện thoại");
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = Error.styleNumberPhoneError(phoneNumber);
        } while (!checkPhoneNumber);
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        Account account = new Account(name, password);
        return new Buyer(account, BUYER, phoneNumber, address);
    }

    public static void menu() {
        System.out.println("1. Đồng ý");
        System.out.println("2. Nhập lại");
        System.out.println("3. Hủy");
    }

}
