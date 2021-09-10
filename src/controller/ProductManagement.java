package controller;

import model.product.Product;
import model.product.ProductComparatorByCount;
import model.product.ProductComparatorByPriceIncrease;
import model.product.ProductComparatorByPriceReduce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static view.Constant.PRODUCT_DATA;

public class ProductManagement implements General<Product>{

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public int searchProductById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void edit(int index, Product product) {
        products.set(index, product);
    }


    @Override
    public void remove(int index) {
        products.remove(index);
    }

    @Override
    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PRODUCT_DATA);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PRODUCT_DATA);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (ArrayList<Product>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Không có dữ liệu");
            products = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void remove(Product product) {
        products.remove(product);
    }

    public void sortPriceIncrease() {
        ProductComparatorByPriceIncrease priceIncrease = new ProductComparatorByPriceIncrease();
        products.sort(priceIncrease);
    }

    public void sortPriceReduce() {
        ProductComparatorByPriceReduce priceReduce = new ProductComparatorByPriceReduce();
        products.sort(priceReduce);
    }

    public void sortCountReduce() {
        ProductComparatorByCount byCount = new ProductComparatorByCount();
        products.sort(byCount);

    }

}
