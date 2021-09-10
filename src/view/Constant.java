package view;

import controller.PersonManagement;
import controller.ProductManagement;
import model.account.Account;
import model.peson.Manage;

import java.util.Scanner;

public class Constant {
    public static final Scanner scanner = new Scanner(System.in);

    public static final String ADMIN = "admin";

    public static final Manage ADMIN_PERSON = new Manage(new Account("admin", "123"), ADMIN, ADMIN);

    public static final String PERSON_DATA = "E:\\CodeGym\\mua-ban-san-pham-ver3\\data\\personData.txt";

    public static final String PRODUCT_DATA = "E:\\CodeGym\\mua-ban-san-pham-ver3\\data\\productData.txt";

    public static final String BUYER = "buyer";

    public static final String SELLER = "seller";

    public static final String STAFF = "staff";

    public static final String END = "--------------------------------------------------------";

    public static PersonManagement people = new PersonManagement();

    public static  ProductManagement products = new ProductManagement();

    public static final String PHONE_LAPTOP_TABLET = "phone, laptop, tablet";

    public static final String TV_SPEAKER = "tv, speaker";

    public static final String AIR_CONDITIONING = "air conditioning";

    public static final String WASHING_DRYER_MACHINE = "washing machine, dryer";

    public static final String KITCHEN_TOOLS = "kitchen tools";


}
