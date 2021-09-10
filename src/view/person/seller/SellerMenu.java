package view.person.seller;

import model.peson.Seller;
import model.product.Product;
import view.error.Error;

import java.util.ArrayList;
import java.util.Iterator;

import static view.Constant.*;


public class SellerMenu {
    private static ArrayList<Product> productStore = new ArrayList<>();

    public static void run(Seller seller) {
        productStore = getProductStore(seller);
        int choose;
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    addProduct(seller);
                    break;
                case 2:
                    showProduct(productStore);
                    break;
            }
        } while (choose != 3);
    }

    public static void addProduct(Seller seller) {
        Product product = ProductMenu.inputProduct(seller);
        products.add(product);
        productStore.add(product);
    }

    public static void showProduct(ArrayList<Product> products) {
        int count = 5;
        Iterator<Product> productIterator = products.iterator();
        ArrayList<Product> products1 = get5Product(count, productIterator);
        if (products1.size() == 0) {
            System.out.println("Gian hàng của bạn không có sản phẩm nào.");
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
                        editAndRemoveProduct(product);
                        return;
                    }
                    case 3: {
                        Product product = products1.get(1);
                        editAndRemoveProduct(product);
                        return;
                    }
                    case 4: {
                        Product product = products1.get(2);
                        editAndRemoveProduct(product);
                        return;
                    }
                    case 5: {
                        Product product = products1.get(3);
                        editAndRemoveProduct(product);
                        return;
                    }
                    case 6: {
                        Product product = products1.get(4);
                        editAndRemoveProduct(product);
                        return;
                    }

                }
            } while (true);
        }
    }

    public static ArrayList<Product> getProductStore(Seller seller) {
        ArrayList<Product> productsStore = new ArrayList<>();
        for (Product product : products.getProducts()) {
            if (seller.getAccount().equals(product.getSeller().getAccount())) {
                productsStore.add(product);
            }
        }
        return productsStore;
    }


    public static void menu() {
        System.out.println("-----------MENU BÁN HÀNG-----------");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị tất cả sản phẩm trong shop");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }


    private static void editAndRemoveProduct(Product product) {
        int choose;
        do {
            menuEditAndRemoveProduct();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    ProductMenu.editProduct(product);
                    return;
                case 2:
                    removeProduct(product);
                    return;
            }
        } while (choose != 3);
    }

    public static void removeProduct(Product product) {
        products.remove(product);
        productStore.remove(product);
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


    public static void menuEditAndRemoveProduct() {
        System.out.println("1. Sửa sản phẩm");
        System.out.println("2. Xóa sản phẩm");
        System.out.println("3. Thoát");
        System.out.println("Nhập lựa chọn");
    }

    public static void menuShow5Product(ArrayList<Product> products1) {
        System.out.println("-----------Sản phẩm-----------");
        System.out.println("0. Xem tiếp");
        System.out.println("1. Thoát");
        int count = 2;
        for (Product product : products1) {
            System.out.println(count + ". " + product);
            count++;
        }
        System.out.println("Nhập lựa chọn sản phẩm");
    }
}
