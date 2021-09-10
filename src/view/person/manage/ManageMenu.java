package view.person.manage;

import model.peson.Manage;

import static view.Constant.*;

public class ManageMenu {
    public static void run(Manage manage) {
        String position = manage.getPosition();
        switch (position) {
            case ADMIN:
                AdminMenu.run(manage);
                break;
            case STAFF:
                StaffMenu.run(manage);
                break;
        }


    }
}
