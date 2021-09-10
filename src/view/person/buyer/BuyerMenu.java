package view.person.buyer;

import model.peson.Buyer;
import model.product.Product;
import view.error.Error;
import view.person.bill.BillOrderMenu;
import view.person.bill.BuyerBillMenu;

import java.util.ArrayList;
import java.util.Iterator;

import static view.Constant.*;
import static view.Constant.KITCHEN_TOOLS;

public class BuyerMenu {

    public static void run(Buyer buyer) {
        int choose = -1;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 6);
            switch (choose) {
                case 1:
                    showProductTop(buyer);
                    break;
                case 2:
                    showCategory(buyer);
                    break;
                case 3:
                    showPriceIncrease(buyer);
                    break;
                case 4:
                    showPriceReduce(buyer);
                    break;
                case 5:
                    viewCart(buyer);
                    break;
                case 7:
                    for (Product product : buyer.getCart()) {
                        System.out.println(product);
                    }
                    break;
            }
        } while (choose != 6);
    }

    private static void viewCart(Buyer buyer) {
        int choose;
        do {
            menuViewCart();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    BillOrderMenu.orderProduct(buyer.getCart(), buyer);
                    break;
                case 2:
                    BuyerBillMenu.run(buyer);
                    break;
            }
        } while (choose != 3);

    }

    private static void menuViewCart() {
        System.out.println("1. Hiển thị toàn bộ giỏ hàng");
        System.out.println("2. Hiển thị hóa đơn");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }

    private static void showPriceReduce(Buyer buyer) {
        products.sortPriceReduce();
        showProduct(products.getProducts(), buyer);
    }

    private static void showPriceIncrease(Buyer buyer) {
        products.sortPriceIncrease();
        showProduct(products.getProducts(), buyer);
    }

    private static void showProductTop(Buyer buyer) {
        products.sortCountReduce();
        showProduct(products.getProducts(), buyer);
    }

    private static void showCategory(Buyer buyer) {
        String category = inputCategory();
        ArrayList<Product> productsCategory = getProductCategory(category);
        showProduct(productsCategory, buyer);
    }


    public static String inputCategory() {
        System.out.println("Nhập danh mục sản phẩm");
        String category = null;
        int choose;
        do {
            menuCategory();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 5);
            switch (choose) {
                case 1:
                    category = PHONE_LAPTOP_TABLET;
                    break;
                case 2:
                    category = TV_SPEAKER;
                    break;
                case 3:
                    category = AIR_CONDITIONING;
                    break;
                case 4:
                    category = WASHING_DRYER_MACHINE;
                    break;
                case 5:
                    category = KITCHEN_TOOLS;
                    break;
            }
        } while (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 5);

        return category;
    }

    private static ArrayList<Product> getProductCategory(String category) {
        ArrayList<Product> products1 = new ArrayList<>();
        for (Product product : products.getProducts()) {
            if (product.getCategory().equals(category)) {
                products1.add(product);
            }
        }
        return products1;
    }

    public static void menuCategory() {
        System.out.println("------------DANH MỤC SẢN PHẨM------------");
        System.out.println("1. Điện thoại, Laptop, Tablet");
        System.out.println("2. Tivi, Loa, Dàn Karaoke");
        System.out.println("3. Máy lạnh, Quạt điều hòa");
        System.out.println("4. Máy giặt, Sấy quần áo");
        System.out.println("5. Đồ dùng nhà bếp");
        System.out.println("Nhập lựa chọn");
    }

    public static void showProduct(ArrayList<Product> products, Buyer buyer) {
        int count = 5;
        Iterator<Product> productIterator = products.iterator();
        ArrayList<Product> products1 = get5Product(count, productIterator);
        if (products1.size() == 0) {
            System.out.println("Gian hàng không có sản phẩm nào.");
        } else {
            int choose;
            menuShow5Product(products1);
            do {
                choose = Error.inputMismatchError();
                int firstChoose = 0;
                int lastChoose = products1.size() + 1;
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
                        return;
                    }
                    case 2: {
                        Product product = products1.get(0);
                        addToCart(product, buyer);
                        return;
                    }
                    case 3: {
                        Product product = products1.get(1);
                        addToCart(product, buyer);
                        return;
                    }
                    case 4: {
                        Product product = products1.get(2);
                        addToCart(product, buyer);
                        return;
                    }
                    case 5: {
                        Product product = products1.get(3);
                        addToCart(product, buyer);
                        return;
                    }
                    case 6: {
                        Product product = products1.get(4);
                        addToCart(product, buyer);
                        return;
                    }
                }
            } while (true);
        }
    }

    private static void addToCart(Product product, Buyer buyer) {
        buyer.getCart().add(product);
        System.out.println("Đã thêm vào giỏ hàng");
        System.out.println("--------------------");
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
        System.out.println("1. Thoát.");
        int count = 2;
        for (Product product : products1) {
            System.out.println(count + ". " + product);
            count++;
        }
        System.out.println("Nhập lựa chọn sản phẩm");
    }

    public static void menu() {
        System.out.println("MENU MUA HÀNG");
        System.out.println("1. Xem sản phẩm bán chạy");
        System.out.println("2. Xem sản phẩm theo danh mục");
        System.out.println("3. Xem sản phẩm theo giá tăng dần");
        System.out.println("4. Xem sản phẩm theo giá giảm dần");
        System.out.println("5. Xem giỏ hàng");
        System.out.println("6. Thoát");
        System.out.println("Nhập lựa chọn");
    }

}
