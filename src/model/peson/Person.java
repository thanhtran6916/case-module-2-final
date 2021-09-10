package model.peson;

import model.account.Account;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private Account account;
    private String role;

    public Person(Account account, String role) {
        this.account = account;
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "account=" + account +
                ", role='" + role + '\'' +
                '}';
    }
}
