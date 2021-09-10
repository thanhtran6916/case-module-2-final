package model.product;

import model.peson.Seller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String description;
    private String category;
    private int count;
    private Seller seller;
    private ArrayList<String> comments;

    public Product(String name, double price, String description, String category, Seller seller) {
        this.id = String.valueOf(System.currentTimeMillis()) + " " + seller.getLicense();
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.count = 0;
        this.seller = seller;
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String comment : comments) {
            stringBuilder.append("   " + comment + "\n");
        }
        return "_____Product_____" +
                "Id: " + id + "\n" +
                "Tên sản phẩm: " + name + "\n" +
                "Giá sản phẩm: " + price + "\n" +
                "Mô tả: " + description + "\n" +
                "Danh mục sản phẩm: " + category + "\n" +
                "Số lượng đã mua: " + count + "\n" +
                "Tên người bán: " + seller.getAccount().getName() + "\n" +
                "SDT người bán: " + seller.getPhone() + "\n" +
                "Địa chỉ người bán: " + seller.getAddress() + "\n" +
                "Comments: " + stringBuilder + "\n"
                ;
    }
}
