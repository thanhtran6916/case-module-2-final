package view.log_in_and_register.register;

import model.peson.Person;
import view.error.Error;

import static view.Constant.END;
import static view.Constant.people;

public class Register {
    public static void run() {
        int choose;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    RegisterBuyer.run();
                    return;
                case 2:
                    RegisterSeller.run();
                    return;
            }
        } while (choose != 3);

    }

    public static boolean checkAccount(Person person) {
        boolean checkAccount = AccountCheckRegister.checkAccountRegister(person.getAccount());
        if (checkAccount) {
            System.err.println("Tên tài khoản này đã tồn tại, hãy nhập lại");
            System.out.println(END);
            return true;
        }
        return false;
    }

    public static void menu() {
        System.out.println("------------ĐĂNG KÝ------------");
        System.out.println("1. Đăng ký người mua hàng");
        System.out.println("2. Đăng ký người bán hàng");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }
}
