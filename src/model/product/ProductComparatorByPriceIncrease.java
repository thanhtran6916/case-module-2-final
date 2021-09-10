package model.product;

import java.util.Comparator;

public class ProductComparatorByPriceIncrease implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() - o2.getPrice() > 0) {
            return 1;
        }
        if (o1.getPrice() - o2.getPrice() < 0) {
            return -1;
        }
        return 0;
    }
}
