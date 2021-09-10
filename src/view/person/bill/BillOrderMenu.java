package view.person.bill;

import model.bill.Bill;
import model.peson.Buyer;
import model.product.Product;
import view.error.Error;

import java.util.ArrayList;
import java.util.Iterator;

public class BillOrderMenu {
    public static Bill inputBill(Product product, Buyer buyer) {
        System.out.println("Nhập số lượng mua");
        int quantity;
        do {
            quantity = Error.inputMismatchError();
            Error.selectionInputError(quantity, 1, Integer.MAX_VALUE);
        } while (quantity < 0);
        return new Bill(product, buyer, quantity);
    }

    public static void orderProduct(ArrayList<Product> products, Buyer buyer) {
        int count = 5;
        Iterator<Product> productIterator = products.iterator();
        ArrayList<Product> products1 = get5Product(count, productIterator);
        if (products1.size() == 0) {
            System.out.println("Giỏ hàng của bạn không có sản phẩm nào.");
        } else {
            int choose;
            menuShow5Product(products1);
            do {
                choose = Error.inputMismatchError();
                int firstChoose = 0;
                int lastChoose = products1.size();
                boolean check = Error.selectionInputError(choose, firstChoose, lastChoose);
                if (!check) {
                    continue;
                }
                switch (choose) {
                    case 0:
                        products1 = get5Product(count, productIterator);
                        if (products1.size() == 0) {
                            System.out.println("Không còn sản phẩm nào.");
                            return;
                        }
                        menuShow5Product(products1);
                        break;
                    case 1: {
                        Product product = products1.get(0);
                        Bill bill = inputBill(product, buyer);
                        buyer.getBills().add(bill);
                        product.getSeller().getBills().add(bill);
                        return;
                    }
                    case 2: {
                        Product product = products1.get(1);
                        Bill bill = inputBill(product, buyer);
                        buyer.getBills().add(bill);
                        product.getSeller().getBills().add(bill);
                        return;
                    }
                    case 3: {
                        Product product = products1.get(2);
                        Bill bill = inputBill(product, buyer);
                        buyer.getBills().add(bill);
                        product.getSeller().getBills().add(bill);
                        return;
                    }
                    case 4: {
                        Product product = products1.get(3);
                        Bill bill = inputBill(product, buyer);
                        buyer.getBills().add(bill);
                        product.getSeller().getBills().add(bill);
                        return;
                    }
                    case 5: {
                        Product product = products1.get(4);
                        Bill bill = inputBill(product, buyer);
                        buyer.getBills().add(bill);
                        product.getSeller().getBills().add(bill);
                        return;
                    }
                }
            } while (choose != 0);
        }
    }

    private static ArrayList<Product> get5Product(int count, Iterator<Product> productIterator) {
        ArrayList<Product> products1 = new ArrayList<>();
        Product product;
        while (productIterator.hasNext()) {
            product = productIterator.next();
            products1.add(product);
            count--;
            if (count == 0) {
                break;
            }
        }
        return products1;
    }

    public static void menuShow5Product(ArrayList<Product> products1) {
        System.out.println("-----------Sản phẩm-----------");
        System.out.println("0. Xem tiếp");
        int count = 1;
        for (Product product : products1) {
            System.out.println(count + ". " + product);
            count++;
        }
        System.out.println("Nhập lựa chọn sản phẩm");
    }

}
