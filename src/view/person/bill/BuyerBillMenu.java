package view.person.bill;

import model.bill.Bill;
import model.peson.Buyer;
import model.product.Product;
import view.error.Error;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import static view.Constant.products;
import static view.Constant.scanner;

public class BuyerBillMenu {

    public static void run(Buyer buyer) {
        int choose;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    unpaidMenu(buyer);
                    break;
                case 2:
                    paidMenu(buyer);
                    break;
            }
        } while (choose != 3);

    }

    private static ArrayList<Bill> get5Bill(int count, Iterator<Bill> billIterator) {
        ArrayList<Bill> bills = new ArrayList<>();
        Bill bill;
        while (billIterator.hasNext()) {
            bill = billIterator.next();
            bills.add(bill);
            count--;
            if (count == 0) {
                break;
            }
        }
        return bills;
    }

    public static void menuShow5Bill(ArrayList<Bill> bills) {
        System.out.println("-----------Hóa đơn của bạn-----------");
        System.out.println("0. Xem tiếp");
        int count = 1;
        for (Bill bill : bills) {
            System.out.println(count + ". " + bill);
            count++;
        }
        System.out.println("Nhập lựa chọn hóa đơn");
    }

    public static void paidMenu(Buyer buyer) {
        ArrayList<Bill> bills = new ArrayList<>();
        for (Bill bill : buyer.getBills()) {
            if (bill.isStatus()) {
                bills.add(bill);
            }
        }
        int count = 5;
        Iterator<Bill> billIterator = bills.iterator();
        ArrayList<Bill> bill1 = get5Bill(count, billIterator);
        if (bill1.size() == 0) {
            System.out.println("Không có hóa đơn nào.");
        } else {
            int choose;
            menuShow5Bill(bill1);
            do {
                choose = Error.inputMismatchError();
                int firstChoose = 0;
                int lastChoose = bill1.size();
                boolean check = Error.selectionInputError(choose, firstChoose, lastChoose);
                if (!check) {
                    continue;
                }
                switch (choose) {
                    case 0:
                        bill1 = get5Bill(count, billIterator);
                        if (bill1.size() == 0) {
                            System.out.println("Không còn hóa đơn nào.");
                            return;
                        }
                        menuShow5Bill(bill1);
                        break;
                    case 1: {
                        Bill bill = bill1.get(0);
                        System.out.println(bill);
                        return;
                    }
                    case 2: {
                        Bill bill = bill1.get(1);
                        System.out.println(bill);
                        return;
                    }
                    case 3: {
                        Bill bill = bill1.get(2);
                        System.out.println(bill);
                        return;
                    }
                    case 4: {
                        Bill bill = bill1.get(3);
                        System.out.println(bill);
                        return;
                    }
                    case 5: {
                        Bill bill = bill1.get(4);
                        System.out.println(bill);
                        return;
                    }
                }
            } while (choose != 0);
        }

    }

    public static void unpaidMenu(Buyer buyer) {
        ArrayList<Bill> bills = new ArrayList<>();
        for (Bill bill : buyer.getBills()) {
            if (!bill.isStatus()) {
                bills.add(bill);
            }
        }
        int count = 5;
        Iterator<Bill> billIterator = bills.iterator();
        ArrayList<Bill> bill1 = get5Bill(count, billIterator);
        if (bill1.size() == 0) {
            System.out.println("Không có hóa đơn nào.");
        } else {
            int choose;
            menuShow5Bill(bill1);
            do {
                choose = Error.inputMismatchError();
                int firstChoose = 0;
                int lastChoose = bill1.size();
                boolean check = Error.selectionInputError(choose, firstChoose, lastChoose);
                if (!check) {
                    continue;
                }
                switch (choose) {
                    case 0:
                        bill1 = get5Bill(count, billIterator);
                        if (bill1.size() == 0) {
                            System.out.println("Không còn hóa đơn nào.");
                            return;
                        }
                        menuShow5Bill(bill1);
                        break;
                    case 1: {
                        Bill bill = bill1.get(0);
                        pay(bill);
                        return;
                    }
                    case 2: {
                        Bill bill = bill1.get(1);
                        pay(bill);
                        return;
                    }
                    case 3: {
                        Bill bill = bill1.get(2);
                        pay(bill);
                        return;
                    }
                    case 4: {
                        Bill bill = bill1.get(3);
                        pay(bill);
                        return;
                    }
                    case 5: {
                        Bill bill = bill1.get(4);
                        pay(bill);
                        return;
                    }
                }
            } while (choose != 0);
        }
    }

    public static void pay(Bill bill) {
        int choose;
        do {
            payMenu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 2);
            switch (choose) {
                case 1:
                    Product product = bill.getProduct();
                    int count = product.getCount();
                    int countBuying = bill.getQuantity();
                    product.setCount(count + countBuying);
                    System.out.println("Số tiền phải thanh toán là : " + bill.getMoney());
                    bill.setStatus(true);
                    bill.setDateOfPayment(LocalDate.now());
                    System.out.println("Đánh giá sản phẩm");
                    String comment = scanner.nextLine();
                    product.getComments().add(comment);
                    System.out.println("Đã thanh toán");
                    return;
            }
        } while (choose != 2);
    }

    public static void payMenu() {
        System.out.println("1. Thanh toán");
        System.out.println("2. Thoát");
        System.out.println("Nhập lựa chọn");
    }

    public static void menu() {
        System.out.println("1. Hiển thị hóa đơn chưa thanh toán");
        System.out.println("2. Hiển thị hóa đơn đã thanh toán");
        System.out.println("3. Thoat");
        System.out.println("Nhập lựa chọn");
    }
}
