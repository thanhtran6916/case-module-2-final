package view.log_in_and_register.log_in;

import model.account.Account;
import model.peson.Buyer;
import model.peson.Manage;
import model.peson.Person;
import model.peson.Seller;
import view.person.buyer.BuyerMenu;
import view.person.manage.ManageMenu;
import view.person.seller.SellerMenu;

import static view.Constant.*;

public class LogIn {
    public static void run() {
        Account account = inputAccount();
        Person person = checkAccount(account);
        if (person == null) {
            System.err.println("Thông tin tài khoản không chính xác.");
        } else {
            String role = checkRole(person);
            switch (role) {
                case BUYER:
                    Buyer buyer = (Buyer) person;
                    BuyerMenu.run(buyer);
                    break;
                case SELLER:
                    Seller seller = (Seller) person;
                    if (seller.isStatus()) {
                        SellerMenu.run(seller);
                    } else {
                        System.err.println("Tài khoản chưa được phê duyệt thành công");
                    }
                    break;
                case ADMIN:
                    Manage manage = (Manage) person;
                    ManageMenu.run(manage);
                    break;
            }
        }
    }

    public static String checkRole(Person person) {
        return person.getRole();
    }

    public static Person checkAccount(Account account) {
        Person person = null;
        for (Person person1 : people.getPeople()) {
            if (account.equals(person1.getAccount())) {
                person = person1;
                break;
            }
        }
        return person;
    }

    public static Account inputAccount() {
        System.out.println("Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        return new Account(name, password);
    }
}
