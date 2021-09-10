package model.peson;

import model.account.Account;
import model.bill.Bill;
import model.product.Product;

import java.util.ArrayList;

public class Buyer extends Person {
    private String phone;
    private String address;
    private ArrayList<Product> cart;
    private int point;
    private ArrayList<Bill> bills;


    public Buyer(Account account, String role, String phone, String address) {
        super(account, role);
        this.phone = phone;
        this.address = address;
        point = 0;
        cart = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        Account account = super.getAccount();
        return "__________Buyer__________" + '\n' +
                "Tên tài khoản: " + account.getName() + '\n' +
                "Mật khẩu: " + account.getPassword() + '\n' +
                "Số điện thoại: " + phone + '\n' +
                "Địa chỉ: " + address + '\n'
                ;
    }
}
