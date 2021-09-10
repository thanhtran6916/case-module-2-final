package view.log_in_and_register;

import model.product.Product;
import view.error.Error;
import view.log_in_and_register.log_in.LogIn;
import view.log_in_and_register.register.Register;

import static view.Constant.*;


public class LogInAndRegister {
    public static void run() {
        people.read();
        if (people.getPeople().size() == 0) {
            people.add(ADMIN_PERSON);
        }
        products.read();
        int choose;
        do {
            System.out.println("------------ỨNG DỤNG MUA SẮM------------");
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    LogIn.run();
                    break;
                case 2:
                    Register.run();
                    break;
                case 4:
                    for (Product product : products.getProducts()) {
                        System.out.println(product);
                    }
            }
        } while (choose != 3);
        people.save();
        products.save();
    }

    public static void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }

}
