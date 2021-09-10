package model.peson;

import model.account.Account;
import model.bill.Bill;

import java.util.ArrayList;

public class Seller extends Person{
    private String license;
    private String phone;
    private String address;
    private ArrayList<Bill> bills;
    private boolean status;

    public Seller(Account account, String role, String license, String phone, String address) {
        super(account, role);
        this.license = license;
        this.phone = phone;
        this.address = address;
        bills = new ArrayList<>();
        status = false;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        Account account = super.getAccount();
        return "________Seller________" + '\n' +
                "Tên người bán: " + account.getName() + '\n' +
                "Tình trạng đăng ký: " + status + '\n' +
                "Mã số giấy phép kinh doanh: " + license + '\n' +
                "Điện thoại: " + phone + '\n' +
                "Địa chỉ: " + address + '\n' +
                "---------------------" + "\n"
                ;
    }
}
