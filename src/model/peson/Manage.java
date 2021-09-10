package model.peson;

import model.account.Account;

public class Manage extends Person {
    private String position;

    public Manage(Account account, String role, String position) {
        super(account, role);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "position='" + position + '\'' +
                '}';
    }
}
