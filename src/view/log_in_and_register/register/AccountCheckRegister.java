package view.log_in_and_register.register;

import model.account.Account;
import model.peson.Person;

import static view.Constant.people;

public class AccountCheckRegister {
    public static boolean checkAccountRegister(Account accountCheck) {
        boolean check = false;
        for (Person person : people.getPeople()) {
            if (person.getAccount().getName().equals(accountCheck.getName())) {
                check = true;
                break;
            }
        }
        return check;
    }
}
