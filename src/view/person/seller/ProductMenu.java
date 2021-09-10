package view.person.seller;

import model.peson.Seller;
import model.product.Product;
import view.error.Error;

import static view.Constant.*;

public class ProductMenu {



    public static Product editProduct(Product product) {
        String[] informationProduct = inputInformation();
        String name = informationProduct[0];
        double price = Double.parseDouble(informationProduct[1]);
        String description = informationProduct[2];
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return product;
    }



    public static Product inputProduct(Seller seller) {
        String[] informationProduct = inputInformation();
        String name = informationProduct[0];
        double price = Double.parseDouble(informationProduct[1]);
        String description = informationProduct[2];
        String category = inputCategory();
        return new Product(name, price, description, category, seller);
    }

    private static String[] inputInformation() {
        String[] productInfomation = new String[3];
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        productInfomation[0] = name;

        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextDouble();
        productInfomation[1] = String.valueOf(price);
        scanner.nextLine();

        System.out.println("Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        productInfomation[2] = description;

        return productInfomation;
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

    public static void menuCategory() {
        System.out.println("------------DANH MỤC SẢN PHẨM------------");
        System.out.println("1. Điện thoại, Laptop, Tablet");
        System.out.println("2. Tivi, Loa, Dàn Karaoke");
        System.out.println("3. Máy lạnh, Quạt điều hòa");
        System.out.println("4. Máy giặt, Sấy quần áo");
        System.out.println("5. Đồ dùng nhà bếp");
        System.out.println("Nhập lựa chọn");
    }


}
